package com.mycompany.decisor;

import javax.swing.JOptionPane;
import com.mycompany.decisor.dao.PrioridadeDao;
import com.mycompany.decisor.dao.TarefaDao;
import com.mycompany.decisor.model.Prioridade;
import com.mycompany.decisor.model.Tarefa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Configuração da conexão com o banco de dados
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/decisor", "root", "Akin@937539"); // Substitua com suas credenciais

            while (true) {  // Laço para manter o menu ativo
                String[] options = { 
                    "Inserir Tarefa", 
                    "Alterar Tarefa", 
                    "Excluir Tarefa", 
                    "Listar Tarefas", 
                    "Inserir Prioridade", 
                    "Alterar Prioridade", 
                    "Excluir Prioridade", 
                    "Listar Prioridades", 
                    "Sair"
                };

                int choice = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu", 
                                                          JOptionPane.DEFAULT_OPTION, 
                                                          JOptionPane.INFORMATION_MESSAGE, 
                                                          null, options, options[0]);

                switch (choice) {
                    case 0: // Inserir Tarefa
                        inserirTarefa();
                        break;
                    case 1: // Alterar Tarefa
                        alterarTarefa();
                        break;
                    case 2: // Excluir Tarefa
                        excluirTarefa();
                        break;
                    case 3: // Listar Tarefas
                        listarTarefas();
                        break;
                    case 4: // Inserir Prioridade
                        inserirPrioridade();
                        break;
                    case 5: // Alterar Prioridade
                        alterarPrioridade();
                        break;
                    case 6: // Excluir Prioridade
                        excluirPrioridade();
                        break;
                    case 7: // Listar Prioridades
                        listarPrioridades();
                        break;
                    case 8: // Sair
                        JOptionPane.showMessageDialog(null, "Saindo... até logo!");
                        System.exit(0); // Encerra a aplicação
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void inserirTarefa() {
        String anotacao = JOptionPane.showInputDialog("Digite a anotação da tarefa:");
        int nivelPrioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de prioridade:"));

        Tarefa tarefa = new Tarefa(anotacao, nivelPrioridade);
        TarefaDao tarefaDao = new TarefaDao(connection);
        tarefaDao.inserir(tarefa);

        JOptionPane.showMessageDialog(null, "Tarefa inserida com sucesso!");
    }

    public static void alterarTarefa() {
        int idTarefa = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da tarefa que deseja alterar:"));
        String anotacao = JOptionPane.showInputDialog("Digite a nova anotação da tarefa:");
        int nivelPrioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo nível de prioridade:"));

        Tarefa tarefa = new Tarefa(idTarefa, anotacao, nivelPrioridade);
        TarefaDao tarefaDao = new TarefaDao(connection);
        tarefaDao.alterar(tarefa);

        JOptionPane.showMessageDialog(null, "Tarefa alterada com sucesso!");
    }

    public static void excluirTarefa() {
        int idTarefa = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da tarefa que deseja excluir:"));
        TarefaDao tarefaDao = new TarefaDao(connection);
        tarefaDao.excluir(idTarefa);

        JOptionPane.showMessageDialog(null, "Tarefa excluída com sucesso!");
    }

    public static void listarTarefas() {
        TarefaDao tarefaDao = new TarefaDao(connection);
        tarefaDao.listar();
    }

    public static void inserirPrioridade() {
        int nivelPrioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de prioridade:"));
        Prioridade prioridade = new Prioridade(nivelPrioridade);
        PrioridadeDao prioridadeDao = new PrioridadeDao(connection);
        prioridadeDao.inserir(prioridade);

        JOptionPane.showMessageDialog(null, "Prioridade inserida com sucesso!");
    }

    public static void alterarPrioridade() {
        int nivelPrioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de prioridade que deseja alterar:"));
        Prioridade prioridade = new Prioridade(nivelPrioridade);
        PrioridadeDao prioridadeDao = new PrioridadeDao(connection);
        prioridadeDao.alterar(prioridade);

        JOptionPane.showMessageDialog(null, "Prioridade alterada com sucesso!");
    }

    public static void excluirPrioridade() {
        int nivelPrioridade = Integer.parseInt(JOptionPane.showInputDialog("Digite o nível de prioridade que deseja excluir:"));
        PrioridadeDao prioridadeDao = new PrioridadeDao(connection);
        prioridadeDao.excluir(nivelPrioridade);

        JOptionPane.showMessageDialog(null, "Prioridade excluída com sucesso!");
    }

    public static void listarPrioridades() {
        PrioridadeDao prioridadeDao = new PrioridadeDao(connection);
        prioridadeDao.listar();
    }
}
