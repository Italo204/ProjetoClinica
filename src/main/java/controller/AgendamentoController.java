package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Agendamento;
import services.AgendamentoServices;

public class AgendamentoController {
    private final AgendamentoServices agendamentoServices;

    public AgendamentoController() {
        this.agendamentoServices = new AgendamentoServices();
    }

    public void saveAgendamento(Agendamento agendamento) {
        try {
            this.agendamentoServices.addAgendamento(agendamento);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateAgendamento(Agendamento agendamento) {
        try {
            this.agendamentoServices.updateAgendamento(agendamento);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchAgendamento(Agendamento agendamento) {
        try {
            this.agendamentoServices.searchAgendamento(agendamento.getID());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteAgendamento(Agendamento agendamento) {
        try {
            this.agendamentoServices.deleteAgendamento(agendamento.getID());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Agendamento> findAllAgendamentos() {
        try {
            return this.agendamentoServices.findAllAgendamentos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    } 

    public boolean checkUser(String CPF) {
        try {
            return this.agendamentoServices.checkUser(CPF);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
