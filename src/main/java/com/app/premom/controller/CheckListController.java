package com.app.premom.controller;


import com.app.premom.ApiResponse;
import com.app.premom.dto.CalCheckListResultDto;
import com.app.premom.dto.CheckListCalResponseDto;
import com.app.premom.dto.CheckListResponseDto;
import com.app.premom.service.CheckListService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/checklist", produces = "application/json")
@RestController
@RequiredArgsConstructor
public class CheckListController {
    private final CheckListService checkListService;
    private final LoginService loginService;


//    @PostMapping("/checklists/new")
//    public Long createCheckList() {
//        return checkListService.saveCheckList();
//    }

//    @PostMapping("/checklists/new")
//    public Long save(@RequestBody CheckListResponseDto dto, Authentication auth) {
//        User user = loginService.getLoginUserByLoginId(auth.getName());
//        Long result = checkListService.save(user, new CheckListSaveRequestDto());
//        return result;
//    }
//    @GetMapping("/checklists/get")
//    public List<CheckListResponseDto> getPosts(Authentication auth, @RequestParam int num) {
//        List<CheckListResponseDto checkListResponseDtos = checkListService.getPosts();
//        return checkListResponseDtos;
//    }

    @GetMapping("/num")
    public ApiResponse<CheckListResponseDto> findByNum(@RequestParam(name = "num") int num) {
        CheckListResponseDto result = checkListService.findByNum(num);
        if(result == null) {
            return (ApiResponse<CheckListResponseDto>) ApiResponse.createError("체크리스트 조회에 실패하였습니다.");
        }
        return ApiResponse.createSuccess(result);
    }

    @PostMapping("/cal-result")
    public ApiResponse<CheckListCalResponseDto> calculateResult(@RequestBody CalCheckListResultDto dto) {
        CheckListCalResponseDto result = checkListService.getResultInfo(dto);
        if(result.getResult() <= -1) {
            return (ApiResponse<CheckListCalResponseDto>) ApiResponse.createError("체크리스트 결과 계산에 실패하였습니다.");
        }
        return ApiResponse.createSuccess(result);
    }
}