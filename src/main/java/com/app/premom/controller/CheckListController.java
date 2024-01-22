package com.app.premom.controller;

import com.app.premom.entity.CheckList;
import com.app.premom.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CheckListController {
    @Autowired
    private CheckListService checkListService;

    @GetMapping("/checklists")
    public List<CheckList> getAllCheckList() {
        return checkListService.getAllCheckList();
    }
    @PostMapping("/checklist")
    public CheckList saveCheckList(@RequestBody CheckList checkList) {
        return checkListService.saveCheckList(checkList);
    }
}