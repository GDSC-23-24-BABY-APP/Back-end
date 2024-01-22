package com.app.premom.entity;

import com.app.premom.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;


    @Builder
    public Diary(String contents, User user){
        this.contents = contents;
        this.author = user;
    }


}