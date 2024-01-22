package com.app.premom.service;

import com.app.premom.dto.UserSignupDto;
import com.app.premom.entity.User;
import com.app.premom.jwt.JwtTokenUtil;
import com.app.premom.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

    private final Environment env;
    private final RestTemplate restTemplate = new RestTemplate();
    private final UserRepository userRepository;
    //jwt관리
    //private final CustomAuthorityUtils authorityUtils;

    @Value("${jwt.secret}")
    private String secretKey;

//    public LoginService(Environment env) {
//        this.env = env;
//    }

    public ResponseEntity<Object> socialLogin(String code, String registrationId) {
        System.out.println("소셜로그인 함수");
        String accessToken = getAccessToken(code, registrationId);
        System.out.println("accessToken = " + accessToken);

        JsonNode userResourceNode = getUserResource(accessToken, registrationId);
        System.out.println("userResourceNode = " + userResourceNode);
        String id = userResourceNode.get("id").asText();
        String email = userResourceNode.get("email").asText();
        String username = userResourceNode.get("name").asText();

        System.out.println("id = " + id);
        System.out.println("email = " + email);
        System.out.println("nickname = " + username);

        User user = signupOrLogin(email, username);

        long expireTimeMs = 1000 * 60 * 60 * 8; // Token 유효 시간 = 8시간
        String jwtToken = JwtTokenUtil.createToken(email, secretKey, expireTimeMs);

        // 사용자 정보를 JSON 형태로 리턴
        Map<String, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("token", jwtToken);
        response.put("email", user.getEmail());
        response.put("username", user.getUsername());

        //log.info("hihihibye");
        return ResponseEntity.ok(response);
    }

    @Transactional
    public User signupOrLogin(String email, String username) {

        if (userRepository.findByEmail(email).isEmpty()) {
            //userRepository.c
            User user = userRepository.save(UserSignupDto.builder().email(email).username(username).isSocialLogin(1).build().toEntity());
            System.out.println("새로운 회원입니다. 회원가입이 진행되었습니다.");

            return user;
        }

        System.out.println("기존에 가입한 회원입니다.");

        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("회원 조회 오류"));

        return user;
    }

    private String getAccessToken(String authorizationCode, String registrationId) {
        String clientId = env.getProperty("oauth2." + registrationId + ".client-id");
        String clientSecret = env.getProperty("oauth2." + registrationId + ".client-secret");
        String redirectUri = env.getProperty("oauth2." + registrationId + ".redirect-uri");
        String tokenUri = env.getProperty("oauth2." + registrationId + ".token-uri");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", authorizationCode);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", "authorization_code");

        System.out.println("그랜트타입" + authorizationCode);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity entity = new HttpEntity(params, headers);

        ResponseEntity<JsonNode> responseNode = restTemplate.exchange(tokenUri, HttpMethod.POST, entity, JsonNode.class);
        JsonNode accessTokenNode = responseNode.getBody();
        return accessTokenNode.get("access_token").asText();
    }

    private JsonNode getUserResource(String accessToken, String registrationId) {
        String resourceUri = env.getProperty("oauth2." + registrationId + ".resource-uri");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity entity = new HttpEntity(headers);
        return restTemplate.exchange(resourceUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }

//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> service = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = service.loadUser(userRequest); // OAuth2 정보를 가져옵니다.
//
//        Map<String, Object> originAttributes = oAuth2User.getAttributes(); // OAuth2User의 attribute
//
//        // OAuth 서비스의 id (google, naver, kakao)
//        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // 소셜 정보를 가져옵니다.
//
//
//        //OAuthAttributes: OAuth2User의 attribute를 서비스 유형에 맞게 담아줄 클래스
//
//
//    }

    public User getLoginUserByLoginId(String loginId) {
        return userRepository.findByEmail(loginId).orElseThrow(() -> new IllegalArgumentException("해당 회원을 조회할 수 없습니다."));
    }
}
