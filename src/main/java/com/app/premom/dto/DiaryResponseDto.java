package com.app.premom.dto;

import com.app.premom.entity.Diary;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DiaryResponseDto {
    private Long id;
    private String contents;

    public DiaryResponseDto(Diary diary) {
        this.id = diary.getId();
        this.contents = diary.getContents();
    }

}