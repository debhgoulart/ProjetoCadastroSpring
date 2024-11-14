CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    logradouro VARCHAR(255),
    numero INT,
    bairro VARCHAR(255),
    complemento VARCHAR(255),
    cidade VARCHAR(255),
    uf CHAR(2),
    cep VARCHAR(10)
);