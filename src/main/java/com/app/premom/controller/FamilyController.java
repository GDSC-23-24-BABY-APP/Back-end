package com.app.premom.controller;

import com.app.premom.entity.User;
import com.app.premom.service.FamilyService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/family")
@Controller
public class FamilyController {

    private final LoginService loginService;
    private final FamilyService familyService;

    /**
     * 초대 코드 입력 -> 가족에 join
     * @param auth
     * @param code
     * @return
     */
    @GetMapping("/join/{code}")
    public Long acceptJoin(Authentication auth, @PathVariable String code) {
        User user = loginService.getLoginUserByLoginId(auth.getName());

        return familyService.joinFamily(user, code);

    }
}
