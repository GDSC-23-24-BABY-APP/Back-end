package com.app.premom.controller;

import com.app.premom.dto.LoginRequestDto;
import com.app.premom.dto.UserSignupDto;
import com.app.premom.entity.User;
import com.app.premom.jwt.JwtTokenUtil;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class LoginController {

    private final LoginService loginService;
    @Value("${jwt.secret}")
    private String secretKey;

//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }

    // 소셜로그인
    @GetMapping("/code/{registrationId}")
    @ResponseBody
    public ResponseEntity<Object> socialLogin(@RequestParam("code") String code, @PathVariable(name="registrationId") String registrationId) {
        System.out.println("컨트롤러");
        return loginService.socialLogin(code, registrationId);
    }


    @GetMapping("/testLogin")
    public String testLogin(Authentication auth) {

        User loginUser = loginService.getLoginUserByLoginId(auth.getName());

        return String.format("loginId : %s\nusername : %s\nrole: %s",
                loginUser.getEmail(), loginUser.getUsername(), loginUser.getRole());
    }

    @PostMapping("/join")
    public Long join(@RequestBody UserSignupDto dto) {
        return loginService.join(dto);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = loginService.login(loginRequestDto);

        if (user == null) {
            return ResponseEntity.badRequest().body("로그인 아이디 또는 비밀번호가 틀렸습니다.");
        }

        long expireTimeMs = 1000 * 60 * 60 * 8; // Token 유효 시간 = 8시간
        String jwtToken = JwtTokenUtil.createToken(loginRequestDto.getEmail(), secretKey, expireTimeMs);

        // 사용자 정보를 JSON 형태로 리턴
        Map<String, Object> response = new HashMap<>();
        response.put("userId", user.getId());
        response.put("token", jwtToken);
        response.put("email", user.getEmail());
        response.put("username", user.getUsername());

        log.info("hihihibye");
        return ResponseEntity.ok(response);
    }
}
