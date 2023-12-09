package entities;

public class Prontuario {
    private long id;
    private String nomePaciente;
    private String Historico;
    private String Exames;
    private String Receituario;
    
    public Prontuario(long id, String historico, String receituario, String exames, String nomePaciente) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.Historico = historico;
        this.Exames = exames;
        this.Receituario = receituario;
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
        this.Historico = historico;
    }

    public String getExames() {
        return Exames;
    }

    public void setExames(String exames) {
        this.Exames = exames;
    }

    public String getReceituario() {
        return Receituario;
    }

    public void setReceituario(String receituario) {
        this.Receituario = receituario;
    }
    
    
    
}
