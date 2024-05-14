package com.ms.emailservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailDto {
    @NotBlank
    private String nomeRemetente;

    @NotBlank
    @Email
    private String emailDoRemetente;

    @NotBlank
    @Email
    private String emailDoDestinatario;

    @NotBlank
    private String titulo;

    @NotBlank
    private String text;
}
