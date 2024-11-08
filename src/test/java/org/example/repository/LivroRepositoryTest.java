package org.example.repository;


import org.example.entidade.Livro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LivroRepositoryTest  {

    @Autowired
    private LivroRepository livroRepository;


    @Test
    public void findAll() {
        // Executa o método findAll e verifica o resultado
        List<Livro> livros = livroRepository.findAll();

        // Verifica se a lista não está vazia e contém o número correto de livros
        assertFalse(livros.isEmpty());
        assertEquals(1, livros.size());

        // Verifica os valores do primeiro livro
        Livro primeiroLivro = livros.get(0);
        assertEquals("Livro Exemplo", primeiroLivro.getTitulo());
        assertEquals("1234567890123", primeiroLivro.getIsbn());
        assertEquals("Editora Exemplo", primeiroLivro.getEditora());
        assertEquals(2024, (int) primeiroLivro.getAnoPublicacao());
    }

    @Test
    public void findById() {
        // Executa o método findAll e verifica o resultado
        Livro livros = livroRepository.findById(1l);

        // Verifica se a lista não está vazia e contém o número correto de livros
        assertFalse(Objects.isNull(livros));


        // Verifica os valores do primeiro livro

        assertEquals("Livro Exemplo", livros.getTitulo());
        assertEquals("1234567890123", livros.getIsbn());
        assertEquals("Editora Exemplo", livros.getEditora());
        assertEquals(2024, (int) livros.getAnoPublicacao());
    }

    @Test
    public void save() {
        Livro livro = new Livro(0, "Meu livro", "abc-1243", "Maria e João", 2014);
        int valorRetorno = livroRepository.save(livro);

        assertEquals(1, valorRetorno);
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
        // Executa o método findAll e verifica o resultado
        List<Livro> livros = livroRepository.findAll();
        if(livros.size() > 1){
            int valorRetorno = livroRepository.deleteById(livros.get(livros.size() -1).getId());
            assertEquals("Deletado por mais de um Registro", 1, valorRetorno);
        }else{
            assertEquals("Não deletado por só ter um registro", 1, livros.size() );
        }

    }
}