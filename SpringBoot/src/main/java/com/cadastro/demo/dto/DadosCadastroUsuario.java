package com.cadastro.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroUsuario(

        @NotBlank(message = "Este campo não pode ser nulo.")
        String nome,

        @NotBlank(message = "Este campo não pode ser nulo.")
                @Email
        String email,

        @NotBlank(message = "Este campo não pode ser nulo.")
                @Pattern(regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}|\\(?\\d{2}\\)?\\s?\\d{9}",
                         message = "Número não válido")
        String telefone,

        @Valid
        DadosEndereco endereco,

        @NotBlank(message = "Este campo não pode ser nulo.")
        String senha
) {
}
