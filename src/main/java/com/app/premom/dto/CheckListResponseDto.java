package com.app.premom.dto;

import com.app.premom.entity.CheckList;
import com.app.premom.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CheckListResponseDto {
    private Long id;
    private List checkList;

    public CheckListResponseDto(CheckList checkList) {
        this.id = checkList.getId();
        this.checkList = checkList.getCheckList();
    }
}
