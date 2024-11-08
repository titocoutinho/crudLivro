package org.example.repository;

import org.example.entidade.Autor;
import org.example.rowmapper.AutorRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorRepository {
    private final JdbcTemplate jdbcTemplate;
    private static final AutorRowMapper autorRowMapper = new AutorRowMapper();

    public AutorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // CRUD - Métodos

    public List<Autor> findAll() {
        String sql = "SELECT * FROM autor";
        return jdbcTemplate.query(sql, autorRowMapper);
    }

    public Autor findById(Long id) {
        String sql = "SELECT * FROM autor WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, autorRowMapper, id);
    }

    public int save(Autor autor) {
        String sql = "INSERT INTO autor (nome, nacionalidade) VALUES (?, ?)";
        return jdbcTemplate.update(sql, autor.getNome(), autor.getNacionalidade());
    }

    public int update(Autor autor) {
        String sql = "UPDATE autor SET nome = ?, nacionalidade = ? WHERE id = ?";
        return jdbcTemplate.update(sql, autor.getNome(), autor.getNacionalidade(), autor.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM autor WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
