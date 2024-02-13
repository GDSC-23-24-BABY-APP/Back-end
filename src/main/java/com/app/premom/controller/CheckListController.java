package com.app.premom.controller;


import com.app.premom.service.CheckListService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/checklist", produces = "application/json")
@RestController
@RequiredArgsConstructor
public class CheckListController {
    private final CheckListService checkListService;
    private final LoginService loginService;

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

//    @GetMapping("/num")
//    public ApiResponse<CheckListResponseDto> findByNum(@RequestParam int num) {
//
//        CheckListResponseDto result = checkListService.findByNum(num);
//    }
}