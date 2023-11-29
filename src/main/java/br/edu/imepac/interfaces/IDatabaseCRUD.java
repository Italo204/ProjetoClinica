package br.edu.imepac.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDatabaseCRUD<T> {

    int delete(Long id) throws SQLException;

    T search(Long id) throws SQLException;

    int save(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    ArrayList<T> findAll() throws SQLException;

}