package com.example.demo.progettorestjdbcspring.db.dao.interfaces;

import com.example.demo.progettorestjdbcspring.db.dao.model.Utente;

import java.util.List;

public interface UtenteDaoInterface {
    public boolean updatePasswordByUser(String password, String user);
    public boolean deleteByNome(String nome);
    public Utente selectByUser(String user);
    public List<Utente> selectByNome(String nome);

    public boolean insertWithUserAndPass(String user,String pass);
}
