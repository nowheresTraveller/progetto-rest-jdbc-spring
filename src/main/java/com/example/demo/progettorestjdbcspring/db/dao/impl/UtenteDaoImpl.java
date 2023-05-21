package com.example.demo.progettorestjdbcspring.db.dao.impl;

import com.example.demo.progettorestjdbcspring.db.dao.interfaces.GeneralDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.interfaces.UtenteDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.model.Utente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UtenteDaoImpl implements GeneralDaoInterface<Utente>, UtenteDaoInterface {
    private JdbcTemplate jdbcManager;

    private final RowMapper<Utente> utenteMapper = (resulSet, rowNumber) -> {
        return new Utente(
                resulSet.getInt("id"),
                resulSet.getString("nome"),
                resulSet.getString("cognome"),
                resulSet.getString("user"),
                resulSet.getString("password")
        );
    };

    public UtenteDaoImpl(DataSource ds) {
        this.jdbcManager = new JdbcTemplate(ds);
    }

    @Override
    public boolean insert(Utente object) {
        if (jdbcManager.update("insert into utente (nome,cognome,user,password) values (?,?,?,?);",
                object.getNome(), object.getCognome(), object.getUser(), object.getPassword()) > 0)
            return true;
        return false;
    }

    @Override
    public List<Utente> selectAll() {
        return jdbcManager.query("select * from utente", utenteMapper);
    }

    @Override
    public Utente selectById(int id) {
        Utente utente;
        try {
            utente = jdbcManager.queryForObject("select * from utente where id = ?", utenteMapper, id);
        } catch (Exception e) {
            System.out.println("SelectById=0 record!");
            return null;
        }
        return utente;
    }

    @Override
    public boolean deleteById(int id) {
        if (jdbcManager.update("delete from utente where id = ?", id) > 0)
            return true;
        return false;
    }

    @Override
    public boolean updatePasswordByUser(String password, String user) {
        if (jdbcManager.update("update utente values password = ? where user = ?", password, user) > 0)
            return true;
        return false;
    }

    @Override
    public boolean deleteByNome(String nome) {
        if (jdbcManager.update("delete from utente where nome = ?", nome) > 0)
            return true;
        return false;
    }

    @Override
    public Utente selectByUser(String user) {
        Utente utente;
        try {
            utente = jdbcManager.queryForObject("select * from utente where user = ?", utenteMapper, user);
        } catch (Exception e) {
            System.out.println("SelectByUser=0 record!");
            return null;
        }
        return utente;
    }

    @Override
    public List<Utente> selectByNome(String nome) {
        return jdbcManager.query("select * from utente where nome = ?", utenteMapper, nome);
    }

    @Override
    public boolean insertWithUserAndPass(String user, String pass) {
        if (jdbcManager.update("insert into utente (user,password) values (?,?);", user, pass) > 0)
            return true;
        return false;
    }
}
