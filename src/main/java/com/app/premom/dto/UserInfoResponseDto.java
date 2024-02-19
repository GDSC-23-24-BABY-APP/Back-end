package com.app.premom.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoResponseDto {
    Long userId;
    String token;
    String email;
    String username;
    String babyName;
    int day;

    @Builder
    public UserInfoResponseDto(Long userId, String token, String email, String username, String babyName, int day) {
        this.userId = userId;
        this.token = token;
        this.email = email;
        this.username = username;
        this.babyName = babyName;
        this.day = day;
    }
}
