package com.unifor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DbConnect {
	// 33976723_gerenciador
	// sql100.byetcluster.com

	
	public static Connection conexaoBancoDeDados() {
		Connection connect = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/estoque?user=root&password=@Dextreme64";
			connect = DriverManager.getConnection(url);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.out.print("Conectado com sucesso");
		return connect;
	}
	
	public static boolean adicionarUsuario(String nome, String descricao, String quantidade) {
        String sql = "INSERT INTO produtos (nome,descricao,quantidade) VALUES (?,?,?)";

        try (Connection connection = conexaoBancoDeDados(); 
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nome);
            statement.setString(2, descricao);
            statement.setString(3, quantidade);


            int linhasAfetadas = statement.executeUpdate();

            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar usuário: " + e.getMessage());
            return false;
        }
    }
	
	public static List<Produto> buscarTodosUsuarios() {
        String sql = "SELECT * FROM produtos";
        List<Produto> usuarios = new ArrayList<>();

        try (Connection connection = DbConnect.conexaoBancoDeDados(); 
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                int quantidade = resultSet.getInt("quantidade");

                usuarios.add(new Produto(id, nome, descricao, quantidade));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuários: " + e.getMessage());
        }

        return usuarios;
    }
	public void removerProduto(Produto produto) {
		
	}
	
	
	
	
}
