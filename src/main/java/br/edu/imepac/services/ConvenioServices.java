package br.edu.imepac.services;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.imepac.dao.ConvenioDAO;
import br.edu.imepac.entities.Convenio;


public class ConvenioServices {
    private final ConvenioDAO ConvenioDAO;
    
    public ConvenioServices() {
        this.ConvenioDAO = new ConvenioDAO();
    } 

    public void addConvenio(Convenio convenio) throws SQLException {
        this.ConvenioDAO.save(convenio);
    }

    public Convenio searchConvenio(long id) throws SQLException {
        return this.ConvenioDAO.search(id);
    }

    public int deleteConvenio(long id) throws SQLException {
        return this.ConvenioDAO.delete(id);
    }

    public int updateConvenio(Convenio convenio) throws SQLException {
        return this.ConvenioDAO.update(convenio);
    }

    public ArrayList<Convenio> findAllConvenios() throws SQLException {
        return this.ConvenioDAO.findAll();
    }

}
