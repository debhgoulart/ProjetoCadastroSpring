package com.cadastro.demo.dto;

import com.cadastro.demo.entidades.Usuario;

public record DadosUsuario (

        Long id,
        String nome,
        String email,
        String telefone
) {
        public DadosUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
