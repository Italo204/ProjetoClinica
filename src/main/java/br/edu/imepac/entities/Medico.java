/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.entities;

/**
 *
 * @author italo-santos-mendes
 */
public class Medico extends Pessoa {
    private String especialidade;

      public Medico(long ID, String nome, String email, String senha, String CPF, String telefone, String sexo,
            String especialidade) {
        super(ID, nome, email, senha, CPF, telefone, sexo);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString(){
        return this.nome;
    }
}
