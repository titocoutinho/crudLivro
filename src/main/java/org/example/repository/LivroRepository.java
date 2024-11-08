package org.example.repository;

import org.example.entidade.Livro;
import org.example.rowmapper.LivroRowMapper;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivroRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final  LivroRowMapper livroRowMapper = new LivroRowMapper();

    public LivroRepository( NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Livro> findAll() {
        String sql = "SELECT * FROM livro";
        return namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource(), livroRowMapper);
    }

    public Livro findById(Long id) {
        String sql = "SELECT * FROM livro WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, livroRowMapper);
    }

    public int save(Livro livro) {
        String sql = "INSERT INTO livro (titulo, isbn, editora, ano_publicacao) VALUES (:titulo, :isbn, :editora, :anoPublicacao)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("titulo", livro.getTitulo())
                .addValue("isbn", livro.getIsbn())
                .addValue("editora", livro.getEditora())
                .addValue("anoPublicacao", livro.getAnoPublicacao());
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public int update(Livro livro) {
        String sql = "UPDATE livro SET titulo = :titulo, isbn = :isbn, editora = :editora, ano_publicacao = :ano_publicacao WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", livro.getId())
                .addValue("titulo", livro.getTitulo())
                .addValue("isbn", livro.getIsbn())
                .addValue("editora", livro.getEditora())
                .addValue("anoPublicacao", livro.getAnoPublicacao());
        return namedParameterJdbcTemplate.update(sql, params);
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM livro WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

      return  namedParameterJdbcTemplate.update(sql, params);
    }

    // Método para obter todos os livros com seus respectivos autores
    public List<Livro> findAllLivrosComAutores() {
        String sql = "SELECT * FROM livro " +
                "JOIN livro_autor ON livro.id = livro_autor.livro_id " +
                "JOIN autor ON autor.id = livro_autor.autor_id";
        return namedParameterJdbcTemplate.query(sql, livroRowMapper);
    }
}
