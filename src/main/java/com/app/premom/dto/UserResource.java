package com.app.premom.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResource {

    String id;
    String email;
    String username;
    String gender;
    String ageRange;
    String birthYear;
    String phoneNumber;

    @Builder
    public UserResource(String id, String email, String username, String gender,
                        String ageRange, String birthYear, String phoneNumber) {

        this.id = id;
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.ageRange = ageRange;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;

    }
}
