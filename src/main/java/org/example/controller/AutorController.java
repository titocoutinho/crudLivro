package org.example.controller;

import org.example.entidade.Autor;
import org.example.repository.AutorRepository;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorRepository autorRepository;

    // Injeção de dependência por construtor
    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    // Endpoint para obter todos os autores
    @GetMapping
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // Endpoint para obter um autor por ID
    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable("id") int id) {
        Optional<Autor> autor = Optional.ofNullable(autorRepository.findById((long) id));
        return autor.orElse(null);  // Retorna null se não encontrar
    }

    // Endpoint para criar um novo autor
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAutor(@RequestBody Autor autor) {
        autorRepository.save(autor);
    }

    // Endpoint para atualizar um autor existente
    @PutMapping("/{id}")
    public void updateAutor(@PathVariable("id") int id, @RequestBody Autor autor) {
        autor.setId((long) id);
        autorRepository.update(autor);
    }

    // Endpoint para deletar um autor
    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable("id") int id) {
        autorRepository.deleteById((long) id);
    }
}

