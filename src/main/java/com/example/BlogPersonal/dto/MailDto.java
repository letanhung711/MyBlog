package com.example.BlogPersonal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data @AllArgsConstructor @NoArgsConstructor
public class MailDto {
    private String name;
    private String subject;
    private String email;
    private String message;
    private Timestamp create_time;
}
