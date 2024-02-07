package com.app.premom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckListAnswer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_answer_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 단방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    // 단방향 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "checklist_id")
    private CheckList checkList;

    private int day; //몇 일 째의 체크리스트 답변인지

    private int num; //몇 번 째 질문에 대한 답변인지

    @Builder
    public CheckListAnswer(User user, Question question, CheckList checkList, int num) {
        this.user = user;
        this.question = question;
        this.checkList = checkList;
        this.day = user.getDay();
        this.num = num;
    }

    // ==양방향 연관관계 메서드==
    public void addUser(User user) {
        this.user = user;
        user.getAnswers().add(this);
    }

    // ==단방향 연관관계 메서드==
    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setCheckList(CheckList checkList) {
        this.checkList = checkList;
    }
}
