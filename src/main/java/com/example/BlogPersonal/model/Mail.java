package com.example.BlogPersonal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String subject;
    private String email;
    @Column(columnDefinition = "LONGTEXT")
    private String message;
    private Timestamp create_time;
}
