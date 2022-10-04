package com.controllers;

import com.DAO.Storage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final Storage storage;
    public MainController(Storage storage) {
        this.storage = storage;
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

    @GetMapping("/menu1")
    public String firstMenu(Model model) {
        model.addAttribute("message", "In this dictionary, the length of words can be only 4 characters and these characters are only letters of the Latin layout");
        return "/menu1";
    }

    @GetMapping("/menu2")
    public String secondMenu(Model model) {
        model.addAttribute("message", "In this dictionary, the length of words can be only 5 characters and these characters are only numbers");
        return "/menu2";
    }

    @GetMapping("/dictionaryMenu/viewAll")
    public String viewAll() {
        return "/dictionaryMenu/viewAll";
    }

    @GetMapping("/dictionaryMenu/add")
    public String add() {
        return "/dictionaryMenu/add";
    }

    @GetMapping("/dictionaryMenu/delete")
    public String delete() {
        return "/dictionaryMenu/delete";
    }

    @GetMapping("/dictionaryMenu/search")
    public String search() {
        return "/dictionaryMenu/search";
    }
}
