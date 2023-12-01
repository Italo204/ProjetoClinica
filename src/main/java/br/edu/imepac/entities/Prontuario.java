package br.edu.imepac.entities;

public class Prontuario {
    private long id;
    private String nomePaciente;
    private String Historico;
    private String Exames;
    private String Receituario;
    
    public Prontuario(long id, String nomePaciente, String historico, String exames, String receituario) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        Historico = historico;
        Exames = exames;
        Receituario = receituario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getHistorico() {
        return Historico;
    }

    public void setHistorico(String historico) {
        Historico = historico;
    }

    public String getExames() {
        return Exames;
    }

    public void setExames(String exames) {
        Exames = exames;
    }

    public String getReceituario() {
        return Receituario;
    }

    public void setReceituario(String receituario) {
        Receituario = receituario;
    }
    
    
    
}
