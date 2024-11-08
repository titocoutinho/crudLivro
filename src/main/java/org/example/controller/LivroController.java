package org.example.controller;

import org.example.entidade.Livro;
import org.example.repository.LivroAutorRepository;
import org.example.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {


    private final LivroRepository livroRepository;
    private final LivroAutorRepository livroAutorRepository;


    public LivroController(LivroRepository livroRepository, LivroAutorRepository livroAutorRepository){
        this.livroRepository = livroRepository;
        this.livroAutorRepository = livroAutorRepository;
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro getLivroById(@PathVariable Long id) {
        return livroRepository.findById(id);
    }

    @PostMapping
    public int createLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public int updateLivro(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        livroAtualizado.setId(id);
        return livroRepository.update(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public int deleteLivro(@PathVariable Long id) {
        return livroRepository.deleteById(id);
    }

    // Endpoint para obter livros por autor
    @GetMapping("/por-autor/{autorId}")
    public List<Livro> getLivrosPorAutor(@PathVariable("autorId") int autorId) {
        return livroAutorRepository.findLivrosByAutorId(autorId);
    }

    // Endpoint para obter todos os livros por todos os autores
    @GetMapping("/todos-autores")
    public List<Livro> getTodosLivrosPorTodosAutores() {
        return livroRepository.findAllLivrosComAutores();
    }
}