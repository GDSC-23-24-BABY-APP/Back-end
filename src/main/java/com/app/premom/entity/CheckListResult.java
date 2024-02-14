package com.app.premom.entity;

import com.app.premom.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CheckListResult extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_result_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 체크리스트 진행 결과 ( 0이면 건강함 등..)
    private int result;

    //==연관관계 편의 메서드==//
    public void setUser(User user) {
        this.user = user;
        user.getResults().add(this);
    }

    //==생성 메서드==//
    public static CheckListResult createCheckListResult(User user, int result) {
        CheckListResult checkListResult = new CheckListResult();
        checkListResult.setUser(user);
        checkListResult.setResult(result);

        return checkListResult;
    }
}
