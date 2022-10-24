package com.controllers;

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
        model.addAttribute("deletePatternDTO", new DeletePatternDTO());
        return "/pattern/mainMenu";
    }

    @GetMapping("/addPattern")
    public String addPattern(Model model) {
        model.addAttribute("addPatternDTO", new AddPatternDTO());
        return "pattern/addPattern";
    }

    @PostMapping("/addPattern")
    public String addLanguage(@ModelAttribute(name = "addPatternDTO") AddPatternDTO addPatternDTO) {
        patternService.save(addPatternDTO);
        return "redirect:/pattern";
    }

    @PostMapping("/deletePattern")
    public String deletePattern(@ModelAttribute(name = "deletePatternDTO") DeletePatternDTO deletePatternDTO) {
        patternService.delete(deletePatternDTO);
        return "redirect:/pattern";
    }


}
