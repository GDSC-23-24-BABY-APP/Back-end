package com.app.premom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class CheckListCalResponseDto {
    int result;
    List<String> checkedQ = new ArrayList<>();

    public CheckListCalResponseDto(int result, List<String> checkedQ) {
        this.result = result;
        this.checkedQ = checkedQ;
    }
}
