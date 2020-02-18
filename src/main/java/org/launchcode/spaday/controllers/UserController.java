package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.Client;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

public class UserController {

    @GetMapping ("user/add")
    public String displayAddUserForm(Model model, User user) {
        model.addAttribute("title", "User Application");
        model.addAttribute(user = new User());
        return "user/add";
    }

    @PostMapping ("user/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        user = new User(user.getUsername(), user.getEmail(), user.getPassword());
        //model.addAttribute("user", user);
        //model.addAttribute("verify", verify);
        if(errors.hasErrors()) {
            model.addAttribute("title", "User Application");
            return "user/add";
        }

        if (!verify.equals(user.getPassword())) {
            return "user/add";
    }
        return "user/index";
    }
}
