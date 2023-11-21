/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entities;
import java.time.LocalDate;

/**
 *
 * @author italo-santos-mendes
 */
public class Cliente {
    private long ID;
    private String nome;
    private String CPF;
    private String user;
    private String telefone;
    private LocalDate nascimento;
    

    public Cliente(String nome, String CPF, String user, String telefone, LocalDate Nascimento){
        this.nome = nome;
        this.CPF = CPF;
        this.user = user;
        this.telefone = telefone;
        this.nascimento = Nascimento;
    }

    public String getNome() {
        return nome;
    }
    public String getCPF(){
        return CPF;
    }

    public String getUser(){
        return user;
    }

    public String getTelefone(){
        return telefone;
    }

    public long getID() {
        return ID;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setNascimento(LocalDate Nascimento) {
        this.nascimento = Nascimento;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}

