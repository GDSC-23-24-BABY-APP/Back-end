package com.app.premom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private Long memberId;
    private String email;
    private String username;
    private String nickname;
    private String password;
    private String bloodType;
    private String bloodRhType;
    private int height;
    private int weight;
    private int isSocialLogin; // 0이면 일반 회원가입 회원, 1이면 소셜로그인 회원
    //회원 가족 구성원
    //private ArrayList<User> userMember;
    private String healthInfo;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private Roles role;

    @OneToMany(mappedBy = "author",  cascade = CascadeType.PERSIST)
    private List<Diary> diaryList = new ArrayList<>();


    //oauth2
    private String provider;
    private String providerId;

    @Builder
    public User(Long userId, String password, String email, String username, String nickname, String bloodType, String bloodRhType, int height, int weight, int healthInfo, Roles role, int isSocialLogin) {
        this.memberId = userId;
        this.email = email;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.bloodType = bloodType;
        this.bloodRhType = bloodRhType;
        this.weight = weight;
        this.height = height;
        this.role = role;
        this.isSocialLogin = isSocialLogin;
    }


    public Object update(String name, String profileImageUrl) {
        this.username = name;

        return this;
    }
}
