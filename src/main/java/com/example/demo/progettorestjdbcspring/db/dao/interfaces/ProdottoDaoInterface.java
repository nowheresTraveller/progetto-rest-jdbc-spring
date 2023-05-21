package com.example.demo.progettorestjdbcspring.db.dao.interfaces;


import com.example.demo.progettorestjdbcspring.db.dao.model.Prodotto;

import java.util.List;

public interface ProdottoDaoInterface {

    public List<Prodotto> selectByCategoria(String categoria);
    public boolean deleteByNome(String nome);
    public boolean updatePrezzoByNome(Integer prezzo, String nome);
    public Prodotto selectByNome(String nome);
    public boolean updateNomeById(String nome, Integer id);

}
