package com.myprojects.kursspring.controllers;

import com.myprojects.kursspring.domain.Knight;
import com.myprojects.kursspring.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {

        return "knightform";
    }

}
