package com.app.premom.dto;

import com.app.premom.entity.CheckList;
import com.app.premom.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CheckListSaveRequestDto {
    private List checkList;

    @Builder
    public CheckListSaveRequestDto(List checkList) {
        this.checkList = checkList;
    }

    public CheckList toEntity(User user) {
        return CheckList.builder()
                .checkList(checkList)
                .user(user).build();
    }
}
