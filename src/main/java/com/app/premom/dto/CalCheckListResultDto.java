package com.app.premom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CalCheckListResultDto {
    private int checkListNum;
    private List<Integer> answerList; // 체크리스트 각 질문들에 대한 체크 여부, 0이면 체크 X, 1이면 체크 O
}
