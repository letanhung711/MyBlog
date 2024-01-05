package com.example.BlogPersonal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/page")
public class PageController {
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    private String showEror(Model model){
        model.addAttribute("title", "Error 404 - Page Not Found");
        return "/components/pages/404";
    }
    @RequestMapping(value = "/mail_confirm", method = RequestMethod.GET)
    private String showMailConfirm(Model model){
        model.addAttribute("title", "Thank You!");
        return "/components/pages/mail-confirm";
    }
}
