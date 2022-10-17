package com.controllers;

import com.model.PatternModel;
import com.model.RowModel;
import com.service.PatternService;
import com.service.RowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/row")
public class RowController {
    private final RowService rowService;

    public RowController(RowService rowService) {
        this.rowService = rowService;
    }

    @GetMapping("/{id}")
    public String menu(@PathVariable("id") String idOfChosenPattern, Model model) {
        model.addAttribute("listRows", rowService.findRuleById(idOfChosenPattern));
        model.addAttribute("id", idOfChosenPattern);
        return "/row/allRows";
    }

    @GetMapping("/addRow/{id}")
    public String addRow(RowModel rowModel, PatternService patternService, Model model, @PathVariable("id") String idOfChosenPattern) {
        model.addAttribute("rowModel", rowModel);
        model.addAttribute("idOfChosenPattern", idOfChosenPattern);
        model.addAttribute("pattern", patternService.getPatternById(idOfChosenPattern));
        return "row/addRow";
    }

    @PostMapping("/addRow/{id}")
    public String addRow(@ModelAttribute(name = "RowModel") RowModel rowModel, @PathVariable("id") String idOfChosenPattern) {
        rowModel.setPatternId(idOfChosenPattern);//todo не разобрался как в html установить id паттерна
        System.out.println(rowModel);
        rowService.save(rowModel);
        return "redirect:/row/{id}";
    }

    @GetMapping("/deleteRow/{id}")
    public String deleteRow(RowModel rowModel, Model model, @PathVariable("id") String idOfChosenPattern) {//todo Хочу вводить слово а удалять по id
        model.addAttribute("rowModel", rowModel);
        return "row/deleteRow";
    }

    @PostMapping("/deleteRow/{id}")
    public String deleteRow(@ModelAttribute(name = "rowModel") RowModel rowModel, @PathVariable("id") String idOfChosenPattern) {
        rowService.delete(rowModel);
        return "redirect:/row/{id}";
    }
}
