package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import entities.Prontuario;
import interfaces.IProntuarioCRUD;
import utils.Database;

public class ProntuarioDAO implements IProntuarioCRUD<Prontuario> {
    
    @Override
    public void saveProntuario(Prontuario prontuario) throws SQLException {
        String sql =  "INSERT INTO PRONTUARIO(Historico, Receituario, Exames, NomePaciente) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, prontuario.getHistorico());
            ps.setString(2, prontuario.getReceituario());
            ps.setString(3, prontuario.getExames());
            ps.setString(4, prontuario.getNomePaciente());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public Prontuario searchProntuario(long id) throws SQLException {
        String sql = "Select * from prontuario where id = ?";
        PreparedStatement ps = null;

        try {
            ps =  Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            Prontuario prontuario = null;
            if(rs.next()){
                prontuario = new Prontuario(rs.getLong("IDProntuario"), rs.getString("Historico"), rs.getString("Receituario"), 
                rs.getString("Exames"), rs.getString("NomePaciente"));
            }
            return prontuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public int deleteProntuario(long id) throws SQLException {
        String sql = "DELETE FROM PRONTUARIO WHERE ID = ?";
        PreparedStatement ps =  null;

        try {
            ps =  Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public int updateProntuario(Prontuario prontuario) throws SQLException {
        String sql = "UPDATE PRONTUARIO SET HISTORICO = ?, RECEITUARIO = ?, EXAMES = ? WHERE ID = ?";
        PreparedStatement ps = null;

        try {
            ps =  Database.getConexao().prepareStatement(sql.toString());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
