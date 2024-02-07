package com.app.premom.dto;

import com.app.premom.entity.Roles;
import com.app.premom.entity.User;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignupDto {

    private String email;
    private String password;
    private Date birthDate;
    private String username;
    private String nickname;
    private Roles role;
    private int isSocialLogin; // 0이면 일반 회원가입 회원, 1이면 소셜로그인 회원
    private String gender;
    private String ageRange;
    private String birthYear;
    private String phoneNumber;

    public User toEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .nickname(nickname)
                .password(password)
                .isSocialLogin(isSocialLogin)
                .role(Roles.USER)
                .gender(gender)
                .ageRange(ageRange)
                .birthYear(birthYear)
                .phoneNumber(phoneNumber)
                .build();
    }
}
