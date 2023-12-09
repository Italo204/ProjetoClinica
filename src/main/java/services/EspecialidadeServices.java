package services;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.EspecialidadeDAO;
import entities.Especialidade;

public class EspecialidadeServices {

    private final EspecialidadeDAO especialidadeDAO;
    
    public EspecialidadeServices() {
        this.especialidadeDAO = new EspecialidadeDAO();
    } 

    public void addEspecialidade(Especialidade especialidade) throws SQLException {
        this.especialidadeDAO.save(especialidade);
    }

    public Especialidade searchEspecialidade(long id) throws SQLException {
        return this.especialidadeDAO.search(id);
    }

    public int deleteEspecialidade(long id) throws SQLException {
        return this.especialidadeDAO.delete(id);
    }

    public int updateEspecialidade(Especialidade especialidade) throws SQLException {
        return this.especialidadeDAO.update(especialidade);
    }

    public ArrayList<Especialidade> findAllEspecialidades() throws SQLException {
        return this.especialidadeDAO.findAll();
    }
}
