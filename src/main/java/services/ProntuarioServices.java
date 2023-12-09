package services;
import entities.Prontuario;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProntuarioDAO;

public class ProntuarioServices {
    private final ProntuarioDAO ProntuarioDAO;

    public ProntuarioServices() {
        this.ProntuarioDAO = new ProntuarioDAO();
    }

    public void addProntuario(Prontuario prontuario) throws SQLException{
        this.ProntuarioDAO.saveProntuario(prontuario);
    }

    public Prontuario searchProntuario(long id) throws SQLException {
        return this.ProntuarioDAO.searchProntuario(id);
    }

    public int deleteProntuario(long id) throws SQLException {
        return this.ProntuarioDAO.deleteProntuario(id);
    }

    public int updateProntuario(Prontuario Prontuario) throws SQLException {
        return this.ProntuarioDAO.updateProntuario(Prontuario);
    }

    public ArrayList<Prontuario> findAllProntuarios() throws SQLException {
        return this.ProntuarioDAO.findAllProntuario();
    }
}
