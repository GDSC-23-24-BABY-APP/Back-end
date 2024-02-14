package com.app.premom.repository;

import com.app.premom.entity.CheckListResult;
import com.app.premom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CheckListResultRepository extends JpaRepository<CheckListResult, Long> {

    Optional<CheckListResult> findByUserAndCreatedAt(User user, LocalDateTime CreatedDate);
}
