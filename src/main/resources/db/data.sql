
-- Inserindo um livro
INSERT INTO livro (titulo, isbn, editora, ano_publicacao, genero, num_paginas, idioma, sinopse, status)
VALUES ('Livro Exemplo', '1234567890123', 'Editora Exemplo', 2024, 'Ficção', 300, 'Português', 'Sinopse do livro', 'disponível');

-- Inserindo dois autores
INSERT INTO autor (nome, data_nascimento, nacionalidade, biografia)
VALUES ('Autor 1', '1970-05-12', 'Brasileiro', 'Biografia do Autor 1');

INSERT INTO autor (nome, data_nascimento, nacionalidade, biografia)
VALUES ('Autor 2', '1985-09-30', 'Brasileiro', 'Biografia do Autor 2');

-- Relacionando o livro aos dois autores (assumindo que o ID do livro inserido é 1 e os IDs dos autores são 1 e 2)
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 1);
INSERT INTO livro_autor (livro_id, autor_id) VALUES (1, 2);