package br.edu.imepac.entities;

public class Prontuario {
    private long id;
    private String nomePaciente;
    private String descricao;
    private String caminhoArquivo;
    
    public Prontuario(long id, String nomePaciente, String descricao, String caminhoArquivo) {
        this.id = id;
        this.nomePaciente = nomePaciente;
        this.descricao = descricao;
        this.caminhoArquivo = caminhoArquivo;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    
}
