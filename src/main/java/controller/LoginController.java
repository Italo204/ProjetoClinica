package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.mindrot.jbcrypt.BCrypt;

import utils.Database;

public class LoginController {

    public boolean autenticarUser(String CPF, String senha) {
        try {
            String sql = "SELECT CPF, SENHA, CARGO FROM LOGIN WHERE CPF = ?";
            PreparedStatement ps = null;
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String senhaBanco = rs.getString("senha");
                if (BCrypt.checkpw(senha, senhaBanco)) {
                    return true;
                }
            }
            ps.close();
            rs.close();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "CPF OU SENHA INCORRETOS!", "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            Database.closeConnection();
        }
        return false;
    }
}
