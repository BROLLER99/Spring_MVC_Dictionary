package com.controllers;

import com.model.PatternModel;
import com.model.dto.AddPatternDTO;
import com.model.dto.DeletePatternDTO;
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
    public String addPattern(Model model, AddPatternDTO addPatternDTO){
        model.addAttribute("addPatternDTO", addPatternDTO);
        return "pattern/addPattern";
    }
    @PostMapping("/addPattern")
    public String addLanguage(@ModelAttribute(name = "addPatternDTO") AddPatternDTO addPatternDTO) {
        patternService.save(addPatternDTO);
        return "redirect:/pattern";
    }
    @GetMapping("/deletePattern")
    public String deletePattern(DeletePatternDTO deletePatternDTO, Model model){
        model.addAttribute("deletePatternDTO", deletePatternDTO);
        return "pattern/deletePattern";
    }
    @PostMapping("/deletePattern")
    public String deletePattern(@ModelAttribute(name = "deletePatternDTO") DeletePatternDTO deletePatternDTO) {
        patternService.delete(deletePatternDTO);
        return "redirect:/pattern";
    }
}
