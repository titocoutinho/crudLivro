package org.example.repository;

import org.example.entidade.Livro;
import org.example.rowmapper.LivroRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroAutorRepository {


    private final JdbcTemplate jdbcTemplate;

    private final  LivroRowMapper livroRowMapper = new LivroRowMapper();

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

    // Método para buscar livros por autor
    public List<Livro> findLivrosByAutorId(int autorId) {
        String sql = "SELECT * FROM livro " +
                "JOIN livro_autor ON livro.id = livro_autor.livro_id " +
                "WHERE livro_autor.autor_id = ?";
        return jdbcTemplate.query(sql, livroRowMapper, autorId);
    }
}
