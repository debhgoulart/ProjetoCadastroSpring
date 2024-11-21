package com.cadastro.demo.repository;

import com.cadastro.demo.entidades.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findAllByAtivoTrue(Pageable paginacao);
}