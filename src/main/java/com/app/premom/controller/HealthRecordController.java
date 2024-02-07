package com.app.premom.controller;

import com.app.premom.dto.HealthRecordResponseDto;
import com.app.premom.dto.HealthRecordSaveDto;
import com.app.premom.entity.User;
import com.app.premom.response.ApiResponse;
import com.app.premom.service.HealthRecordService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("health")
public class HealthRecordController {

    private final HealthRecordService healthRecordService;
    private final LoginService loginService;

    //회원의 건강 기록 생성
    @PostMapping("/new")
    public ApiResponse<Long> save(@RequestBody HealthRecordSaveDto dto, Authentication auth) {
        User user = loginService.getLoginUserByLoginId(auth.getName());

        Long result = healthRecordService.save(user, dto);
        if(result == -1L) {
            return (ApiResponse<Long>) ApiResponse.createError("건강기록 업데이트에 실패했습니다.");
        }
        return ApiResponse.createSuccess(result);
    }

    //회원의 모든 건강 기록 목록 조회
    @GetMapping("/list")
    public ApiResponse<List<HealthRecordResponseDto>> findByMember(Authentication auth) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        List<HealthRecordResponseDto> resultList = healthRecordService.findAllDescByUser(user);

        return ApiResponse.createSuccess(resultList);
    }

    //회원의 건강 기록 id(PK)로 조회
    @GetMapping("/id")
    public ApiResponse<HealthRecordResponseDto> findById(@RequestParam Long id) {
        HealthRecordResponseDto result = healthRecordService.findById(id);
        return ApiResponse.createSuccess(result);
    }
}
