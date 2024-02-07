package com.app.premom.repository;

import com.app.premom.entity.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface CheckListRepository extends JpaRepository<CheckList, List> {
    List<CheckList> findAllByOrderModifiedAtDesc();
}