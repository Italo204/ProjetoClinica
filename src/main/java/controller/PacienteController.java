/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import entities.Paciente;
import services.PacienteServices;


/**
 *
 * @author italo-santos-mendes
 */
public class PacienteController {
    private final PacienteServices pacienteServices;

    public PacienteController() {
        this.pacienteServices = new PacienteServices();
    }

    public void savePaciente(Paciente paciente) {
        try{
            this.pacienteServices.addPaciente(paciente);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePaciente(Paciente paciente) {
        try {
            this.pacienteServices.deletePaciente(paciente.getID());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePaciente(long id, Map<String, Object> atualizacoes) {
        try {
            this.pacienteServices.updatePaciente(id, atualizacoes);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchPaciente(Paciente paciente) {
        try {
            this.pacienteServices.searchPaciente(paciente.getID());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Paciente> findAllPacientes() {
        try {
            return this.pacienteServices.findAllPaciente();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
