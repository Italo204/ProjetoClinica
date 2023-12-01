/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.services;

import br.edu.imepac.dao.AtendenteDAO;
import br.edu.imepac.entities.Atendente;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public int updateAtendete(Atendente atendente) throws SQLException {
        return this.AtendenteDAO.update(atendente);
    }

    public ArrayList<Atendente> findAllAtendentes() throws SQLException {
        return this.AtendenteDAO.findAll();
    }
}
