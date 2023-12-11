/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.AtendenteDAO;
import entities.Atendente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author italo-santos-mendes
 */

public class AtendenteServices {
    
    private final AtendenteDAO AtendenteDAO;

    public AtendenteServices() {
        this.AtendenteDAO = new AtendenteDAO();
    }

    public void addAtendente(Atendente atendente) throws SQLException {
        this.AtendenteDAO.save(atendente);
    }

    public Atendente searchAtendente(long id) throws SQLException {
        return this.AtendenteDAO.search(id);
    }

    public int deleteAtendente(long id) throws SQLException {
        return this.AtendenteDAO.delete(id);
    }

    public int updateAtendente(long id, Map<String, Object> atualizacoes) throws SQLException {
        return this.AtendenteDAO.update(id, atualizacoes);
    }

    public ArrayList<Atendente> findAllAtendentes() throws SQLException {
        return this.AtendenteDAO.findAll();
    }
}
