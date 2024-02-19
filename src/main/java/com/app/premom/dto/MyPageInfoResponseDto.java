package com.app.premom.dto;

import com.app.premom.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyPageInfoResponseDto {
    private String username;
    private String email;
    private String bloodType;
    private String bloodRhType;
    private int height;
    private float weight;
    private String babyName;
    private int week; //임신 주차
    private int month; //임신 개월수


    public MyPageInfoResponseDto(User entity) {
        this.username = entity.getUsername();
        this.email = entity.getEmail();
        this.bloodType = entity.getBloodType();
        this.bloodRhType = entity.getBloodRhType();
        this.height = entity.getHeight();
        this.weight = entity.getWeight();
        this.babyName = entity.getBabyName();
        this.week = entity.getDay() % 7;
        this.month = entity.getDay() % 30;
    }
}
