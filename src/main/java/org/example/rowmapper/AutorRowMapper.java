package org.example.rowmapper;

import org.example.entidade.Autor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AutorRowMapper implements RowMapper<Autor> {
    @Override
    public Autor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Autor autor = new Autor();
        autor.setId(rs.getLong("id"));
        autor.setNome(rs.getString("nome"));
        autor.setNacionalidade(rs.getString("nacionalidade"));
        return autor;
    }
}
