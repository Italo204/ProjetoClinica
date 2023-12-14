package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Convenio;
import services.ConvenioServices;

public class ConvenioController {
    private final ConvenioServices convenioServices;

    public ConvenioController() {
        this.convenioServices = new ConvenioServices();
    }

    public void addConvenio(Convenio convenio) {
        try {
            this.convenioServices.addConvenio(convenio);
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteConvenio(Convenio convenio) {
        try {
            this.convenioServices.deleteConvenio(convenio.getID());
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "EXCLUSÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchConvenio(Convenio convenio) {
        try{
            this.convenioServices.searchConvenio(convenio.getID());
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateConvenio(Convenio convenio) {
        try {
            this.convenioServices.updateConvenio(convenio);
            JOptionPane.showMessageDialog(null, "Atualizacão feita com sucesso!", "ATUALIZAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Convenio> findAllConvenio() {
        try {
            return this.convenioServices.findAllConvenios();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    
}
