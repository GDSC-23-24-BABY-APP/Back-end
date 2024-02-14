package com.app.premom.service;

import com.app.premom.dto.HealthRecordResponseDto;
import com.app.premom.dto.HealthRecordSaveDto;
import com.app.premom.entity.HealthRecord;
import com.app.premom.entity.User;
import com.app.premom.repository.HealthRecordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class HealthRecordService {

    private final HealthRecordRepository healthRecordRepository;

    @Transactional
    public Long save(User user, HealthRecordSaveDto dto) {
        return healthRecordRepository.save(dto.toEntity(user)).getId();
    }

    public HealthRecordResponseDto findById(Long id) {
        HealthRecord entity = healthRecordRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id의 건강 기록이 존재하지 않습니다."));
        return new HealthRecordResponseDto(entity);
    }

    public List<HealthRecordResponseDto> findAllDescByUser(User user) {
        return healthRecordRepository.findByUser(user).stream().map(HealthRecordResponseDto::new).collect(Collectors.toList());
    }
}
