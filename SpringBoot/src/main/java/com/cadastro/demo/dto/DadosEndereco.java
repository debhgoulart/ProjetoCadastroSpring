package com.cadastro.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank(message = "Este campo não pode ser nulo.")
        String logradouro,

        @NotNull(message = "Este campo não pode ser nulo.")
        Long numero,

        String complemento,

        @NotBlank(message = "Este campo não pode ser nulo.")
        String bairro,

        @NotBlank(message = "Este campo não pode ser nulo.")
        String cidade,

        @NotBlank(message = "Este campo não pode ser nulo.")
                @Pattern(regexp = "\\w{2}")
        String uf,

        @NotBlank(message = "Este campo não pode ser nulo.")
                @Pattern(regexp = "\\d{2}\\d{3}[-]\\d{3}|\\d{8}")
        String cep
) {
}
