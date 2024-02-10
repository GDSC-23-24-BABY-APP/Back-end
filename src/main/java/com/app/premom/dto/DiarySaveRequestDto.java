package com.app.premom.dto;

import com.app.premom.entity.Diary;
import com.app.premom.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class DiarySaveRequestDto {
    private String title;
    private String contents;
    private int emoticon;

    @Builder
    public DiarySaveRequestDto(String contents, String title, int emoticon) {
        this.title = title;
        this.contents = contents;
        this.emoticon = emoticon;
    }

    public Diary toEntity(User user) {
        return Diary.builder()
                .title(title)
                .contents(contents)
                .emoticon(emoticon)
                .user(user).build();
    }

}
