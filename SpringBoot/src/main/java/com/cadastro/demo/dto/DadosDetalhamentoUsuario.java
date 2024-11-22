package com.cadastro.demo.dto;

import com.cadastro.demo.entidades.Endereco;
import com.cadastro.demo.entidades.Usuario;

public record DadosDetalhamentoUsuario (
        Long id,
        String nome,
        String email,
        String telefone,
        Endereco endereco
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getEndereco()
        );
    }
}
