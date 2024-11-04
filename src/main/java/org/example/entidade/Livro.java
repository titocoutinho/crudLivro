package org.example.entidade;

public class Livro {
    private Long id;
    private String titulo;
    private String isbn;
    private String editora;
    private int anoPublicacao;

    public Livro(){
        // construtor vazio

    }

    public Livro(String titulo){
        this.titulo = titulo;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // get id
    public Long getId() {
        return id;
    }

    // set id
    public void setId(Long id) {
        this.id = id;
    }
    // Getters (recupera) e setters (Informa)
}