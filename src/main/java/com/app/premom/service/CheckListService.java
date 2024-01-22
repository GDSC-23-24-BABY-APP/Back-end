package com.app.premom.service;

import com.app.premom.entity.CheckList;
import com.app.premom.repository.CheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListService {

    @Autowired
    private CheckListRepository checkListRepository;

    public List<CheckList> getAllCheckList() {
        return checkListRepository.findAll();
    }

    public CheckList saveCheckList(CheckList checkList) {
        return checkListRepository.save(checkList);
    }

}