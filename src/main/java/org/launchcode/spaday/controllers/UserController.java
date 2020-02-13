package org.launchcode.spaday.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {

    @GetMapping("/user/add")
    public String displayAddUserForm() {
        return "add.html";
    }


}
