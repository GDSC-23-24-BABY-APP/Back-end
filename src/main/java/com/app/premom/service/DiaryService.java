package com.app.premom.service;

import com.app.premom.dto.DiaryRequestsDto;
import com.app.premom.dto.DiaryResponseDto;
import com.app.premom.dto.DiarySaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.repository.DiaryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DiaryService {

    private final DiaryRepository diaryRepository;

    @Transactional
    public List<DiaryResponseDto> getPosts() {
        return diaryRepository.findAllByOrderByModifiedAtDesc().stream().map(DiaryResponseDto::new).toList();
    }

    public Long save(User user, DiarySaveRequestDto dto) {
        return diaryRepository.save(dto.toEntity(user)).getId();
    }
}