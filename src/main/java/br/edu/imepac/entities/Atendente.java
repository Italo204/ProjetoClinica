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
    private int ID;
    private String nome;


    //Construtor
    public Atendente(String nome){
    this.nome = nome;
    }

    //Metodo Getter
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    private void AgendarConsulta()
    
}



