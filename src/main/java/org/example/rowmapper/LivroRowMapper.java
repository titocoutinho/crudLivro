package org.example.rowmapper;

import org.example.entidade.Livro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
// RowMapper para mapear os resultados SQL para objetos Livro
public class LivroRowMapper implements RowMapper<Livro> {
    @Override
    public Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Livro livro = new Livro();
        livro.setId(rs.getLong("id"));
        livro.setTitulo(rs.getString("titulo"));
        livro.setIsbn(rs.getString("isbn"));
        livro.setEditora(rs.getString("editora"));
        livro.setAnoPublicacao(rs.getInt("ano_publicacao"));
        return livro;
    }
}
