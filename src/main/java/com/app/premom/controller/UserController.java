package com.app.premom.controller;

import com.app.premom.dto.BabyFamilySaveDto;
import com.app.premom.dto.UserInfoUpdateDto;
import com.app.premom.entity.User;
import com.app.premom.service.LoginService;
import com.app.premom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
    private final LoginService loginService;
    private final UserService userService;

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
    public Long createBabyFamily(@RequestBody BabyFamilySaveDto dto) {

    }
}
