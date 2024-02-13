package com.app.premom.repository;

import com.app.premom.entity.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
    //List<CheckList> findAllByOrderModifiedAtDesc();
    Optional<CheckList> findByNum(int num); // 초기/중기/후기(0/1/2) 버전으로 찾기
    Optional<CheckList> findByTitle(String title);
}