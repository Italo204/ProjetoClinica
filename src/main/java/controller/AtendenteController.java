/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import entities.Atendente;
import services.AtendenteServices;

/**
 *
 * @author italo-santos-mendes
 */
public class AtendenteController {

    private final AtendenteServices atendenteServices;

    public AtendenteController(){
        this.atendenteServices = new AtendenteServices();
    }

    public void saveAtendente(Atendente atendente){
        try {
            this.atendenteServices.addAtendente(atendente);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateAtendente(long id, Map<String, Object> atualizacoes) {
        try {
            this.atendenteServices.updateAtendente(id, atualizacoes);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteAtendente(Atendente atendente) {
        try {
            this.atendenteServices.deleteAtendente(atendente.getID());
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchAtendente(Atendente atendente) {
        try {
            this.atendenteServices.searchAtendente(atendente.getID());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Atendente> findAllAtendente() {
        try {
            return this.atendenteServices.findAllAtendentes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
