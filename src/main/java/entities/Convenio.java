package entities;

import java.time.LocalDate;


public class Convenio {
    private long ID;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private String CNPJ;

    public Convenio(Long ID, String nome, LocalDate dataInicio, LocalDate dataTermino, String CNPJ){
        this.ID = ID;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.CNPJ = CNPJ;
    }

    public Convenio(String nome, LocalDate dataInicio, LocalDate dataTermino, String CNPJ) {
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.CNPJ = CNPJ;
    }
    
    

    
    public void setID(long iD) {
        ID = iD;
    }


    public String getCNPJ() {
        return CNPJ;
    }


    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }


    public long getID(){
        return ID;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDataInicio(LocalDate dataInicio){
        this.dataInicio = dataInicio;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
