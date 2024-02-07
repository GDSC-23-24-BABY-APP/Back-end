package com.app.premom.entity;

import com.app.premom.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question extends BaseTimeEntity {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int num; //질문 번호

    private String content; //질문 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checklist_id")
    private CheckList checkList;

    private int risk; //위험도

    @Builder
    public Question(int num, String content, int risk) {
        this.num = num;
        this.content = content;
        this.risk = risk;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }
}
