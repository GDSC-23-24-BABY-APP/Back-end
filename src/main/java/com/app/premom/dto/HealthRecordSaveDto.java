package com.app.premom.dto;

import com.app.premom.entity.HealthRecord;
import com.app.premom.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class HealthRecordSaveDto {

    private float weight;

    private List<Integer> healthInfoList;

    private String healthDiary;

    private int healthState;

    public HealthRecord toEntity(User user) {
        return HealthRecord.builder()
                .weight(weight)
                .healthInfoList(healthInfoList)
                .healthDiary(healthDiary)
                .healthState(healthState)
                .user(user)
                .build();
    }

}
