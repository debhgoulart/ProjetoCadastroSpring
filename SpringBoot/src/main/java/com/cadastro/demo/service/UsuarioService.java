package com.cadastro.demo.service;

import com.cadastro.demo.entidades.Usuario;
import com.cadastro.demo.repository.UsuarioRepository;
import com.cadastro.demo.dto.DadosUsuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public DadosUsuario findById(Long id) {
        Usuario entity = repository.getReferenceById(id);
        DadosUsuario dto = new DadosUsuario(entity);
        return dto;
    }
}
