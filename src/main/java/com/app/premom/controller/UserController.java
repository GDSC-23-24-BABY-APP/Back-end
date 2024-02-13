package com.app.premom.controller;

import com.app.premom.ApiResponse;
import com.app.premom.dto.*;
import com.app.premom.entity.User;
import com.app.premom.jwt.JwtTokenUtil;
import com.app.premom.service.FamilyService;
import com.app.premom.service.LoginService;
import com.app.premom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/user", produces = "application/json")
@RequiredArgsConstructor
@RestController
public class UserController {
    private final LoginService loginService;
    private final UserService userService;
    private final FamilyService familyService;
    @Value("${jwt.secret}")
    private String secretKey;

    @PostMapping("/join")
    public Long join(@RequestBody UserSignupDto dto) {
        return loginService.join(dto);
    }

    @PostMapping("/login")
    @ResponseBody
    public ApiResponse<UserInfoResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        User user = loginService.login(loginRequestDto);

        if (user == null) {
            return (ApiResponse<UserInfoResponseDto>)ApiResponse.createError("이메일 또는 비밀번호가 틀렸습니다.");
        }

        long expireTimeMs = 1000 * 60 * 60 * 8; // Token 유효 시간 = 8시간
        String jwtToken = JwtTokenUtil.createToken(loginRequestDto.getEmail(), secretKey, expireTimeMs);

        return ApiResponse.createSuccess(UserInfoResponseDto.builder().userId(user.getId())
                .token(jwtToken)
                .email(user.getEmail())
                .username(user.getUsername())
                .build());

        // 사용자 정보를 JSON 형태로 리턴
//        Map<String, Object> response = new HashMap<>();
//        response.put("userId", user.getId());
//        response.put("token", jwtToken);
//        response.put("email", user.getEmail());
//        response.put("username", user.getUsername());
//
//        log.info("hihihibye");
//        return ResponseEntity.ok(response);
    }

    /**
     * 회원 정보 update
     * @param auth
     * @param dto
     * @return userId
     */
    @PostMapping("/info/update")
    public Long updateUserInfo(Authentication auth, @RequestBody UserInfoUpdateDto dto) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        return userService.updateInfo(user, dto);
    }

    /**
     * familyType이 mom인 사용자가 가족(아기) 정보 생성
     * @param dto
     * @return BabyFamilyId
     */
    @PostMapping("/family/create")
    public String createBabyFamily(Authentication auth, @RequestBody BabyFamilySaveDto dto) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        return familyService.save(user,dto);
    }
}
