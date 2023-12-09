package services;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConvenioDAO;
import entities.Convenio;


public class ConvenioServices {
    private final ConvenioDAO convenioDAO;
    
    public ConvenioServices() {
        this.convenioDAO = new ConvenioDAO();
    } 

    public void addConvenio(Convenio convenio) throws SQLException {
        this.convenioDAO.save(convenio);
    }

    public Convenio searchConvenio(long id) throws SQLException {
        return this.convenioDAO.search(id);
    }

    public int deleteConvenio(long id) throws SQLException {
        return this.convenioDAO.delete(id);
    }

    public int updateConvenio(Convenio convenio) throws SQLException {
        return this.convenioDAO.update(convenio);
    }

    public ArrayList<Convenio> findAllConvenios() throws SQLException {
        return this.convenioDAO.findAll();
    }

}
