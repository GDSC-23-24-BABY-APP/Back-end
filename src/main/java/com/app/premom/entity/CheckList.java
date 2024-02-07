package com.app.premom.entity;

import jakarta.persistence.*;
import lombok.Builder;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private List checkList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;

    @Builder
    public CheckList(List checkList, User user){
        this.checkList = checkList;
        this.author = user;
    }
}