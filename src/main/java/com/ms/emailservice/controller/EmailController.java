package com.ms.emailservice.controller;

import com.ms.emailservice.dtos.EmailDto;
import com.ms.emailservice.models.Email;
import com.ms.emailservice.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/enviar")
    public ResponseEntity<Email> enviarEmail(@RequestBody @Valid EmailDto emailDto) {
        Email email = new Email();

        BeanUtils.copyProperties(emailDto,email);

        return new ResponseEntity<>(emailService.enviarEmail(email), HttpStatus.CREATED);
    }
}
