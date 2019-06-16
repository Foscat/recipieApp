package com.springBoot.controllers;

import com.springBoot.services.RecipieService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private RecipieService recipieService;

    public MainController(RecipieService recipieService){
        this.recipieService = recipieService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){

        model.addAttribute("recipies", recipieService.getRecipies());
        System.out.println(model);

        return "index";

    }

}
