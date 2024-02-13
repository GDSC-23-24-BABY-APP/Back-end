package com.app.premom.dto;

import com.app.premom.entity.CheckList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CheckListResponseDto {
    private Long id;
    private CheckList checkList;

    public CheckListResponseDto(CheckList entity) {
        this.id = entity.getId();
        this.checkList = entity;
    }
}
