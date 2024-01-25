package com.app.premom.dto;

import com.app.premom.entity.Roles;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomUserInfoDto {
    private Long memberId;

    private String email;

    private String name;

    private String password;

    private Roles role;

}
