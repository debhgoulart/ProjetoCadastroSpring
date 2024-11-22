package com.cadastro.demo.controller;

import com.cadastro.demo.dto.DadosDetalhamentoUsuario;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        var usuario = new Usuario(dados);
        repository.save(usuario);

        var uri = uriBuilder.path("/cadastros/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @PostMapping(value = "/list")
    @Transactional
    public ResponseEntity cadastrarMaisDeUmUsuario(@RequestBody @Valid List<DadosCadastroUsuario> lista) {
        lista.forEach(dados -> repository.save(new Usuario(dados)));

        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosUsuario> findById(@PathVariable Long id) {
        var dadosUsuario = service.findById(id);

        return ResponseEntity.ok(dadosUsuario);
    }

    @GetMapping
    public ResponseEntity<Page<DadosUsuario>> listarTodosUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao ) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosUsuario::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarUsuario(@RequestBody @Valid DadosAtualizarUsuario dados) {
        var usuario = repository.getReferenceById(dados.id()); //carrega id
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity excluirUsuario(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id); //carrega id
        usuario.excluir();

        return ResponseEntity.noContent().build();
    }
}