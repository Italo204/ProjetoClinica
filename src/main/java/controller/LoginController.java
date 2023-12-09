package controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import utils.Database;

public class LoginController {
    public boolean autenticarUser(String CPF, String senha) {
        try {
            String sql = "SELECT CPF, SENHA FROM LOGIN WHERE CPF = ?";
            PreparedStatement ps = null;
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setString(1, CPF);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String senhaBanco = rs.getString("senha");
                if (senha == senhaBanco) {
                    return true;
                }
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "CPF OU SENHA INCORRETOS!" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
