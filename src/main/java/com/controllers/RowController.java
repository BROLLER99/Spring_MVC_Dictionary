package com.controllers;

import com.model.dto.AddRowDTO;
import com.model.dto.DeleteRowDTO;
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
        return "/row/allRows";
    }

    @GetMapping("/addRow/{id}")
    public String addRow(Model model, @PathVariable("id") String idOfChosenPattern) {
        model.addAttribute("addRowDTO", new AddRowDTO());
        model.addAttribute("idOfChosenPattern", idOfChosenPattern);
//        model.addAttribute("pattern", patternService.getPatternById(idOfChosenPattern));
        return "row/addRow";
    }

    @PostMapping("/addRow/{id}")
    public String addRow(@ModelAttribute(name = "addRowDTO") AddRowDTO addRowDTO, @PathVariable("id") String idOfChosenPattern) {
        addRowDTO.setIdOfChosenPattern(idOfChosenPattern);//todo не разобрался как в html установить id паттерна
        rowService.save(addRowDTO);
        return "redirect:/row/{id}";
    }

    @GetMapping("/deleteRow/{id}")
    public String deleteRow(Model model, @PathVariable("id") String patternId, @RequestParam(value = "idOfRow") String idOfRow, @RequestParam(value = "word") String word) {
        rowService.findById(idOfRow);
        model.addAttribute("deleteRowDTO", new DeleteRowDTO());
        model.addAttribute("rowId", idOfRow);
        model.addAttribute("word", word);
        model.addAttribute("patternId", patternId);
        return "row/deleteRow";
    }

    @PostMapping("/deleteRow/{id}")
    public String deleteRow(@ModelAttribute(name = "deleteRowDTO") DeleteRowDTO deleteRowDTO, @PathVariable("id") String idOfChosenPattern) {
        System.out.println(deleteRowDTO.getIdOfRow());
        rowService.delete(deleteRowDTO);
        return "redirect:/row/{id}";
    }
}
