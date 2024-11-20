package com.unifor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.unifor.DbConnect;

public class Main {

	public static void main(String[] args) {
		
		new DbConnect();
		

		Connection db = DbConnect.conexaoBancoDeDados();

        Scanner scan = new Scanner(System.in);
        String escolha;
		boolean fechar = false;
		
		while (!fechar) {
			
			
			System.out.println("\n=============| GERENCIADOR DE ESTOQUE |==============\n");
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] Listar produto.");
            System.out.println("[0] Fechar programa.");
            System.out.println("\n=====================================================");
            System.out.print("\nEscolha um comando: ");
            
            escolha = scan.nextLine();
            
            switch (escolha){
            	case "1":
            		
            		String nomeProduto;
            		String descricaoProduto;
            		int quantidadeProduto;
            		
            		System.out.print("Insira o nome do produto: ");
            		nomeProduto = scan.nextLine();
            		
            		System.out.print("Insira a descricao do produto: ");
            		descricaoProduto = scan.nextLine();
            		
            		System.out.print("Insira a quantidade estocada do produto: ");
            		quantidadeProduto = scan.nextInt();
            		
            		DbConnect.adicionarUsuario(nomeProduto, descricaoProduto, Integer.toString(quantidadeProduto));
            		
            		break;
            		
            	case "2":
            		
            		List<Produto> tudo = DbConnect.buscarTodosUsuarios();
            		System.out.println(tudo.toString());
            		

            		
            		break;
            	case "0":
            		System.out.println("\n=====================================================");
                    System.out.println("\nEncerrando programa...");
            		System.out.println("\n=====================================================");
            		fechar = true;
            		break;
            	default:
            		System.out.println("\n=====================================================");
                    System.out.println("\nCOMANDO INVALIDO!");
            		
            }
            
		}

	}

}
