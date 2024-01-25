package com.app.premom.dto;

import com.app.premom.entity.BabyFamily;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BabyFamilySaveDto {

    private String babyName; // 아기 태명

    private int babyNum; // 첫째 둘째

    public BabyFamily toEntity() {
        return BabyFamily.builder()
                .babyName(babyName)
                .babyNum(babyNum)
                .build();
    }
}
