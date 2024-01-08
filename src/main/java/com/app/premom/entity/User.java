package com.app.premom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    private Long id;
    private Long userId;
    private String password;
    private String userName;
    private String phoneNum;
    private Date userBirth;
    private String bloodType;
    private String bloodRhType;
    private int height;
    private int weight;
    //회원 가족 구성원
    private ArrayList<User> userMember;
    private String healthInfo;

    @Builder
    public User(Long userId, String password, String userName, String phoneNum, Date userBirth, String bloodType, String bloodRhType, int height, int weight, int healthInfo) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.phoneNum = phoneNum;
        this.userBirth = userBirth;
        this.bloodType = bloodType;
        this.bloodRhType = bloodRhType;
        this.weight = weight;
        this.height = height;
    }


}
