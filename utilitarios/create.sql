create database livrosdb;

CREATE TABLE livros (
                        id SERIAL PRIMARY KEY,          -- Identificador único do livro
                        titulo VARCHAR(255) NOT NULL,   -- Título do livro
                        isbn VARCHAR(20) UNIQUE,        -- Código ISBN (único)
                        editora VARCHAR(100),           -- Editora do livro
                        ano_publicacao INT,             -- Ano de publicação
                        genero VARCHAR(50),             -- Gênero literário
                        num_paginas INT,                -- Número de páginas
                        idioma VARCHAR(50),             -- Idioma do livro
                        sinopse TEXT,                   -- Breve descrição do livro
                        status VARCHAR(20) DEFAULT 'disponível'  -- Status de disponibilidade
);

CREATE TABLE autores (
                         id SERIAL PRIMARY KEY,          -- Identificador único do autor
                         nome VARCHAR(255) NOT NULL,     -- Nome completo do autor
                         data_nascimento DATE,           -- Data de nascimento do autor
                         nacionalidade VARCHAR(100),     -- Nacionalidade do autor
                         biografia TEXT                  -- Biografia breve do autor
);

CREATE TABLE livro_autor (
                             livro_id INT REFERENCES livros(id) ON DELETE CASCADE,  -- Chave estrangeira para tabela livros
                             autor_id INT REFERENCES autores(id) ON DELETE CASCADE, -- Chave estrangeira para tabela autores
                             PRIMARY KEY (livro_id, autor_id)  -- Chave composta para garantir a unicidade das relações
);


-- Inserindo um livro
INSERT INTO livros (titulo, isbn, editora, ano_publicacao, genero, num_paginas, idioma, sinopse, status)
VALUES ('Livro Exemplo', '1234567890123', 'Editora Exemplo', 2024, 'Ficção', 300, 'Português', 'Sinopse do livro', 'disponível');

-- Inserindo dois autores
INSERT INTO autores (nome, data_nascimento, nacionalidade, biografia)
VALUES ('Autor 1', '1970-05-12', 'Brasileiro', 'Biografia do Autor 1');

INSERT INTO autores (nome, data_nascimento, nacionalidade, biografia)
VALUES ('Autor 2', '1985-09-30', 'Brasileiro', 'Biografia do Autor 2');

-- Relacionando o livro aos dois autores (assumindo que o ID do livro inserido é 1 e os IDs dos autores são 1 e 2)
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 1);
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 2);