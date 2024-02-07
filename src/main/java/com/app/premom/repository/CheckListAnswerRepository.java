package com.app.premom.repository;

import com.app.premom.entity.CheckListAnswer;
import com.app.premom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckListAnswerRepository extends JpaRepository<CheckListAnswer, Long> {


    @Query("SELECT c FROM CheckListAnswer c WHERE c.user = :u AND c.day = :d")
    List<CheckListAnswer> findByUserAndDay(@Param("u") User u, @Param("d") int day);
}
