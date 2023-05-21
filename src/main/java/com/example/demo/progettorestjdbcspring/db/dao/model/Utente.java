package com.example.demo.progettorestjdbcspring.db.dao.model;

public class Utente {
    private Integer id;
    private String nome;
    private String cognome;
    private String user;
    private String password;

    public Utente() {
    }

    public Utente(Integer id, String nome, String cognome, String user, String password) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.user = user;
        this.password = password;
    }

    public Utente(String nome, String cognome, String user, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.user = user;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

