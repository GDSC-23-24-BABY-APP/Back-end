package com.app.premom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserInfoUpdateDto {
    private String familyType;
    private int weight;
    private int height;
    private String bloodRhType;
    private String bloodType;
}
