/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entities;

/**
 *
 * @author italo-santos-mendes
 */
public class Atendente {
    private String user;
    private String senha;
    private long ID;
    private String nome;
    private String telefone;


    //Construtor
    public Atendente(String nome, String senha, String user, long ID, String telefone){
        this.nome = nome;
        this.ID = ID;
        this.senha = senha;
        this.user = user;
        this.telefone = telefone;
    }


    //Metodo Getter
    public String getNome(){
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getUser(){
        return user;
    }

    public long getID(){
        return ID;
    }

    public String getSenha(){
        return senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public void setUser(String user){
        this.user = user;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return this.nome;
    } 
    
}



