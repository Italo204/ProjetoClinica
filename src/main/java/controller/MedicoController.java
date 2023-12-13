/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import services.MedicoServices;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import entities.Medico;
/**
 *
 * @author italo-santos-mendes
 */
public class MedicoController {
    private final MedicoServices medicoServices;

    public MedicoController(){
        this.medicoServices = new MedicoServices();
    }
    
    public void saveMedico(Medico medico) {
        try{
            this.medicoServices.addMedico(medico);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMedico(long id, Map<String, Object> atualizacoes){
        try {
            this.medicoServices.updateMedico(id, atualizacoes);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteMedico(Medico medico) {
        try {
            this.medicoServices.deleteMedico(medico.getID());
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchMedico(Medico medico) {
        try {
            this.medicoServices.searchMedico(medico.getID());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Medico> findAllMedicos() {
        try{
            return this.medicoServices.findAllMedicos();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public ArrayList<Medico> searchForEspc(long id) {
        try {
            return this.medicoServices.searchForEspc(id);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void updateForEspc(long id, long idmed) {
        try {
            this.medicoServices.updateForEspc(id, idmed);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
