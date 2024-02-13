package com.app.premom.controller;

import com.app.premom.ApiResponse;
import com.app.premom.dto.UserInfoResponseDto;
import com.app.premom.entity.User;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/login/oauth2", produces = "application/json")
public class LoginController {

    private final LoginService loginService;
    @Value("${jwt.secret}")
    private String secretKey;

//    public LoginController(LoginService loginService) {
//        this.loginService = loginService;
//    }

    // 소셜로그인
//    @ApiOperation(value = "Get user information", response = ResponseEntity.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successful operation", response = ResponseEntity.class)
//    })
    @GetMapping("/code/{registrationId}")
    public ApiResponse<UserInfoResponseDto> socialLogin(@RequestParam("code") String code, @PathVariable(name="registrationId") String registrationId) {
        System.out.println("컨트롤러");
        return ApiResponse.createSuccess(loginService.socialLogin(code, registrationId));
    }


    @GetMapping("/testLogin")
    public String testLogin(Authentication auth) {

        User loginUser = loginService.getLoginUserByLoginId(auth.getName());

        return String.format("loginId : %s\nusername : %s\nrole: %s",
                loginUser.getEmail(), loginUser.getUsername(), loginUser.getRole());
    }

//    @PostMapping("/join")
//    public Long join(@RequestBody UserSignupDto dto) {
//        return loginService.join(dto);
//    }
//
//    @PostMapping("/login")
//    @ResponseBody
//    public ApiResponse<UserInfoResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
//        User user = loginService.login(loginRequestDto);
//
//        if (user == null) {
//            return (ApiResponse<UserInfoResponseDto>)ApiResponse.createError("이메일 또는 비밀번호가 틀렸습니다.");
//        }
//
//        long expireTimeMs = 1000 * 60 * 60 * 8; // Token 유효 시간 = 8시간
//        String jwtToken = JwtTokenUtil.createToken(loginRequestDto.getEmail(), secretKey, expireTimeMs);
//
//        return ApiResponse.createSuccess(UserInfoResponseDto.builder().userId(user.getId())
//                .token(jwtToken)
//                .email(user.getEmail())
//                .username(user.getUsername())
//                .build());
//
//        // 사용자 정보를 JSON 형태로 리턴
////        Map<String, Object> response = new HashMap<>();
////        response.put("userId", user.getId());
////        response.put("token", jwtToken);
////        response.put("email", user.getEmail());
////        response.put("username", user.getUsername());
////
////        log.info("hihihibye");
////        return ResponseEntity.ok(response);
//    }
}
