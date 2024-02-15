package com.app.premom.dto;

import com.app.premom.entity.Diary;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class DiaryResponseDto {
    private Long id;
    private String title;
    private String contents;
    private LocalDate createdDate;

    public DiaryResponseDto(Diary diary) {
        this.id = diary.getId();
        this.title = diary.getTitle();
        this.contents = diary.getContents();
        this.createdDate = diary.getCreatedAt().toLocalDate();
    }

}