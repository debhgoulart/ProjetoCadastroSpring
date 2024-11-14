package com.cadastro.demo.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

        @NotNull(message = "Este campo não pode ser nulo.")
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
