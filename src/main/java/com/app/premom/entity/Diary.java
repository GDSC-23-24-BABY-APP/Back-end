package com.app.premom.entity;

import com.app.premom.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    private int emoticon;


    @Builder
    public Diary(String title, String contents, User user, int emoticon){
        this.title = title;
        this.contents = contents;
        this.author = user;
        this.emoticon = emoticon;
    }

    public void update(String title, String contents, int emoticon) {
        this.title = title;
        this.contents = contents;
        this.emoticon = emoticon;
    }
}