package com.ms.emailservice.models;

import com.ms.emailservice.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_email")
    private UUID idEmail;

    @Column(name = "nome_remetente")
    private String nomeRemetente;

    @Column(name = "email_remetente")
    private String emailDoRemetente;

    @Column(name = "email_destinatario")
    private String emailDoDestinatario;

    private String titulo;
    //permite que sejam persistidos no banco registros com tamanho superior ao padrão (250 caracteres).
    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "data_de_envio")
    private LocalDateTime dataDeEnvio;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEmail statusEmail;
}
