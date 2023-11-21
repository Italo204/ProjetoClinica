package br.edu.imepac.entities;

import java.time.LocalDate;


public class Convenio {
    public long ID;
    public String nome;
    public LocalDate dataInicio;
    public LocalDate dataTermino;
    public String detalhes;

    public Convenio(long ID, String nome, LocalDate dataInicio, LocalDate dataTermino, String detalhes){
        this.ID = ID;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.detalhes = detalhes;
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

    public String getDetalhes() {
        return detalhes;
    }

    public void setID(long ID){
        this.ID = ID;
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

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
