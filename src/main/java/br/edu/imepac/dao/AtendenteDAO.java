/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.dao;

import br.edu.imepac.interfaces.IDatabaseCRUD;

import static javax.swing.JOptionPane.showInternalInputDialog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.edu.imepac.views.BaseForm;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import br.edu.imepac.entities.Atendente;
import br.edu.imepac.utils.Database;



/**
 *
 * @author italo-santos-mendes
 */

public class AtendenteDAO extends BaseForm implements IDatabaseCRUD<Atendente>{
    
    public void save(Atendente atendente) throws SQLException {
        String sql = "INSERT INTO ATENDENTE(NOME, EMAIL, SENHA, CPF, TELEFONE, SEXO) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;

        try{
            ps = Database.getConexao().prepareStatement(sql);
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getEmail());
            ps.setString(3, atendente.getSenha());
            ps.setString(4, atendente.getCPF());
            ps.setString(5, atendente.getTelefone());
            ps.setString(6, atendente.getSexo());

            ps.executeUpdate();
            ps.close();

        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
    }

    public Atendente search(Long id) throws SQLException {
        String sql = "SELECT * FROM ATENDENTE WHERE ID = ?";
        PreparedStatement ps = null;

        try{
            ps= Database.getConexao().prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Atendente atendente = null;
            if (result.next()){
                atendente =  new Atendente(result.getLong("id"), result.getString("nome"), result.getString("email"),result.getString("senha"),
                result.getString("cpf"), result.getString("telefone"), result.getString("sexo"));
            }
            return atendente;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }

    public int update(Atendente atendente) throws SQLException {
        String sql = 
        try {
            
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

}
