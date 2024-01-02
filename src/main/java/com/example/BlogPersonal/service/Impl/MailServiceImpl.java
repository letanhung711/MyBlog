package com.example.BlogPersonal.service.Impl;

import com.example.BlogPersonal.dto.MailDto;
import com.example.BlogPersonal.model.Mail;
import com.example.BlogPersonal.repository.MailRepository;
import com.example.BlogPersonal.service.DateTimeService;
import com.example.BlogPersonal.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;

@Service
public class MailServiceImpl implements MailService {
    @Value("${spring.mail.username}")
    private String fromEmail;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailRepository mailRepository;
    @Autowired
    private DateTimeService dateTimeService;

    @Override
    public Mail saveMail(MailDto mailDto) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if(mailDto == null){
            return null;
        }else {
            Mail mail = new Mail();
            mail.setName(mailDto.getName());
            mail.setSubject(mailDto.getSubject());
            mail.setEmail(mailDto.getEmail());
            mail.setMessage(mailDto.getMessage());
            mail.setCreate_time(timestamp);
            mailRepository.save(mail);
            return mail;
        }
    }

    @Override
    public String sendMail(Mail mail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo("letanhung711@gmail.com");
            mimeMessageHelper.setSubject(mail.getSubject() + " - LeHung Blog");

            String body = "Name: " + mail.getName() +"\n"
                    + "Email: " + mail.getEmail() + "\n"
                    + "Send date: " + dateTimeService.DateFormatTime(mail.getCreate_time().toString()) +"\n\n"
                    + "Message: " + mail.getMessage() + "\n\n"
                    + "LeHung Blog";

            mimeMessageHelper.setText(body);
            javaMailSender.send(mimeMessage);
            return "mail send";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
