package org.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class LivroAutorRepository {


    private final JdbcTemplate jdbcTemplate;

    public LivroAutorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addAutorToLivro(Long livroId, Long autorId) {
        String sql = "INSERT INTO livro_autor (livro_id, autor_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, livroId, autorId);
    }

    public int removeAutorFromLivro(Long livroId, Long autorId) {
        String sql = "DELETE FROM livro_autor WHERE livro_id = ? AND autor_id = ?";
        return jdbcTemplate.update(sql, livroId, autorId);
    }
}
