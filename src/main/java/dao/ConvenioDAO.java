package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import entities.Convenio;
import interfaces.IDatabaseCRUD;
import utils.Database;

public class ConvenioDAO implements IDatabaseCRUD<Convenio>{

    @Override
    public void save(Convenio convenio) throws SQLException {
        LocalDate dataInicio = convenio.getDataInicio();
        LocalDate dataTermnino = convenio.getDataTermino();
        String sql = "INSERT INTO CONVENIO(Nome, CNPJ, DataInicio, DataTermino) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try{
            Date dataInicioSQL = Date.valueOf(dataInicio);
            Date dataTerminoSQL = Date.valueOf(dataTermnino);

            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, convenio.getNome());
            ps.setString(2, convenio.getCNPJ());
            ps.setDate(3, dataInicioSQL);
            ps.setDate(4, dataTerminoSQL);
            ps.executeUpdate();
            ps.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public Convenio search(Long id) throws SQLException {
        String sql = "SELECT * FROM CONVENIO WHERE IDConvenio = ?";
        PreparedStatement ps = null;

        try{
            ps= Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Convenio convenio = null;
            if (result.next()){
                convenio =  new Convenio(result.getLong("IDConvenio"), result.getString("Nome"), result.getDate("DataInicio").toLocalDate(),result.getDate("DataTermino").toLocalDate(), result.getString("CNPJ"));
            }
            return convenio;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }



     @Override
    public int delete(Long id) throws SQLException{
        String sql = "DELETE FROM CONVENIO WHERE IDConvenio = ?";
        PreparedStatement ps = null;
        try {
            ps= Database.getConexao().prepareStatement(sql.toString());
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
    public int update(Convenio convenio) throws SQLException{
        String sql = "UPDATE CONVENIO SET Nome = ?, DataInicio = ?, DataTermino = ?, CNPJ = ? WHERE IDConvenio = ?";
        PreparedStatement ps = null;
        LocalDate dataInicio = convenio.getDataInicio();
        LocalDate dataTermnino = convenio.getDataTermino();
        try {
            Date dataInicioSQL = Date.valueOf(dataInicio);
            Date dataTerminoSQL = Date.valueOf(dataTermnino);
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, convenio.getNome());
            ps.setDate(2, dataInicioSQL);
            ps.setDate(3, dataTerminoSQL);
            ps.setLong(4, convenio.getID());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }

    }

    @Override
    public ArrayList<Convenio> findAll() throws SQLException {
        String sql = "SELECT * FROM CONVENIO";
        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            ArrayList<Convenio> convenio = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("IDConvenio");
                String nome = rs.getString("Nome");
                LocalDate dataInicio = rs.getDate("DataInicio").toLocalDate();
                LocalDate dataTermino = rs.getDate("DataTermino").toLocalDate();
                String cnpj = rs.getString("CNPJ");
                

                Convenio convenios = new Convenio(id, nome, dataInicio, dataTermino, cnpj);
                convenio.add(convenios);
            }
            return convenio;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }
    
}
