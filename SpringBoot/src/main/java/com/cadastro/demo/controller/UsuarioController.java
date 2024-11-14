package com.cadastro.demo.controller;

import com.cadastro.demo.entidades.Usuario;
import com.cadastro.demo.repository.UsuarioRepository;
import com.cadastro.demo.service.UsuarioService;
import com.cadastro.demo.dto.DadosAtualizarUsuario;
import com.cadastro.demo.dto.DadosCadastroUsuario;
import com.cadastro.demo.dto.DadosUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }

    @PostMapping(value = "/list")
    @Transactional
    public void cadastrarMaisDeUmUsuario(@RequestBody @Valid List<DadosCadastroUsuario> lista) {
        lista.forEach(dados -> repository.save(new Usuario(dados)));

    }

    @GetMapping(value = "/{id}")
    public DadosUsuario findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public Page<DadosUsuario> listarTodosUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ) {
        return repository.findAll(paginacao).map(DadosUsuario::new);
    }

    @PutMapping
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }
}