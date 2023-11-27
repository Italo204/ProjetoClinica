package br.edu.imepac.entities;

import java.time.LocalDate;

public class Agendamento {
    private long ID;
    private LocalDate Data;
    private String CPF;
    private String Observacao;
    private String tipoConsulta;
    private Medico medico;
    private Convenio convenio;
    private String nome;

    public Agendamento(long ID, LocalDate data, String CPF, String observacao, String tipoConsulta, Medico medico,
            Convenio convenio, String nome) {
        this.Data = data;
        this.CPF = CPF;
        this.Observacao = observacao;
        this.tipoConsulta = tipoConsulta;
        this.medico = medico;
        this.convenio = convenio;
        this.nome = nome;
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        this.ID = iD;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate data) {
        this.Data = data;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
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

    
    

    
}
