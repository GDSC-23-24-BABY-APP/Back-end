package com.app.premom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"id", "nickName", "gender"})
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long id;

    @Column(nullable = false)
    private String nickName;

//    @Embedded
//    private Address address;

    private String phoneNumber;

    // w이면 여성, m이면 남성
    private String gender;

    private int age;

    private String provider;
    private String providerId;

//    private String imageUrl;



}
