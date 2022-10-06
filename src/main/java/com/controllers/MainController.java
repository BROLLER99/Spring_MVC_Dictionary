package com.controllers;

import com.DAO.LocalStorage;
import com.DAO.Storage;
import com.model.RuleOfDictionary;
import com.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/mainMenu")
    public String startApp(Model model) {
        model.addAttribute("message", "Choose the dictionary");
        return "/mainMenu";
    }

    @GetMapping("/exit")
    public String exitApp() {
        return "/exit";
    }

    @GetMapping("/menu")
    public String firstMenu(@ModelAttribute("ruleOfDictionary") RuleOfDictionary ruleOfDictionary, Model model) {
        System.out.println(System.getProperty("user.dir"));
        mainService.createFile(ruleOfDictionary.getNameOfFile());
//        model.addAttribute("message", "In this dictionary, the length of words can be only 4 characters and these characters are only letters of the Latin layout");
        model.addAttribute("message", ruleOfDictionary.getDescription());
        return "/menu";
    }

//    @GetMapping("/menu2")
//    public String secondMenu(@ModelAttribute("ruleOfDictionary") RuleOfDictionary ruleOfDictionary, Model model) {
//        mainService.createFile(ruleOfDictionary.getNameOfFile());
//        model.addAttribute("message", "In this dictionary, the length of words can be only 5 characters and these characters are only numbers");
//        return "/menu2";
//    }

    @GetMapping("/commands/viewAll")
    public String viewAll(Model model) throws IOException {
        System.out.println(mainService.outputAllElements());
        model.addAttribute("message", mainService.outputAllElements());
        return "/commands/viewAll";
    }

        @GetMapping("/commands/add")
    public String add(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        mainService.addElement(key, value);
        return "/commands/add";
    }

    @GetMapping("/commands/addPage")
    public String add() {
        return "/commands/addPage";
    }

    @GetMapping("/commands/delete")
    public String delete(@RequestParam(value = "key") String key) {
        mainService.deleteElement(key);
        return "/commands/delete";
    }
    @GetMapping("/commands/deletePage")
    public String delete() {
        return "/commands/deletePage";
    }

    @GetMapping("/commands/search")
    public String search(@RequestParam(value = "key") String key, Model model) {
        mainService.searchElement(key);
        model.addAttribute("message", mainService.searchElement(key));
        return "/commands/search";
    }
    @GetMapping("/commands/searchPage")
    public String search() {
        return "/commands/searchPage";
    }
}
