package com.app.premom.controller;

import com.app.premom.entity.User;
import com.app.premom.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login/oauth2", produces = "application/json")
public class LoginController {

    LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/code/{registrationId}")
    public ResponseEntity<Object> googleLogin(@RequestParam(value="code") String code, @PathVariable(name="registrationId") String registrationId) {
        System.out.println("컨트롤러");
        return loginService.socialLogin(code, registrationId);

    }

    @GetMapping("/testLogin")
    public String testLogin(Authentication auth) {

        User loginUser = loginService.getLoginUserByLoginId(auth.getName());

        return String.format("loginId : %s\nusername : %s\nrole: %s",
                loginUser.getEmail(), loginUser.getUsername(), loginUser.getRole());
    }
}
