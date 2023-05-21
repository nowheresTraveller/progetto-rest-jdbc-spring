package com.example.demo.progettorestjdbcspring.db.dao.model;

public class Prodotto {
    private Integer id;
    private String nome;
    private String categoria;
    private Integer prezzo;

    public Prodotto(Integer id, String nome, String categoria, Integer prezzo) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public Prodotto(String nome, String categoria, Integer prezzo) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
    }

    public Prodotto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public Integer getPrezzo() {
        return prezzo;
    }
}
