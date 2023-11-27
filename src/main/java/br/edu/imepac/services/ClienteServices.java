/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.services;
import java.sql.SQLException;
import br.edu.imepac.dao.ClienteDAO;
import br.edu.imepac.entities.Cliente;
import java.util.ArrayList;

/**
 *
 * @author italo-santos-mendes
 */
public class ClienteServices{
    
    private final ClienteDAO ClienteDAO;

    public ClienteServices() {
        this.ClienteDAO = new ClienteDAO();
    }

    public int addCliente(Cliente cliente) throws SQLException {
        return this.ClienteDAO.save(cliente);
    }

    public Cliente searchCliente(long id) throws SQLException {
        return this.ClienteDAO.search(id);
    }

    public int deleteCliente(long id) throws SQLException {
        return this.ClienteDAO.delete(id);
    }

    public int updateCliente(Cliente cliente) throws SQLException {
        return this.ClienteDAO.update(cliente);
    }

    public ArrayList<Cliente> findAllCliente() throws SQLException {
        return this.ClienteDAO.findAll();
    }

    public int updateProntuario(long id, String prontuario) throws SQLException {
        return this.ClienteDAO.updateProntuario(id, prontuario);
    }

}
