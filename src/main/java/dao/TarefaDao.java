package com.mycompany.decisor.dao;

import com.mycompany.decisor.model.Tarefa;
import java.sql.*;

public class TarefaDao {
    private Connection connection;

    public TarefaDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (anotacao, nivel_prioridade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getAnotacao());
            stmt.setInt(2, tarefa.getNivelPrioridade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Tarefa tarefa) {
        String sql = "UPDATE tarefa SET anotacao = ?, nivel_prioridade = ? WHERE id_tarefa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, tarefa.getAnotacao());
            stmt.setInt(2, tarefa.getNivelPrioridade());
            stmt.setInt(3, tarefa.getIdTarefa());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int idTarefa) {
        String sql = "DELETE FROM tarefa WHERE id_tarefa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idTarefa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM tarefa";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Tarefa ID: " + rs.getInt("id_tarefa") + ", Anotação: " + rs.getString("anotacao") + ", Prioridade: " + rs.getInt("nivel_prioridade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
