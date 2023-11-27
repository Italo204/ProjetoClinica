/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entities;

/**
 *
 * @author italo-santos-mendes
 */
public class Atendente extends Pessoa{

    public Atendente (long ID, String nome, String email, String senha, String CPF, String telefone, String sexo) {
        super(ID, nome, email, senha, CPF, telefone, sexo);
    }
    

    @Override
    public String toString(){
        return this.nome;
    } 
    
}



