package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Especialidade;
import services.EspecialidadeServices;


public class EspecialidadeController {
    private final EspecialidadeServices especialidadeServices;

    public EspecialidadeController() {
        this.especialidadeServices = new EspecialidadeServices();
    }

    public void addEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.addEspecialidade(especialidade);
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "CADASTRO", JOptionPane.INFORMATION_MESSAGE);
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.deleteEspecialidade(especialidade.getID());
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!", "EXCLUSÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void searchEspecialidade(Especialidade especialidade) {
        try{
            this.especialidadeServices.searchEspecialidade(especialidade.getID());
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateEspecialidade(Especialidade especialidade) {
        try {
            this.especialidadeServices.updateEspecialidade(especialidade);
            JOptionPane.showMessageDialog(null, "Atualizacão feita com sucesso!", "ATUALIZAÇÃO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ArrayList<Especialidade> findAllEspecialidade() {
        try {
            return this.especialidadeServices.findAllEspecialidades();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
