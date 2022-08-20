package com.danxter.mains;

import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PIEException;
import com.danxter.gerenciador.Gerenciador;
import com.danxter.estoque.EstoqueVector;
import com.danxter.exceptions.PJCException;
import com.danxter.exceptions.PNEException;
import com.danxter.produto.Produto;
import com.danxter.produto.ProdutoPerecivel;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
|=======================================================================================================================
    - Classe main para rodar o programa no terminal do comando.
|=======================================================================================================================
*/

public class MainT {

//=| Métodos de auxilio |===============================================================================================

    public static String confirmar(){

        Scanner scan = new Scanner(System.in);
        String escolha = "";
        boolean valido = false;

        System.out.print("s/n: ");

        while (!valido) {
            escolha = scan.nextLine().toLowerCase();

            if (escolha.equals("n")) {
                valido = true;
            } else if (escolha.equals("s")) {
                valido = true;
            } else {
                System.out.println("\n===================================================");
                    System.out.println("\nCOMANDO INVALIDO!");
                System.out.print("\ns/n: ");
            }
        }

        if(escolha.equals("n")){
            return "n";
        } else {
            return "s";
        }
    }

//=| Método main |======================================================================================================

    public static void main(String[] args) {

        Gerenciador gerenciador = new Gerenciador(new EstoqueVector());
        Scanner scan = new Scanner(System.in);
        String escolha;
        boolean fechar = false;

        try {
            gerenciador.lerRelatorio();
        } catch (IOException | NullPointerException | PJCException ignored) {
        }

        try {
            gerenciador.lerRelatorioPeressivel();
        } catch (IOException | NullPointerException | PJCException ignored) {
        }

        while(!fechar) {

//=========| Menu |=====================================================================================================

            System.out.println("\n=============| GERENCIADOR DE ESTOQUE |==============\n");
            System.out.println("[1] Cadastrar produto.");
            System.out.println("[2] Remover produto.");
            System.out.println("[3] Pesquisar produto.");
            System.out.println("[4] Estocar produto.");
            System.out.println("[5] Vender produto.");
            System.out.println("[6] Listar produto.");
            System.out.println("[7] Listar produtos em falta.");
            System.out.println("[8] Fechar programa.");
            System.out.println("\n=====================================================");
            System.out.print("\nEscolha um comando: ");
            escolha = scan.nextLine();

            switch (escolha){
                case "1": // Cadastrar produto.

//================| Variáveis de controle |=============================================================================

                    String nome1;
                    String codigo1;
                    String dataDeValidade1 = "";
                    double preco1;

                    String confirma1;
                    String confirma11;

//================| Cadastro do produto |===============================================================================

                    System.out.println("\n==============| CADASTRANDO PRODUTO |==============\n");
                    System.out.println("Este produto e peressivel?");
                    confirma1 = confirmar();
                    System.out.println("\n=====================================================");

//================| Atributos dos produtos |============================================================================

                    System.out.print("\nDigite o nome do produto: ");
                    nome1 = scan.nextLine().toLowerCase();

                    System.out.print("Digite o codigo do produto: ");
                    codigo1 = scan.nextLine();

                    try{
                        System.out.print("Digite o preco do produto: ");
                        preco1 = scan.nextDouble();
                        scan.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("\n=====================================================");
                        System.out.println("\nVALOR INSERIDO INVALIDO!");
                        scan.nextLine();
                        break;
                    }

                    if(confirma1 == "s"){
                        System.out.print("Digite a data de validade do produto: ");
                        dataDeValidade1 = scan.nextLine();
                    }

                    System.out.println("\n=====================================================");

//================| Confirmação do cadastro |===========================================================================

                    System.out.println("\nDeseja mesmo cadastrar o seguinte produto: ");
                    System.out.println("\nNome do produto: " + nome1);
                    System.out.println("Codigo do produto: " + codigo1);
                    System.out.println("Preco do produto: " + preco1);
                    if(confirma1.equals("s")){
                        System.out.println("Validade do produto: "+dataDeValidade1);
                    }
                    confirma11 = confirmar();

                    if (confirma11.equals("n")) {
                        System.out.println("\n=====================================================");
                        System.out.println("\nOPERACAO CADASTRAR FOI CANCELADA!");
                        break;
                    }
                    System.out.println("\n=====================================================");

//================| Criar o produto e guardar no estoque |==============================================================

                    if(confirma1.equals("n")){

                        try {
                            gerenciador.adicionarProduto(new Produto(nome1, codigo1, preco1));
                            System.out.println("\nPRODUTO \"" + nome1 + "\" FOI CADASTRADO!");
                        } catch (PJCException e) {
                            System.out.println("\nPRODUTO JA CADASTRADO!");
                        }

                    } else if(confirma1.equals("s")){

                        try {
                            gerenciador.adicionarProduto(new ProdutoPerecivel(nome1, codigo1, dataDeValidade1, preco1));
                            System.out.println("\nPRODUTO PERECIVEL \"" + nome1 + "\" FOI CADASTRADO!");
                        } catch (PJCException e) {
                            System.out.println("\nPRODUTO JA CADASTRADO!");
                        }

                    }

//======================================================================================================================

                    break;
                case "2": // Remover produto.

//================| Variáveis de controle |=============================================================================

                    Produto p2;
                    String codigo2;
                    String confirma2;


//================| Inserir o código |==================================================================================

                    System.out.println("\n===============| REMOVENDO PRODUTO |===============\n");

                    System.out.print("Digite o codigo do produto: ");
                    codigo2 = scan.nextLine();

                    System.out.println("\n=====================================================");

//================| Achar e remover o produto |=========================================================================

                    try {
                        p2 = gerenciador.consultarProduto(codigo2);
                    } catch (PNEException e) {
                        System.out.println("\nPRODUTO NAO ENCONTRADO!");
                        break;
                    }

//================| Confirmação de remoção |============================================================================

                    System.out.println("\nDeseja mesmo remover o seguinte produto: " + p2.getNomeDoProduto());
                    confirma2 = confirmar();

                    if (confirma2.equals("n")) {
                        System.out.println("\n=====================================================");
                        System.out.println("\nOPERACAO REMOVER FOI CANCELADA!");
                        break;
                    }

                    try {
                        gerenciador.removerProduto(p2.getCodigoDoProduto());
                    } catch (PNEException e) {
                        System.out.println("\nPRODUTO NAO ENCONTRADO!");
                    }

//================| Mensagem de confirmação de remoção |================================================================

                    System.out.println("\n=====================================================");
                    System.out.println("\nPRODUTO \"" + p2.getNomeDoProduto() + "\" FOI REMOVIDO!");

//======================================================================================================================

                    break;
                case "3": // Consultar produto.

                    Produto p3;
                    String codigo3;

//================| Inserir o código |==================================================================================

                    System.out.println("\n===============| CONSULTAR PRODUTO |===============\n");

                    System.out.print("Digite o codigo do produto: ");
                    codigo3 = scan.nextLine();

                    System.out.println("\n=====================================================");

//================| Achar e consultar o produto |=======================================================================

                    try {
                        p3 = gerenciador.consultarProduto(codigo3);
                    } catch (PNEException e) {
                        System.out.println("\nPRODUTO NAO ENCONTRADO!");
                        break;
                    }

//================| Imprime os dados do produto |=======================================================================

                    System.out.println("\n| Informacoes do produto |");
                    System.out.println("\nNome do produto: " + p3.getNomeDoProduto());
                    System.out.println("Codigo do produto: " + p3.getCodigoDoProduto());
                    System.out.println("Preco do produto: " + p3.getPrecoDoProduto());
                    System.out.println("Quantidade do produto: " + p3.getQuantidadeDoProduto());
                    if(p3 instanceof ProdutoPerecivel){
                        ProdutoPerecivel produtoPeressivel;
                        produtoPeressivel = (ProdutoPerecivel) p3;
                        System.out.println("Data de validade: "+produtoPeressivel.getValidadeDoProduto());
                    }

//======================================================================================================================

                    break;
                case "4": // Estocar produto

//================| Variáveis de controle |=============================================================================

                    String codigo4;
                    String confirma4;
                    int quantidade4;

//================| Inserir o código e quantidade |=====================================================================

                    System.out.println("\n================| ESTOCAR PRODUTO |================\n");

                    System.out.print("Digite o codigo do produto: ");
                    codigo4 = scan.nextLine();

                    System.out.print("Quantos produtos deseja estocar: ");
                    try {
                        quantidade4 = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n=====================================================");
                        System.out.println("\nVALOR INSERIDO INVALIDO!");
                        scan.nextLine();
                        break;
                    }

//================| Confirmação de estocar |============================================================================

                    try {
                        System.out.println("\n=====================================================");
                        System.out.println("\nDeseja mesmo estocar "+quantidade4+" unidades do produto \""+ gerenciador.consultarProduto(codigo4).getNomeDoProduto()+"\"?");
                    } catch (PNEException e) {
                        System.out.println("\nPRODUTO NAO ENCONTRADO!");
                        scan.nextLine();
                        break;
                    }

                    confirma4 = confirmar();

//================| Estoca a quantidade de produto |====================================================================

                    if(confirma4.equals("s")){
                        try {
                            gerenciador.estocarProduto(codigo4, quantidade4);
                            scan.nextLine();
                        } catch (PNEException ignored) {
                            System.out.println("PRODUTO NAO ENCONTRADO!");
                        }
                    } else{
                        System.out.println("\n=====================================================");
                        System.out.println("\nOPERACAO ESTOCAR CANCELADA!");
                        scan.nextLine();
                        break;
                    }

//================| Mensagem de confirmação |===========================================================================

                    try {
                        System.out.println("\n=====================================================");
                        System.out.println("\nFoi estocado " + quantidade4 + " unidades do produto \"" + gerenciador.consultarProduto(codigo4).getNomeDoProduto()+"\"");
                    } catch (PNEException e) {
                        System.out.println("PRODUTO NAO ENCONTRADO!");
                    }

//======================================================================================================================

                    break;
                case "5": // Vender produto

                    String codigo5;
                    String confirma5;
                    int quantidade5;

//================| Inserir o codigo e quantidade |=====================================================================

                    System.out.println("\n================| VENDER PRODUTO |================\n");

                    System.out.print("Digite o codigo do produto: ");
                    codigo5 = scan.nextLine();

                    System.out.print("Quantos produtos deseja vender: ");
                    try {
                        quantidade5 = scan.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n=====================================================");
                        System.out.println("\nVALOR INSERIDO INVALIDO!");
                        scan.nextLine();
                        break;
                    }

                    System.out.println("\n=====================================================");

//================| Confirmação de venda |==============================================================================

                    try {
                        System.out.println("Deseja mesmo vender " + quantidade5 + " unidades do produto " + gerenciador.consultarProduto(codigo5).getNomeDoProduto());
                        scan.nextLine();
                    } catch (PNEException e) {
                        System.out.println("\nPRODUTO NAO ENCONTRADO!");
                        scan.nextLine();
                        break;
                    }

                    confirma5 = confirmar();

                    if (confirma5.equals("n")) {
                        System.out.println("\n=====================================================");
                        System.out.println("\nOPERACAO VENDER FOI CANCELADA!");
                        break;
                    }
                    System.out.println("\n=====================================================");

//================| Vender o produto |==================================================================================

                    try {
                        gerenciador.venderProduto(codigo5, quantidade5);
                    } catch (PNEException e) {
                        System.out.println("\n=====================================================");
                        break;
                    } catch (PIEException e) {
                        System.out.println("\nPRODUTO INSUFICIENTE NO ESTOQUE!");
                        break;
                    }

//================| Mensagem de confirmação |===========================================================================

                    try {
                        System.out.println("\nFOI VENDIDO " + quantidade5 + " UNIDADES DO PRODUTO \"" + gerenciador.consultarProduto(codigo5).getNomeDoProduto()+"\"");
                    } catch (PNEException ignored) {
                    }

//======================================================================================================================

                    break;
                case "6": // Listar produto.

//================| Variáveis de controle |=============================================================================

                    Produto[] pa;
                    int indice = 0;
                    int cont = 1;

//================| Listar os produtos |================================================================================

                    System.out.println("\n==========| LISTA DE PRODUTOS EM ESTOQUE |=========\n");

                    try {
                        pa = gerenciador.listarProdutos();
                    } catch (AVException e) {
                        System.out.println("NAO HA PRODUTOS CADASTRADOS!");
                        break;
                    }

                    System.out.println("O estoque possui "+gerenciador.estoque.quantidade()+" produtos armazenados");
                    System.out.println("\n=====================================================");

//================| Imprimir a lista |==================================================================================

                    while (pa[indice] != null) {
                        if(pa[indice] instanceof ProdutoPerecivel){
                            ProdutoPerecivel pp;
                            pp = (ProdutoPerecivel) pa[indice];
                            System.out.println("["+cont+"] | Produto peressivel |\nCodigo: "+pa[indice].getCodigoDoProduto()+"\nNome: "+pa[indice].getNomeDoProduto()+"\nPreco: "+pa[indice].getPrecoDoProduto()+"\nQuantidade: "+pa[indice].getQuantidadeDoProduto()+"\nValidade: "+pp.getValidadeDoProduto());
                            System.out.println("============================");
                            indice++;
                            cont++;
                        } else if(pa[indice] instanceof Produto){
                            System.out.println("["+cont+"] | Produto nao peressivel |\nCodigo: "+pa[indice].getCodigoDoProduto()+"\nNome: "+pa[indice].getNomeDoProduto()+"\nPreco: "+pa[indice].getPrecoDoProduto()+"\nQuantidade: "+pa[indice].getQuantidadeDoProduto());
                            System.out.println("============================");
                            indice++;
                            cont++;
                        }

                    }

                    break;
                case "7": // Listar produtos em falta

//================| Variáveis de controle |=============================================================================

                    Produto[] pa2;
                    int indice2 = 0;

//================| Listar os produtos |================================================================================

                    System.out.println("\n=====| LISTA DE PRODUTOS EM FALTA NO ESTOQUE |=====\n");

                    try {
                        pa2 = gerenciador.listarProdutosEmFalta();
                    } catch (AVException e) {
                        System.out.println("NAO HA PRODUTOS EM FALTA!");
                        break;
                    }

//================| Imprimir a lista |==================================================================================

                    while (pa2[indice2] != null) {
                        System.out.println("Codigo: "+pa2[indice2].getCodigoDoProduto() + "\nNome: " + pa2[indice2].getNomeDoProduto() + "\nPreco: " + pa2[indice2].getPrecoDoProduto());
                        System.out.println("============================");
                        indice2++;
                    }

                    break;
                case "8": // Gerar relatórios e fechar o programa.

                    try {
                        gerenciador.gerarRelatorios();
                    } catch (AVException e) {
                        System.out.println("\nRELATORIOS NAO FORAM CRIADOS POIS NAO PRODUTOS CADASTRADOS!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    fechar = true;

                    break;
                default:

                    System.out.println("\n=====================================================");
                    System.out.println("\nCOMANDO INVALIDO!");

                    break;

            }

        }
    }

}
