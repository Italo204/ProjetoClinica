/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import View.BaseForm;
import entities.Atendente;
import services.AtendenteServices;

/**
 *
 * @author italo-santos-mendes
 */
public class AtendenteController {

    private final AtendenteServices atendenteServices;
    private final BaseForm baseForm;

    public AtendenteController(BaseForm bForm){
        this.atendenteServices = new AtendenteServices();
        this.baseForm = bForm;
    }

    public void saveAtendente(Atendente atendente){
        try {
            this.atendenteServices.addAtendente(atendente);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void updateAtendente(Atendente atendente) {
        try {
            this.atendenteServices.updateAtendete(atendente);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }
    
    public void deleteAtendente(Atendente atendente) {
        try {
            this.atendenteServices.deleteAtendente(atendente.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void searchAtendente(Atendente atendente) {
        try {
            this.atendenteServices.searchAtendente(atendente.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public ArrayList<Atendente> findAllAtendente() {
        try {
            return this.atendenteServices.findAllAtendentes();
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }
}
