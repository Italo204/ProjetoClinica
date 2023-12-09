package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Convenio;
import services.ConvenioServices;
import views.BaseForm;

public class ConvenioController {
    private final ConvenioServices convenioServices;
    private final BaseForm baseForm;

    public ConvenioController(BaseForm bform) {
        this.convenioServices = new ConvenioServices();
        this.baseForm = bform;
    }

    public void addConvenio(Convenio convenio) {
        try {
            this.convenioServices.addConvenio(convenio);
        }catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void deleteConvenio(Convenio convenio) {
        try {
            this.convenioServices.deleteConvenio(convenio.getID());
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void searchConvenio(Convenio convenio) {
        try{
            this.convenioServices.searchConvenio(convenio.getID());
        } catch(SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public void updateConvenio(Convenio convenio) {
        try {
            this.convenioServices.updateConvenio(convenio);
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
        }
    }

    public ArrayList<Convenio> findAllConvenio() {
        try {
            return this.convenioServices.findAllConvenios();
        } catch (SQLException e) {
            baseForm.showErrorInternal(e.getMessage());
            return null;
        }
    }

    
}
