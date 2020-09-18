CREATE DATABASE conveniencia;

USE conveniencia;

CREATE TABLE cliente (
   codigoCliente INT primary key,
   nome VARCHAR(60),
   cpf VARCHAR(45),
   endereco VARCHAR(45),
   cidade VARCHAR(45),
   estado VARCHAR(45),
   telefone VARCHAR(45)
);

CREATE TABLE produto (
   codigo INT primary key,
   descricao VARCHAR(60),
   preco DOUBLE,
   quantidade INT
);
