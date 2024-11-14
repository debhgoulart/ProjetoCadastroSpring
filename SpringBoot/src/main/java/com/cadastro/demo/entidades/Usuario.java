package com.cadastro.demo.entidades;

import com.cadastro.demo.dto.DadosAtualizarUsuario;
import com.cadastro.demo.dto.DadosCadastroUsuario;
import com.cadastro.demo.dto.DadosEndereco;
import com.cadastro.demo.dto.DadosUsuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;

    @Embedded
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.senha = dados.senha();
        this.endereco = new Endereco(dados.endereco());
    }

//    public Usuario(DadosUsuario dadosUsuario) {
//        this.id = dadosUsuario.id();
//        this.nome = dadosUsuario.nome();
//        this.email = dadosUsuario.email();
//    }

    public void atualizarInformacoes(DadosAtualizarUsuario dados) {
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}