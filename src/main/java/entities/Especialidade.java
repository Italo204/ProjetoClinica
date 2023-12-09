package entities;

public class Especialidade {
    private long ID;
    String nome;
    
    public Especialidade(long iD, String nome) {
        ID = iD;
        this.nome = nome;
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
