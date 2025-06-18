package com.example.bai_tap_2_ss2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {

    @GetMapping("calculator")
    public String list() {
        return "index";
    }

    @PostMapping("calculator")
    public String result(@RequestParam(defaultValue = "0") int num1, @RequestParam(defaultValue = "0") int num2, @RequestParam String cal, RedirectAttributes attributes) {
        Integer result = null;
        String mess = null;
        switch (cal) {
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtraction(-)":
                result = num1 - num2;
                break;
            case "Multiplication(x)":
                result = num1 * num2;
                break;
            case "Division(/)":
                if (num2 == 0) {
                    mess = "Không có phép chia cho 0";
                    break;
                } else {
                    result = num1 / num2;
                    break;
                }
            default:
                mess = "Mời Nhập số";
                break;
        }
        attributes.addFlashAttribute("result", result);
        attributes.addFlashAttribute("mess", mess);
        attributes.addFlashAttribute("num1", num1);
        attributes.addFlashAttribute("num2", num2);
        return "redirect:/calculator";
    }

}
