package com.app.premom.dto;

import com.app.premom.entity.Diary;
import com.app.premom.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class DiarySaveRequestDto {
    private String contents;

    @Builder
    public DiarySaveRequestDto(String contents) {
        this.contents = contents;
    }

    public Diary toEntity(User user) {
        return Diary.builder()
                .contents(contents)
                .user(user).build();
    }


}
