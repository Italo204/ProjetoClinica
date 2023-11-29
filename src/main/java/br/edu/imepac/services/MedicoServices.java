/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.services;



import java.sql.SQLException;

import br.edu.imepac.dao.MedicoDAO;
import br.edu.imepac.entities.Medico;
import java.util.ArrayList;



/**
 *
 * @author italo-santos-mendes
 */
public class MedicoServices {
    private final MedicoDAO MedicoDAO;

    public MedicoServices() {
        this.MedicoDAO = new MedicoDAO();
    }

    public int addMedico(Medico medico) throws SQLException {
        return this.MedicoDAO.save(medico);
    }

    public int deleteMedico(long id) throws SQLException {
        return this.MedicoDAO.delete(id);
    }

    public Medico searchMedico(long id) throws SQLException {
        return this.MedicoDAO.search(id);
    }

    public int updateMedico(Medico medico) throws SQLException {
        return this.MedicoDAO.update(medico);
    }

    public ArrayList<Medico> findAllMedicos() throws SQLException {
        return this.MedicoDAO.findAll();
    }

}