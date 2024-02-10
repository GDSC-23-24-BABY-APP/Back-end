package com.app.premom.service;

import com.app.premom.dto.DiaryResponseDto;
import com.app.premom.dto.DiarySaveRequestDto;
import com.app.premom.entity.Diary;
import com.app.premom.entity.User;
import com.app.premom.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public List<DiaryResponseDto> getPosts() {
        return diaryRepository.findAllByOrderByModifiedAtDesc().stream().map(DiaryResponseDto::new).toList();
    }

    @Transactional
    public Long save(User user, DiarySaveRequestDto dto) {
        return diaryRepository.save(dto.toEntity(user)).getId();
    }

    @Transactional
    public Long update(Long id, DiarySaveRequestDto dto) {
        Diary diary = diaryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 다이어리가 존재하지 않습니다."));
        diary.update(dto.getTitle(), dto.getContents(), dto.getEmoticon());
        return id;
    }

    public DiaryResponseDto findById(Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 다이어리가 존재하지 않습니다."));
        return new DiaryResponseDto(diary);
    }

    @Transactional
    public Long delete(Long id) {
        Diary diary = diaryRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 다이어리가 존재하지 않습니다."));
        diaryRepository.delete(diary);
        return id;
    }

    public List<DiaryResponseDto> findAllDescByAuthor(User user) {
        return diaryRepository.findByAuthor(user).stream().map(DiaryResponseDto::new).collect(Collectors.toList());
    }

}