package com.controllers;

import com.model.PatternModel;
import com.service.PatternService;
import com.service.RowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addPattern(){

        return "/addPattern";
    }
}
