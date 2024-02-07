package com.app.premom.entity;

import com.app.premom.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckList extends BaseTimeEntity { // 체크리스트 엔티티
    @Id @Column(name = "checklist_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private int num; //0이면 초기(유산 질문), 1이면 후기(사산 질문)

    @OneToMany(mappedBy = "checkList", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();


    @Builder
    public CheckList(String title, List<Question> questions, int num){
        this.title = title;
        this.questions = questions;
        this.num = num;
    }

    // == 연관관계 매핑 ==
    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setCheckList(this);
    }
}