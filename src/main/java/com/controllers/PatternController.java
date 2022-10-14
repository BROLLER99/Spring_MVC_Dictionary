package com.controllers;

import com.model.PatternModel;
import com.service.PatternService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pattern")
public class PatternController {
    private final PatternService patternService;
    public PatternController(PatternService patternService) {
        this.patternService = patternService;
    }
    @GetMapping()
    public String startApp(Model model) {
        model.addAttribute("listPatterns", patternService.findAll());
        return "/pattern/mainMenu";
    }
    @GetMapping("/addPattern")
    public String addPattern(PatternModel patternModel,Model model){
        model.addAttribute("patternModel", patternModel);
        return "pattern/addPattern";
    }
    @PostMapping("/addPattern")
    public String addLanguage(@ModelAttribute(name = "patternModel") PatternModel patternModel) {
        patternService.save(patternModel);
        return "redirect:/pattern";
    }
    @GetMapping("/deletePattern")
    public String deletePattern(PatternModel patternModel,Model model){
        model.addAttribute("patternModel", patternModel);
        return "pattern/deletePattern";
    }
    @PostMapping("/deletePattern")
    public String deletePattern(@ModelAttribute(name = "patternModel") PatternModel patternModel) {
        patternService.delete(patternModel);
        return "redirect:/pattern";
    }
}
