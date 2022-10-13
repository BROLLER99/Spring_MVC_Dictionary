package com.controllers;

import com.model.PatternModel;
import com.service.PatternService;
import com.service.RowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EntityController {
    private PatternService patternService;
    private RowService rowService;
    public EntityController(PatternService patternService, RowService rowService) {
        this.patternService = patternService;
        this.rowService = rowService;
    }
    @GetMapping()
    public String startApp(Model model) {
        System.out.println(System.getProperty("user.dir"));
        model.addAttribute("listPatterns", patternService.findAll());
        return "/mainMenu";
    }
    @GetMapping("/addPattern")
    public String addPattern(PatternModel patternModel,Model model){
        model.addAttribute("patternModel", patternModel);
        return "/addPattern";
    }
    @PostMapping("/addPattern")
    public String addLanguage(@ModelAttribute(name = "patternModel") PatternModel patternModel) {
        patternService.save(patternModel);
        return "redirect:/";
    }
    @GetMapping("/deletePattern")
    public String deletePattern(PatternModel patternModel,Model model){
        model.addAttribute("patternModel", patternModel);
        return "/deletePattern";
    }
    @PostMapping("/deletePattern")
    public String deletePattern(@ModelAttribute(name = "patternModel") PatternModel patternModel) {
        patternService.delete(patternModel);
        return "redirect:/";
    }
    @GetMapping("/row/allRows/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("pattern_id", id);
        return "row/allRows";
    }
}
