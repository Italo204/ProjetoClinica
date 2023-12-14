package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {
    private long ID;
    private LocalDate Data;
    private LocalTime hora;
    private Paciente CPF;
    private String Observacao;
    private String tipoConsulta;
    private Medico medico;
    private Convenio convenio;
    private String nome;
    private Especialidade especialidade;

    public Agendamento(long ID, LocalDate data, Paciente CPF, String observacao, String tipoConsulta, Medico medico,
            Convenio convenio, String nome, LocalTime hora, Especialidade especialidade) {
        this.Data = data;
        this.CPF = CPF;
        this.Observacao = observacao;
        this.tipoConsulta = tipoConsulta;
        this.medico = medico;
        this.convenio = convenio;
        this.nome = nome;
        this.ID = ID;
        this.hora = hora;
        this.especialidade = especialidade;
    }

    

    public Agendamento(LocalDate data, LocalTime hora, Paciente CPF, String observacao, String tipoConsulta,
            Medico medico, Convenio convenio, String nome, Especialidade especialidade) {
        this.Data = data;
        this.hora = hora;
        this.CPF = CPF;
        this.Observacao = observacao;
        this.tipoConsulta = tipoConsulta;
        this.medico = medico;
        this.convenio = convenio;
        this.nome = nome;
        this.especialidade = especialidade;
    }



    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        this.ID = iD;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        this.Data = data;
    }

    public Paciente getPaciente() {
        return CPF;
    }

    public void setPaciente(Paciente cPF) {
        this.CPF = cPF;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        this.Observacao = observacao;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    

    
}
