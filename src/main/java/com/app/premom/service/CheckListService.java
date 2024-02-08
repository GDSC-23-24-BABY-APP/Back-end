//package com.app.premom.service;
//
//import com.app.premom.dto.CheckListResponseDto;
//import com.app.premom.dto.CheckListSaveRequestDto;
//import com.app.premom.entity.CheckList;
//import com.app.premom.entity.User;
//import com.app.premom.repository.CheckListRepository;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CheckListService {
//
//    private final CheckListRepository checkListRepository;
//
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
//}