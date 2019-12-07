package com.myprojects.kursspring.controllers;

import com.myprojects.kursspring.components.TimeComponent;
import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.domain.PlayerInformation;
import com.myprojects.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("ERRORS!!!!");
            bindingResult.getAllErrors()
                    .forEach(objectError -> System.out.println(objectError.getObjectName() + " " + objectError.getDefaultMessage()));
            return "knightform";
        } else {
            service.saveKnight(knight);
            return "redirect:/knights";
        }

    }

    @RequestMapping(value = "/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timeComponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";
    }

    @RequestMapping(value = "/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        service.deleteKnight(id);
        return "redirect:/knights";
    }
}
