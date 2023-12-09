/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Paciente;
import services.PacienteServices;
import views.BaseForm;

/**
 *
 * @author italo-santos-mendes
 */
public class PacienteController {
    private final PacienteServices pacienteServices;
    private final BaseForm baseForm;

    public PacienteController(BaseForm bform) {
        this.pacienteServices = new PacienteServices();
        this.baseForm = bform;
    }

    public void savePaciente(Paciente paciente) {
        try{
            this.pacienteServices.addPaciente(paciente);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void deletePaciente(Paciente paciente) {
        try {
            this.pacienteServices.deletePaciente(paciente.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void updatePaciente(Paciente paciente) {
        try {
            this.pacienteServices.updatePaciente(paciente);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void searchPaciente(Paciente paciente) {
        try {
            this.pacienteServices.searchPaciente(paciente.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public ArrayList<Paciente> findAllPacientes() {
        try {
            return this.pacienteServices.findAllPaciente();
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }
}
