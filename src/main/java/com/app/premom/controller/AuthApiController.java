//package com.app.premom.controller;
//
//import com.app.premom.dto.LoginRequestDto;
//import com.app.premom.service.AuthService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/oauth2")
//public class AuthApiController {
//
//    private final AuthService authService;
//
//    // 구글 로그인 창 접근
////    @GetMapping("login")
////    public void getGoogleAuthUrl(HttpServletResponse response) throws Exception {
////        response.sendRedirect(google);
////    }
//
//    @GetMapping("google")
//    public ResponseEntity<String> getMemberProfile(
//            @Valid @RequestBody LoginRequestDto request
//    ) throws Exception {
//        String token = this.authService.login(request);
//        return ResponseEntity.status(HttpStatus.OK).body(token);
//    }
//}
