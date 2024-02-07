package com.app.premom.controller;

import com.app.premom.dto.DiaryResponseDto;
import com.app.premom.dto.DiarySaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.service.DiaryService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final LoginService loginService;

    @PostMapping("/api/diary/new")
    public Long save(@RequestBody DiarySaveRequestDto dto, Authentication auth) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        Long result = diaryService.save(user, dto);

        return result;
    }
    @GetMapping("/api/diary/getAll")
    public List<DiaryResponseDto> getPosts(Authentication auth) {
        return diaryService.getPosts();
    }
}
