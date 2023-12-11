/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import services.MedicoServices;
import View.BaseForm;

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
    private final BaseForm baseForm;

    public MedicoController(BaseForm bForm){
        this.medicoServices = new MedicoServices();
        this.baseForm = bForm;
    }
    
    public void saveMedico(Medico medico) {
        try{
            this.medicoServices.addMedico(medico);
        } catch(SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void updateMedico(long id, Map<String, Object> atualizacoes){
        try {
            this.medicoServices.updateMedico(id, atualizacoes);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void deleteMedico(Medico medico) {
        try {
            this.medicoServices.deleteMedico(medico.getID());
        } catch(SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void searchMedico(Medico medico) {
        try {
            this.medicoServices.searchMedico(medico.getID());
        } catch (SQLException e){
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public ArrayList<Medico> findAllMedicos() {
        try{
            return this.medicoServices.findAllMedicos();
        } catch(SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Medico> searchForEspc(Medico medico) {
        try {
            return this.medicoServices.searchForEspc(medico.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }
}
