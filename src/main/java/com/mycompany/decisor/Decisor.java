/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.decisor;

import javax.swing.JOptionPane;

/**
 * á
 *
 * @author akin
 */
/*O objetivo desse projeto é criar 
um aplicativo de tomada de decisões
que pergunte o que eu quero decidir, 
guarde as informacoes
associe com uma prioriedade*/
public class Decisor {

    public static void main(String[] args) {
        System.out.println("Welcome");
        menu();

    }

    public static void menu() {
        cadastrarTarefa tarefa = new cadastrarTarefa();
        cadastrarPrioridade prioridade = new cadastrarPrioridade();
        listarTarefas lista = new listarTarefas();
        /* aqui temos que instanciar as classes das quais o menu vai encontrar os metodos
        e funcoes
         */

        String msg = " 0 - Sair \n 1 - Cadastrar tarefa \n 2 - Cadastrar prioridade \n 3- Listar Tarefas";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        /*converte em numero a entrada do usuario para no switch possibilitar uma escolha*/

        switch (num) {
            case 0 -> {
                int out = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?"); //a confirmaçao de sair
                if (out != JOptionPane.YES_OPTION) { //sei lá mano
                    menu();
                }
            }
            case 1 -> {
                tarefa.cadTarefa();
                menu();
            }
            case 2 -> {
                prioridade.cadPrioridade();
                menu();
            }
            case 3 -> {
                lista.listar();
                menu();
            }
            default -> {
                JOptionPane.showMessageDialog(null, "Opçao invalida");
                menu();
            }
        }
    }
}
