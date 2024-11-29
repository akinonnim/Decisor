package com.mycompany.decisor.dao;

import com.mycompany.decisor.model.Prioridade;
import java.sql.*;

public class PrioridadeDao {
    private Connection connection;

    public PrioridadeDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Prioridade prioridade) {
        String sql = "INSERT INTO prioridade (nivel_prioridade) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, prioridade.getNivelPrioridade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Prioridade prioridade) {
        String sql = "UPDATE prioridade SET nivel_prioridade = ? WHERE nivel_prioridade = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, prioridade.getNivelPrioridade());
            stmt.setInt(2, prioridade.getNivelPrioridade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int nivelPrioridade) {
        String sql = "DELETE FROM prioridade WHERE nivel_prioridade = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, nivelPrioridade);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM prioridade";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Prioridade: " + rs.getInt("nivel_prioridade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
