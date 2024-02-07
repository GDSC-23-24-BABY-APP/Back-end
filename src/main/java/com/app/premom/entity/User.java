package com.app.premom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int day; //임신 몇일차인지
    private String password;
    private String bloodType;
    private String bloodRhType;
    private int height;
    private int weight;
    private int isSocialLogin; // 0이면 일반 회원가입 회원, 1이면 소셜로그인 회원
    private String healthInfo;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private Roles role;
    private String familyType;
    private String gender;
    private String birthYear;
    private String ageRange;
    private String phoneNumber;
    private String profileImage; // Google Cloud Storage에 저장된 이미지 파일 URL

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_family_id")
    private BabyFamily family;

    @JsonIgnore
    @OneToMany(mappedBy = "author",  cascade = CascadeType.PERSIST)
    private List<Diary> diaryList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CheckListAnswer> answers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HealthRecord> records = new ArrayList<>();


    @Builder
    public User(Long userId, String password, String email, String username, String nickname, String bloodType, String bloodRhType, int height, int weight, int healthInfo, Roles role, int isSocialLogin, String familyType, String gender, String ageRange, String birthYear, String phoneNumber) {
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
        this.familyType = familyType;
        this.gender = gender;
        this.ageRange = ageRange;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;
    }


    public void updateInfo(String familyType, int weight, int height, String bloodRhType, String bloodType) {
        this.familyType = familyType;
        this.weight = weight;
        this.height = height;
        this.bloodRhType = bloodRhType;
        this.bloodType = bloodType;
    }

    public Object update(String name, String profileImageUrl) {
        this.username = name;

        return this;
    }

    public void updateFamily(BabyFamily family) {
        this.family = family;
    }

    public void updateProfileImage(String imageUrl) {
        this.profileImage = imageUrl;
    }
}
