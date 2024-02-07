package com.app.premom.repository;

import com.app.premom.entity.HealthRecord;
import com.app.premom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {

    // 사용자별 건강 기록
    List<HealthRecord> findByUser(User user);
}
