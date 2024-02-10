package com.app.premom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@NoArgsConstructor
@Entity
public class BabyFamily {

    @Id @Column(name = "baby_family_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String joinCode; // 초대 코드

    private String babyName; // 아기 태명

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate babyBirthDate;

    private int babyNum; // 첫째 둘째

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL)
    private List<User> familyMembers = new ArrayList<>(); // 가족 구성원

    @Builder
    public BabyFamily(String babyName, int babyNum, LocalDate babyBirthDate) {
        this.babyName = babyName;
        this.babyNum = babyNum;
        this.babyBirthDate = babyBirthDate;
        createJoinCode();
    }

    public String createJoinCode() {
        // 사용할 문자열
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // 랜덤 문자열을 저장할 StringBuilder
        StringBuilder randomString = new StringBuilder();

        // 랜덤 객체 생성
        Random random = new Random();

        // 문자열 길이
        int length = 12;

        // 문자열 생성
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }

        this.joinCode = randomString.toString();

        return joinCode;
    }
}
