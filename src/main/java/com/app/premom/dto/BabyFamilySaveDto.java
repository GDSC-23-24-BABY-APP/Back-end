package com.app.premom.dto;

import com.app.premom.entity.BabyFamily;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class BabyFamilySaveDto {

    private String babyName; // 아기 태명

    private int babyNum; // 첫째 둘째

    private LocalDate babyBirthDate; //출산 예정일

    public BabyFamily toEntity() {
        return BabyFamily.builder()
                .babyName(babyName)
                .babyNum(babyNum)
                .babyBirthDate(babyBirthDate)
                .build();
    }

    @Builder
    public BabyFamilySaveDto(String babyName, int babyNum, LocalDate babyBirthDate) {
        this.babyBirthDate = babyBirthDate;
        this.babyName = babyName;
        this.babyNum = babyNum;
    }
}
