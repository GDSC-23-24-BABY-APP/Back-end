//package com.app.premom.controller;
//
//import com.app.premom.config.BaseResponse;
//import com.app.premom.config.PostLoginRes;
//import com.app.premom.service.LoginService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//
//@RequiredArgsConstructor
//public class LoginController_x{
//
//    private final LoginService loginService;
//
//    /**
//     * 카카오 소셜로그인 API
//     * [GET] /oauth/kakao
//     * @return BaseResponse<String>
//     */
//    @ResponseBody
//    @GetMapping("/oauth/kakao")
//    public BaseResponse<PostLoginRes> kakaoLogin(@RequestParam(required = false) String code) {
//        try {
//            //URL에 포함된 code를 이용하여 액세스 토큰 발급
//            String accessToken = loginService.getKakaoAccessToken(code);
//            System.out.println(accessToken);
//
//            //액세스 토큰을 이용하여 카카오  서버에서 유저 정보(닉네임, 이메일) 받아오기
//            HashMap<String, Object> userInfo = loginService.getUserInfo(accessToken);
//            System.out.println("login Controller : " + userInfo);
//
//            PostLoginRes postLoginRes = null;
//
//            // 만일, DB에 해당 email을 가지는 유저가 없으면 회원가입 시키고, 유저 식별자와 JWT 반환환
//        }
//    }
//
//}
