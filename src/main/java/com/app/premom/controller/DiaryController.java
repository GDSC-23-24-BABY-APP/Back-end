package com.app.premom.controller;

import com.app.premom.dto.DiaryResponseDto;
import com.app.premom.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;

    @GetMapping("/api/diary")
    public List<DiaryResponseDto>getPosts() {
        return diaryService.getPosts();
    }
}