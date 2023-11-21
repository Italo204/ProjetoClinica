/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entities;

/**
 *
 * @author italo-santos-mendes
 */
public class Medico {
    private long ID;
    private String nome;
    private String especialidade;
    private String user;
    private String senha;
    private String telefone;

    public Medico(long ID, String nome, String especialidade, String user, String senha, String telefone){
        this.ID = ID;
        this.nome = nome;
        this.especialidade = especialidade;
        this.user = user;
        this.senha = senha;
        this.telefone = telefone;
    }

    public long getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getUser() {
        return user;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
