/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.SQLException;
import dao.PacienteDAO;
import entities.Paciente;
import java.util.ArrayList;

/**
 *
 * @author italo-santos-mendes
 */
public class PacienteServices{
    
    private final PacienteDAO PacienteDAO;

    public PacienteServices() {
        this.PacienteDAO = new PacienteDAO();
    }

    public void addCliente(Paciente paciente) throws SQLException {
        this.PacienteDAO.save(paciente);
    }

    public Paciente searchCliente(long id) throws SQLException {
        return this.PacienteDAO.search(id);
    }

    public int deleteCliente(long id) throws SQLException {
        return this.PacienteDAO.delete(id);
    }

    public int updateCliente(Paciente cliente) throws SQLException {
        return this.PacienteDAO.update(cliente);
    }

    public ArrayList<Paciente> findAllCliente() throws SQLException {
        return this.PacienteDAO.findAll();
    }

}
