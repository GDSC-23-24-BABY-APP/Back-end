package com.app.premom.repository;

import com.app.premom.entity.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CheckListRepository extends JpaRepository<CheckList, Long> {
    List<CheckList> findAllByOrderModifiedAtDesc();
    Optional<CheckList> findByNum(int num);
    Optional<CheckList> findByTitle(String title);
}