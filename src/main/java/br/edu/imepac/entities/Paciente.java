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

 
public class Paciente extends Pessoa{
    private LocalDate nascimento;

    public Paciente(long ID, String nome, String email, String senha, String CPF, String telefone, String sexo,
            LocalDate nascimento) {
        super(ID, nome, email, senha, CPF, telefone, sexo);
        this.nascimento = nascimento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString(){
        return this.nome;
    }

}

