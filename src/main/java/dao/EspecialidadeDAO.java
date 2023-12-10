package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Especialidade;
import interfaces.IDatabaseCRUD;
import java.sql.Connection;
import utils.Database;

public class EspecialidadeDAO implements IDatabaseCRUD<Especialidade> {

    @Override
    public void save(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO Especialidade(especialidade) VALUES (?)";
        PreparedStatement ps = null;

        try{
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, especialidade.getNome());
            ps.executeUpdate();
            ps.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public Especialidade search(Long id) throws SQLException {
        String sql = "SELECT * FROM ESPECIALIDADE WHERE IDEspecialidade = ?";
        PreparedStatement ps = null;

        try(Connection conn = Database.getConexao()){
            ps= Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Especialidade especialidade = null;
            if (result.next()){
                especialidade =  new Especialidade(result.getLong("IDEspecialidade"), result.getString("Especialidade"));
            }
            ps.close();
            result.close();
            return especialidade;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }



     @Override
    public int delete(Long id) throws SQLException{
        String sql = "DELETE FROM Especialidade WHERE IDEspecialidade = ?";
        PreparedStatement ps = null;
        try {
            ps= Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public int update(Especialidade especialidade) throws SQLException{
        String sql = "UPDATE Especialidade SET especialidade = ? WHERE IDEspecialidade = ?";
        PreparedStatement ps = null;
        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, especialidade.getNome());;
            ps.setLong(2, especialidade.getID());
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }

    }

    @Override
    public ArrayList<Especialidade> findAll() throws SQLException {
        String sql = "SELECT * FROM Especialidade";
        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            ArrayList<Especialidade> especialidade = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("IDEspecialidade");
                String nome = rs.getString("especialidade");
                Especialidade especialidades = new Especialidade(id, nome);
                especialidade.add(especialidades);
            }
            ps.close();
            rs.close();
            return especialidade;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }
}
