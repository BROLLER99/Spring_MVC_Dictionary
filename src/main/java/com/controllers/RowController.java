package com.controllers;

import com.model.dto.AddRowDTO;
import com.model.dto.DeleteRowDTO;
import com.model.dto.SearchRowDTO;
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
        model.addAttribute("listRows", rowService.findRowsByPattern(idOfChosenPattern));
        model.addAttribute("id", idOfChosenPattern);
        model.addAttribute("deleteRowDTO", new DeleteRowDTO());
        return "/row/allRows";
    }

    @GetMapping("/addRow/{id}")
    public String addRow(Model model, @PathVariable("id") String idOfChosenPattern) {
        model.addAttribute("addRowDTO", new AddRowDTO());
        model.addAttribute("idOfChosenPattern", idOfChosenPattern);
//        model.addAttribute("pattern", pattern);
        return "row/addRow";
    }

    @PostMapping("/addRow/{id}")
    public String addRow(@ModelAttribute(name = "addRowDTO") AddRowDTO addRowDTO, @PathVariable("id") String idOfChosenPattern) {
        rowService.save(addRowDTO);
        return "redirect:/row/{id}";
    }

    @PostMapping("/deleteRow/{id}")
    public String deleteRow(@ModelAttribute(name = "deleteRowDTO") DeleteRowDTO deleteRowDTO, @PathVariable("id") String idOfChosenPattern) {
        rowService.delete(deleteRowDTO);
        return "redirect:/row/{id}";
    }

    @GetMapping("/searchRow/{id}")
    public String search(@PathVariable("id") String idOfChosenPattern, Model model) {
        model.addAttribute("idOfChosenPattern", idOfChosenPattern);
        model.addAttribute("searchRowDTO", new SearchRowDTO());
        return "row/searchRow";
    }

    @GetMapping("/searchRow/result/{id}")
    public String search(@ModelAttribute(name = "searchRowDTO") SearchRowDTO searchRowDTO, Model model, @PathVariable("id") String idOfChosenPattern) {
        model.addAttribute("result", rowService.findByName(searchRowDTO));
        model.addAttribute("idOfChosenPattern", idOfChosenPattern);
        model.addAttribute("deleteRowDTO", new DeleteRowDTO());
        return "row/resultOfSearch";
    }
    @PostMapping("/searchRow/result/deleteRow/{id}")
    public String deleteRowInSearch(@ModelAttribute(name = "deleteRowDTO") DeleteRowDTO deleteRowDTO, @PathVariable("id") String idOfChosenPattern) {
        rowService.delete(deleteRowDTO);
        return "redirect:/row/{id}";
    }
}
