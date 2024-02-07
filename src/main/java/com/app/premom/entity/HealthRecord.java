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
public class HealthRecord extends BaseTimeEntity {
    @Id @GeneratedValue
    @Column(name = "health_record_id")
    private Long id;

    private float weight;

    private List<Integer> healthInfoList = new ArrayList<>();

    private String healthDiary;

    private int healthState; //체크리스트 보고서 결과. 0이면 건강함, 1이면 유산 의심, 2면 사산 의심

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public HealthRecord(float weight, List<Integer> healthInfoList, String healthDiary,int healthState, User user) {
        this.weight = weight;
        this.healthInfoList = healthInfoList;
        this.healthDiary = healthDiary;
        this.healthState = healthState;
        this.user = user;
    }

    //==양방향 연관관계 메서드==
    public void setUser(User user) {
        this.user = user;
        user.getRecords().add(this);
    }

}
