package com.example.BlogPersonal.controller;

import com.example.BlogPersonal.model.User;
import com.example.BlogPersonal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private String verifyLogin(){
        return "/components/admin/index";
    }
}
