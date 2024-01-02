package com.example.BlogPersonal.controller;

import com.example.BlogPersonal.dto.MailDto;
import com.example.BlogPersonal.model.Mail;
import com.example.BlogPersonal.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/send/mail", method = RequestMethod.POST)
    private String sendMail(@ModelAttribute MailDto mailDto, Model model){
        Mail mail = mailService.saveMail(mailDto);
        if(mail == null) {
            model.addAttribute("message", "Not data found!!!");
            return "redirect:/page/404";
        } else {
            mailService.sendMail(mail);
            return "redirect:/page/mail_confirm";
        }
    }
}
