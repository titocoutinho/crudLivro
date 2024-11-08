package org.example.repository;

import org.example.entidade.Livro;
import org.example.rowmapper.LivroRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;


    private final  LivroRowMapper livroRowMapper = new LivroRowMapper();

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livro> findAll() {
        String sql = "SELECT * FROM livros";
        return jdbcTemplate.query(sql, livroRowMapper);
    }

    public Livro findById(Long id) {
        String sql = "SELECT * FROM livros WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, livroRowMapper, id);
    }

    public int save(Livro livro) {
        String sql = "INSERT INTO livros (titulo, isbn, editora, ano_publicacao) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, livro.getTitulo(), livro.getIsbn(), livro.getEditora(), livro.getAnoPublicacao());
    }

    public int update(Livro livro) {
        String sql = "UPDATE livros SET titulo = ?, isbn = ?, editora = ?, ano_publicacao = ? WHERE id = ?";
        return jdbcTemplate.update(sql, livro.getTitulo(), livro.getIsbn(), livro.getEditora(), livro.getAnoPublicacao(), livro.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM livros WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
