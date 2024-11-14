package com.cadastro.demo.entidades;

import com.cadastro.demo.dto.DadosEndereco;
import jakarta.persistence.*;

@Embeddable
public class Endereco {

    private String logradouro;
    private Long numero;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco() {
    }

    public Endereco(String logradouro, Long numero, String barro, String complemento, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = barro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarInformacoes(DadosEndereco dados) {
        if(dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if(dados.numero() != null) {
            this.numero = dados.numero();
        }
        if(dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if(dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if(dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if(dados.uf() != null) {
            this.uf = dados.uf();
        }
        if(dados.cep() != null) {
            this.cep = dados.cep();
        }
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getBarro() {
        return bairro;
    }

    public void setBarro(String barro) {
        this.bairro = barro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
