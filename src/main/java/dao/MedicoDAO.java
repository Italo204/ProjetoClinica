/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import entities.Medico;
import interfaces.IDatabaseCRUDMedico;
import utils.Database;

/**
 *
 * @author italo-santos-mendes
 */
public class MedicoDAO implements IDatabaseCRUDMedico<Medico>{
    

    @Override
    public void save(Medico medico) throws SQLException {
        LocalDate dataNas = medico.getNascimento();
        
        String sql = "INSERT INTO MEDICO(NOME, EMAIL, SENHA, CPF, TELEFONE, SEXO, NASCIMENTO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
       
        Date nascimento = Date.valueOf(dataNas);

        try{
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getEmail());
            ps.setString(3, medico.getSenha());
            ps.setString(4, medico.getCPF());
            ps.setString(5, medico.getTelefone());
            ps.setString(6, medico.getSexo());
            ps.setDate(7, nascimento);

            ps.executeUpdate();
            ps.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
    }

    @Override
    public Medico search(long id) throws SQLException {
        
        String sql = "SELECT IDMedico, Telefone, CPF, Sexo, Email, Nome, Senha, Nascimento FROM medico WHERE IDMedico = ?";
        PreparedStatement ps = null;

        try{
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Medico medico = null;
            if (result.next()){
                medico =  new Medico(result.getLong("IDMedico"), result.getString("Telefone"), result.getString("CPF"),result.getString("Sexo"),
                result.getString("Email"), result.getString("Nome"), result.getString("Senha"), result.getDate("Nascimento").toLocalDate());
            }
            ps.close();
            result.close();
            return medico;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }
    
    @Override
    public int delete(long id) throws SQLException{
        String sql = "DELETE FROM medico WHERE IDMedico = ?";
        PreparedStatement ps = null;
        try{
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }
        
    }

    @Override
    public int update(long id, Map<String, Object> atualizacoes) throws SQLException{

        if (atualizacoes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NENHUMA ATUALIZAÇÂO PENDENTE!", "ERRO", JOptionPane.ERROR_MESSAGE);
            return 0;
        } 
        
        PreparedStatement ps = null;

        StringBuilder sql = new StringBuilder("UPDATE medico SET ");
        for(String campo : atualizacoes.keySet()) {
            sql.append(campo).append("=?, ");
        }  
        sql.delete(sql.length() - 2, sql.length());
        sql.append("WHERE IDMedico = ?");

        ps = Database.getConexao().prepareStatement(sql.toString());

        try {
            int index = 1;
            for (Object valor : atualizacoes.values()) {
                ps.setObject(index++, valor);
            }
            ps.setLong(index, id);

            int result = ps.executeUpdate();
            ps.close();

            return result;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

            return -1;
        } finally {
            Database.closeConnection();
        }

    }

    @Override
    public ArrayList<Medico> findAll() throws SQLException {
        String sql = "SELECT IDMedico, Telefone, CPF, Sexo, Email, Nome, Senha, Nascimento FROM medico ";
        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            ArrayList<Medico> medico = new ArrayList<>();
            while(rs.next()){
                long id = rs.getLong("IDMedico");
                String telefone = rs.getString("Telefone");
                String cpf = rs.getString("CPF");
                String sexo = rs.getString("sexo");
                String email = rs.getString("Email");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                LocalDate nascimento = rs.getDate("Nascimento").toLocalDate();

                Medico medicos = new Medico(id, nome, email, senha, cpf, telefone, sexo, nascimento);
                medico.add(medicos);
            }
            ps.close();
            rs.close();
            return medico;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
           
        
    }
    
    @Override
    public ArrayList<Medico> searchForEspc(long ID) throws SQLException {
        String sql = "SELECT IDMedico, Telefone, CPF, Sexo, Email, Nome, Senha, Nascimento FROM medico WHERE IDEspecialidade = ?";
        
        PreparedStatement ps = null;
        
        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1,ID);
            ResultSet rs = ps.executeQuery();
            ArrayList<Medico> medico = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("IDMedico");
                String telefone = rs.getString("Telefone");
                String cpf = rs.getString("CPF");
                String sexo = rs.getString("sexo");
                String email = rs.getString("Email");
                String nome = rs.getString("Nome");
                String senha = rs.getString("Senha");
                LocalDate nascimento = rs.getDate("Nascimento").toLocalDate();

                Medico medicos = new Medico(id, nome, email, senha,cpf, telefone, sexo, nascimento);
                medico.add(medicos);
            }
            ps.close();
            rs.close();
            return medico;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }

}
 