package br.edu.imepac.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String url = "jdbc:mysql://localhost:3306/clinica";
    private static final String user = "clinica";
    private static final String password = "12345";

    private static Connection con;

    public static Connection getConexao(){
        try{
            if(con == null){
                con = DriverManager.getConnection(url, user, password);
                return con;
            }else {
                return con;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void closeConnection() {
        try{
            if(con != null && !con.isClosed()) {
                con.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
