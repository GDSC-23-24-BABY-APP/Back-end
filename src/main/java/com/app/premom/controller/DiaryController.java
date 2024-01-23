package com.app.premom.controller;

import com.app.premom.service.DiaryService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final LoginService loginService;

//    @PostMapping("/api/diary/new")
//    public Long save(@RequestBody DiarySaveRequestDto dto, Authentication auth) {
//        User user = loginService.getLoginUserByLoginId(auth.getName());
//        Long result = diaryService.save(user, dto);
//
//        return result;
//    }
//
//    @GetMapping("/api/diary/getAll")
//    public List<DiaryResponseDto>getPosts(Authentication auth) {
//        return diaryService.getPosts();
//    }
}