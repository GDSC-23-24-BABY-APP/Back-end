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

    private int num; //0이면 초기(유산 질문), 1이면 중기, 2이면 후기(사산 질문)

    @OneToMany(mappedBy = "checkList", cascade = CascadeType.ALL)
    private List<Question> questions = new ArrayList<>();


    @Builder
    public CheckList(String title, List<Question> questions, int num){
        this.title = title;
        this.questions = questions;
        this.num = num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    //==연관관계 편의 메서드==//
    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setCheckList(this);
    }

    //==생성 메서드==//
    public static CheckList createCheckList(int num, Question... questions) {
        CheckList checkList = new CheckList();
        for (Question question : questions) {
            checkList.addQuestion(question);
        }
        checkList.setNum(num);
        return checkList;
    }
}