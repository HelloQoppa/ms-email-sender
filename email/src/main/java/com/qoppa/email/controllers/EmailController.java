package com.qoppa.email.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.qoppa.email.dtos.EmailDTO;
import com.qoppa.email.models.Email;
import com.qoppa.email.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Email sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
        return email;

    }
}
