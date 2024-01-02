package com.example.BlogPersonal.service;

import com.example.BlogPersonal.dto.MailDto;
import com.example.BlogPersonal.model.Mail;

public interface MailService {
    Mail saveMail(MailDto mailDto);
    String sendMail(Mail mail);
}
