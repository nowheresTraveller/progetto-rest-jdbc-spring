package com.example.demo.progettorestjdbcspring.db.dao.impl;

import com.example.demo.progettorestjdbcspring.db.dao.interfaces.GeneralDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.interfaces.ProdottoDaoInterface;
import com.example.demo.progettorestjdbcspring.db.dao.model.Prodotto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ProdottoDaoImpl implements GeneralDaoInterface<Prodotto>, ProdottoDaoInterface {
    private JdbcTemplate jdbcManager;

    private final RowMapper<Prodotto> prodottoMapper = (resultSet, rowNum) -> {
        return new Prodotto(
                resultSet.getInt("id"),
                resultSet.getString("nome"),
                resultSet.getString("categoria"),
                resultSet.getInt("prezzo")
        );

    };


    public ProdottoDaoImpl(DataSource ds) {
        this.jdbcManager = new JdbcTemplate(ds);
    }

    @Override
    public boolean insert(Prodotto object) {
        if (jdbcManager.update("insert into prodotto (nome,gategoria,prezzo) values (?,?,?);",
                object.getNome(), object.getCategoria(), object.getPrezzo()) > 0)
            return true;
        return false;
    }

    @Override
    public List<Prodotto> selectAll() {
        return jdbcManager.query("select * from prodotto",prodottoMapper);
    }

    @Override
    public Prodotto selectById(int id) {
        return jdbcManager.queryForObject("select * from prodotto where id =?",prodottoMapper,id);
    }

    @Override
    public boolean deleteById(int id) {
        if(jdbcManager.update("delete from prodotto where id = ?", id)>0)
            return true;
        return false;
    }

    @Override
    public boolean updateNomeById(String nome, Integer id) {
        if(jdbcManager.update("update prodotto set nome = ? where id = ? ", nome, id)>0)
            return true;
        return false;
    }

    @Override
    public List<Prodotto> selectByCategoria(String categoria) {
        return jdbcManager.query("select * from prodotto where categoria = ?",prodottoMapper,categoria);
    }

    @Override
    public boolean deleteByNome(String nome) {
        if(jdbcManager.update("delete from prodotto where nome = ?", nome)>0)
            return true;
        return false;
    }

    @Override
    public boolean updatePrezzoByNome(Integer prezzo, String nome) {
        if(jdbcManager.update("update prodotto set prezzo = ? where nome = ?", prezzo, nome)>0)
            return true;
        return false;
    }

    @Override
    public Prodotto selectByNome(String nome) {
        return jdbcManager.queryForObject("select * from prodotto where nome = ?",prodottoMapper,nome);
    }
}
