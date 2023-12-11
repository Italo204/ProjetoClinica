/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;



import java.sql.SQLException;

import dao.MedicoDAO;
import entities.Medico;
import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author italo-santos-mendes
 */
public class MedicoServices {
    private final MedicoDAO MedicoDAO;

    public MedicoServices() {
        this.MedicoDAO = new MedicoDAO();
    }

    public void addMedico(Medico medico) throws SQLException {
        this.MedicoDAO.save(medico);
    }

    public int deleteMedico(long id) throws SQLException {
        return this.MedicoDAO.delete(id);
    }

    public Medico searchMedico(long id) throws SQLException {
        return this.MedicoDAO.search(id);
    }

    public int updateMedico(long id, Map<String, Object> atualizacoes) throws SQLException {
        return this.MedicoDAO.update(id, atualizacoes);
    }

    public ArrayList<Medico> findAllMedicos() throws SQLException {
        return this.MedicoDAO.findAll();
    }
    
    public ArrayList<Medico> searchForEspc(long ID) throws SQLException {
        return this.MedicoDAO.searchForEspc(ID);
    }

}