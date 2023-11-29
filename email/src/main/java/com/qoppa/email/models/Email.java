package com.qoppa.email.models;

import java.time.LocalDateTime;

import com.qoppa.email.enums.StatusEmailEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String ownerRef;
    private String emailForm;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "text")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmailEnum statusEmail;

}
