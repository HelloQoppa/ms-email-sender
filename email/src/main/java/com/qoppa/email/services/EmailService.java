package com.qoppa.email.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.qoppa.email.enums.StatusEmailEnum;
import com.qoppa.email.interfaces.IEmail;
import com.qoppa.email.models.Email;
import com.qoppa.email.repositories.EmailRepository;

@Service
public class EmailService implements IEmail<Email> {

    @Autowired
    EmailRepository emailRepository;
    @Autowired
    JavaMailSender eMailSender;

    @Override
    public Email sendEmail(Email email) {

        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailForm());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            eMailSender.send(message);

            email.setStatusEmail(StatusEmailEnum.SEND);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmailEnum.ERROR);
        } finally {
            //implementar tratamento de erros para email error
            return emailRepository.save(email);
        }


    }

}
