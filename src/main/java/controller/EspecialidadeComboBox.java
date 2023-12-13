/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entities.Especialidade;

/**
 *
 * @author italo
 */
public class EspecialidadeComboBox {
     private Especialidade especialidade;

    public EspecialidadeComboBox(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        // Retorna uma representação formatada da especialidade (ID e nome)
        return String.format("[%d] %s", especialidade.getID(), especialidade.getNome());
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
}
