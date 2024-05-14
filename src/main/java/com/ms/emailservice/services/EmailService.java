package com.ms.emailservice.services;

import com.ms.emailservice.enums.StatusEmail;
import com.ms.emailservice.models.Email;
import com.ms.emailservice.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    public Email enviarEmail(Email email) {
        email.setDataDeEnvio(LocalDateTime.now());
        try {
            prepararEEnviarEmail(email);

            email.setStatusEmail(StatusEmail.ENVIADO);

        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERRO_DE_ENVIO);

        } finally {
            return emailRepository.save(email);
        }
    }

    private void prepararEEnviarEmail(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(email.getEmailDoRemetente());
        message.setTo(email.getEmailDoDestinatario());
        message.setSubject(email.getTitulo());
        message.setText(email.getText());

        emailSender.send(message);
    }
}
