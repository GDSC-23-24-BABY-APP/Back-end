//package com.app.premom.controller;
//
//
//import com.app.premom.entity.CheckList;
//import com.app.premom.dto.CheckListResponseDto;
//import com.app.premom.entity.User;
//import com.app.premom.service.LoginService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import com.app.premom.service.CheckListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class CheckListController {
//    private final CheckListService checkListService;
//    private final LoginService loginService;
//
//    @PostMapping("/checklists/new")
//    public Long save(@RequestBody CheckListResponseDto dto, Authentication auth) {
//        User user = loginService.getLoginUserByLoginId(auth.getName());
//        Long result = checkListService.save(user, new CheckListSaveRequestDto());
//        return result;
//    }
//    @GetMapping("/checklists/getAll")
//    public List<CheckListResponseDto> getPosts(Authentication auth) {
//        List<CheckListResponseDto> checkListResponseDtos = checkListService.getPosts();
//        return checkListResponseDtos;
//    }
//}