package com.example.demo.progettorestjdbcspring.db.dao.interfaces;

import java.util.List;

public interface GeneralDaoInterface <T>{

    public boolean insert(T object);

    public List<T> selectAll();

    public T selectById(int id);

    public boolean deleteById(int id);

}
