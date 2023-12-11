/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author italo
 * @param <T>
 */
public interface IDatabaseCRUDMedico<T> {
    int delete(long id) throws SQLException;

    T search(long id) throws SQLException;

    void save(T entity) throws SQLException;

    int update(long id, Map<String, Object> atualizacoes) throws SQLException;

    ArrayList<T> findAll() throws SQLException;
    
    ArrayList<T> searchForEspc(long ID) throws SQLException;
}
