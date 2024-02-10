package com.app.premom.controller;

import com.app.premom.dto.DiaryResponseDto;
import com.app.premom.dto.DiarySaveRequestDto;
import com.app.premom.entity.User;
import com.app.premom.ApiResponse;
import com.app.premom.service.DiaryService;
import com.app.premom.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {
    private final DiaryService diaryService;
    private final LoginService loginService;

    /**
     * 회원의 다이어리 생성
     * @param dto
     * @param auth
     * @return
     */
    @PostMapping("/api/diary/new")
    public Long save(@RequestBody DiarySaveRequestDto dto, Authentication auth) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        Long result = diaryService.save(user, dto);

        return result;
    }

    /**
     * 회원 자신의 모든 다이어리 조회
     * @param auth
     * @return
     */
    @GetMapping("/api/diary/getAll")
    public ApiResponse<List<DiaryResponseDto>> getPosts(Authentication auth) {
        User user = loginService.getLoginUserByLoginId(auth.getName());
        if(user == null) {
            return (ApiResponse<List<DiaryResponseDto>>)ApiResponse.createError("회원 조회에 실패하였습니다.");
        }
        List<DiaryResponseDto> resultList = diaryService.findAllDescByAuthor(user);

        if(resultList == null) {
            return (ApiResponse<List<DiaryResponseDto>>) ApiResponse.createError("다이어리 조회에 실패하였습니다.");
        }
        return ApiResponse.createSuccess(resultList);
    }

    /**
     * 회원의 다이어리 수정
     * @param id
     * @param dto
     * @return
     */
    @PostMapping("/api/diary/update/id")
    public ApiResponse<Long> update(@RequestParam Long id, @RequestBody DiarySaveRequestDto dto) {
        Long result = diaryService.update(id, dto);
        if (result == -1L) {
            return (ApiResponse<Long>) ApiResponse.createError("다이어리 업데이트에 실패했습니다.");
        }
        return ApiResponse.createSuccess(result);
    }

    /**
     * 다이어리 개별 조회
     * @param id
     * @return
     */
    @GetMapping("/id")
    public ApiResponse<DiaryResponseDto> findById (@RequestParam Long id) {
        DiaryResponseDto result = diaryService.findById(id);
        if(result == null) {
            return (ApiResponse<DiaryResponseDto>) ApiResponse.createError("다이어리 조회에 실패하였습니다.");
        }
        return ApiResponse.createSuccess(result);
    }

    /**
     * 다이어리 삭제
     * @param id
     * @return
     */
    @DeleteMapping("/diary/id")
    public ApiResponse<Long> delete(@RequestParam Long id) {
        diaryService.delete(id);
        return ApiResponse.createSuccess(id);
    }

}
