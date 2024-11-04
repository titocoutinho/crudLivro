package org.example.controller;

import org.example.entidade.Livro;
import org.example.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

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
}