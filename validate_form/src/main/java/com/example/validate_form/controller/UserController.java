package com.example.validate_form.controller;


import com.example.validate_form.dto.UserRequestDto;
import com.example.validate_form.model.User;
import com.example.validate_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

//    @GetMapping("")
//    public String showList(Model model) {
//        model.addAttribute("userList", userService.findAll());
//        return "view/index";
//    }

    @GetMapping("")
    public String showFormAdd(Model model) {
        model.addAttribute("userRequestDto", new UserRequestDto());
        return "view/index";
    }

    @PostMapping("/validateUser")
    public String save(@Validated @ModelAttribute UserRequestDto userRequestDto, BindingResult bindingResult) {
        User user = new User();
        new UserRequestDto().validate(userRequestDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "view/index";
        }
        BeanUtils.copyProperties(userRequestDto, user);
        userService.add(user);
        return "view/result";
    }
}
