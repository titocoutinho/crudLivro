CREATE TABLE IF NOT EXISTS livro (
  id SERIAL PRIMARY KEY,          -- Identificador único do livro
  titulo VARCHAR(255) NOT NULL,   -- Título do livro
  isbn VARCHAR(36) UNIQUE,        -- Código ISBN (único)
  editora VARCHAR(100),           -- Editora do livro
  ano_publicacao INT,             -- Ano de publicação
  genero VARCHAR(50),             -- Gênero literário
  num_paginas INT,                -- Número de páginas
  idioma VARCHAR(50),             -- Idioma do livro
  sinopse TEXT,                   -- Breve descrição do livro
  status VARCHAR(20) DEFAULT 'disponível'  -- Status de disponibilidade
);

CREATE TABLE IF NOT EXISTS autor (
  id SERIAL PRIMARY KEY,          -- Identificador único do autor
  nome VARCHAR(255) NOT NULL,     -- Nome completo do autor
  data_nascimento DATE,           -- Data de nascimento do autor
  nacionalidade VARCHAR(100),     -- Nacionalidade do autor
  biografia TEXT                  -- Biografia breve do autor
);

CREATE TABLE IF NOT EXISTS livro_autor (
  livro_id INT REFERENCES livro(id) ON DELETE CASCADE,  -- Chave estrangeira para tabela livros
  autor_id INT REFERENCES autor(id) ON DELETE CASCADE, -- Chave estrangeira para tabela autores
  PRIMARY KEY (livro_id, autor_id)  -- Chave composta para garantir a unicidade das relações
);
