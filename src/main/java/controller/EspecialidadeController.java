package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import View.BaseForm;
import entities.Especialidade;
import services.EspecialidadeServices;

public class EspecialidadeController {
    private final EspecialidadeServices especialidadeServices;
    private final BaseForm baseForm;

    public EspecialidadeController(BaseForm bform) {
        this.especialidadeServices = new EspecialidadeServices();
        this.baseForm = bform;
    }

    public void addEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.addEspecialidade(especialidade);
        }catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void deleteEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.deleteEspecialidade(especialidade.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void searchEspecialidade(Especialidade especialidade) {
        try{
            this.especialidadeServices.searchEspecialidade(especialidade.getID());
        } catch(SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void updateEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.updateEspecialidade(especialidade);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public ArrayList<Especialidade> findAllEspecialidade() {
        try {
            return this.especialidadeServices.findAllEspecialidades();
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }
}
