package com.controllers;

import com.model.RowModel;
import com.service.RowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/row")
public class RowController {
    private final RowService rowService;

    public RowController(RowService rowService) {
        this.rowService = rowService;
    }

    @GetMapping("/{id}")
    public String menu(@PathVariable("id") String id,Model model){
        model.addAttribute("listRows", rowService.findRuleById(id));
        model.addAttribute("id", id);
        return "/row/allRows";
    }
    @GetMapping("/add")
    public String addRow(){
        return "row/addRow";
    }
}
