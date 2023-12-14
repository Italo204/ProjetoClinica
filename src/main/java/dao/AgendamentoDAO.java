package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import entities.Agendamento;
import entities.Convenio;
import entities.Especialidade;
import entities.Medico;
import entities.Paciente;
import interfaces.IDatabaseCRUD;
import utils.Database;
import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoDAO implements IDatabaseCRUD<Agendamento>{
    @Override
    public void save(Agendamento agendamento) throws SQLException {
    LocalDate dataAgendamento = agendamento.getData();
    LocalTime horaAgendamento = agendamento.getHora();
    String sql = "INSERT INTO agendamento(DIA, OBSERVACOES, TIPOCONSULTA, IDMEDICO, IDCONVENIO, HORA, ESPECIALIDADE, IDPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement ps = null;

    Date data = Date.valueOf(dataAgendamento);
    Time hora = Time.valueOf(horaAgendamento);

    try {
        ps = Database.getConexao().prepareStatement(sql);
        ps.setDate(1, data);
        ps.setString(2, agendamento.getObservacao());
        ps.setString(3, agendamento.getTipoConsulta());
        ps.setLong(4, agendamento.getMedico().getID());

        if (agendamento.getConvenio() != null) {
            ps.setLong(5, agendamento.getConvenio().getID());
        } else {
            ps.setNull(5, java.sql.Types.INTEGER);
        }

        ps.setTime(6, hora);
        ps.setString(7, agendamento.getEspecialidade().getNome());
        ps.setLong(8, agendamento.getPaciente().getID());

        ps.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    } finally {
        if (ps != null) {
            ps.close();
        }
        Database.closeConnection();
    }
}


    @Override
    public Agendamento search(Long id) throws SQLException {
        String sql = "SELECT A.IDAgendamento, A.Dia, P.CPF, A.observacoes, A.TipoConsulta, " +
        "M.Nome AS NomeMedico, C.Nome AS NomeConvenio, P.Nome AS NomePaciente, A.hora, A.especialidade " +
        "FROM Agendamento A "+
        "JOIN PACIENTE P ON A.IDPaciente = P.IDPaciente "+
        "LEFT JOIN Medico M ON A.IDMedico = M.IDMedico "+
        "LEFT JOIN Convenio C ON A.IDConvenio = C.IDConvenio "+
        "WHERE A.IDAgendamento = ? ;";
        PreparedStatement ps = null;

        try{
            ps= Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            ResultSet result = ps.executeQuery();
            Agendamento agendamento = null;
            if (result.next()){
                Especialidade especialidade = (Especialidade) result.getObject("especialidade");
                Medico medico = (Medico) result.getObject("NomeMedico");
                Convenio convenio = (Convenio) result.getObject("NomeConvenio");
                Paciente paciente = (Paciente) result.getObject("IDPaciente");
                agendamento =  new Agendamento(result.getLong("IDAgendamento"), result.getDate("Dia").toLocalDate(), paciente, 
                result.getString("observacoes"), result.getString("TipoConsulta"), medico, 
                convenio, result.getString("Nome"), result.getTime("hora").toLocalTime(), especialidade);
            }
            ps.close();
            result.close();
            return agendamento;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }
    
    @Override
    public int delete(Long id) throws SQLException{
        String sql = "DELETE FROM agendamento WHERE IDAgendamento = ? ;";
        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setLong(1, id);
            int result = ps.executeUpdate();
            ps.close();
            return result;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            Database.closeConnection();
        }

    }

    @Override
    public int update(Agendamento agendamento) throws SQLException{
        String sql = "UPDATE agendamento SET Dia = ?, hora = ?, TipoConsulta = ? WHERE IDAgendamento = ?;";
        PreparedStatement ps = null;
        LocalDate DiaAgen = agendamento.getData();
        LocalTime horaAgen = agendamento.getHora();

        try {
            Date Dia = Date.valueOf(DiaAgen);
            Time hora = Time.valueOf(horaAgen);
            ps = Database.getConexao().prepareStatement(sql.toString());
            ps.setDate(1, Dia);
            ps.setTime(2, hora);
            ps.setString(3, agendamento.getTipoConsulta());
            ps.setLong(4, agendamento.getID());
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
    public ArrayList<Agendamento> findAll() throws SQLException {
        String sql = "SELECT A.IDAgendamento, A.Dia, P.CPF, A.observacoes, A.TipoConsulta, " +
        "M.Nome AS NomeMedico, C.Nome AS NomeConvenio, P.Nome AS NomePaciente, A.hora, A.especialidade " +
        "FROM Agendamento A "+
        "JOIN PACIENTE P ON A.IDPaciente = P.IDPaciente "+
        "LEFT JOIN Medico M ON A.IDMedico = M.IDMedico "+
        "LEFT JOIN Convenio C ON A.IDConvenio = C.IDConvenio ;";

        PreparedStatement ps = null;

        try {
            ps = Database.getConexao().prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            ArrayList<Agendamento> agendamento = new ArrayList<>();
            while (rs.next()) {
                long id = rs.getLong("id");
                LocalDate dia = rs.getDate("Dia").toLocalDate();
                Paciente paciente = (Paciente) rs.getObject("Paciente");
                String observacao = rs.getString("observacoes");
                String TipoConsulta = rs.getString("TipoCosnulta");
                Medico medico = (Medico) rs.getObject("NomeMedico");
                Convenio convenio = (Convenio) rs.getObject("NomeConvenio");
                String nome = rs.getString("Nome");
                LocalTime hora = rs.getTime("hora").toLocalTime();
                Especialidade especialidade = (Especialidade) rs.getObject("especialidade");

                Agendamento agendamentos = new Agendamento(id, dia, paciente, observacao, TipoConsulta, medico, convenio, nome, hora, especialidade);
                agendamento.add(agendamentos);
            }
            ps.close();
            rs.close();
            return agendamento;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } finally {
            Database.closeConnection();
        }
    }

    public boolean checkUser(String CPF) throws SQLException {
        String sql = "SELECT * FROM PACIENTE WHERE CPF = ?";
        try(PreparedStatement ps = Database.getConexao().prepareStatement(sql.toString());){
            
            ps.setString(1, CPF);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Paciente não encontrado. Realizar Cadastro! ", "Erro", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            Database.closeConnection();
        }
    }
}
