package com.app.premom.service;

import com.app.premom.repository.CheckListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CheckListService {

    private final CheckListRepository checkListRepository;

//    public CheckListResponseDto findByNum(int num) {
//
//    }

//    @Transactional
//    public List<CheckListResponseDto> getPosts() {
//        return checkListRepository.findAllByOrderModifiedAtDesc().stream().map(CheckListResponseDto::new).toList();
//    }
//
//    @Transactional
//    public Long save(User user, CheckListSaveRequestDto dto) {
//        CheckList checkList = dto.toEntity(user);
//        CheckList savedCheckList = checkListRepository.save(checkList);
//        return savedCheckList.getId();
//    }
}