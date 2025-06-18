package com.example.bai_tap_1_ss2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @GetMapping("condiment")
    public String list() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam( value = "condiment", required = false) String[] condiment, Model model) {
        model.addAttribute("selectedCondiments", condiment);
        return "result";
    }
}
