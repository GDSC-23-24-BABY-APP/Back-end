package com.app.premom.dto;

import com.app.premom.entity.CheckList;
import com.app.premom.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CheckListResponseDto {
    private Long id;
    //private CheckList checkList;

    private String title;

    private int num; //0이면 초기(유산 질문), 1이면 중기, 2이면 후기(사산 질문)

    private List<Question> questions = new ArrayList<>();

    public CheckListResponseDto(CheckList entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.num = entity.getNum();
        this.questions = entity.getQuestions();
    }
}
