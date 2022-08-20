package com.danxter.gerenciador;

import com.danxter.estoque.IEstoque;
import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PIEException;
import com.danxter.exceptions.PJCException;
import com.danxter.exceptions.PNEException;
import com.danxter.produto.Produto;
import com.danxter.produto.ProdutoPerecivel;

import java.io.*;

/**
|=======================================================================================================================
    - Classe que gerencia as classes de estoque de produtos.
|=======================================================================================================================
*/

public class Gerenciador {

//=| Atributos |========================================================================================================

    public IEstoque estoque;

//=| Construtor |=======================================================================================================

    public Gerenciador(IEstoque estoque){
        this.estoque = estoque;
    }

//=| Métodos |==========================================================================================================

    public void adicionarProduto(Produto produto) throws PJCException {

        estoque.adicionar(produto);

    }

    public void removerProduto(String codigo) throws PNEException {

        estoque.apagar(codigo);

    }

    public void venderProduto(String codigo, int quantidade) throws PNEException, PIEException {

        Produto p = estoque.buscarCodigo(codigo);

        p.removerProduto(quantidade);

    }

    public void estocarProduto(String codigo, int quantidade) throws PNEException {

        Produto p = estoque.buscarCodigo(codigo);

        p.adicionarProduto(quantidade);

    }

    public Produto consultarProduto(String codigo) throws PNEException {

        return estoque.buscarCodigo(codigo);

    }

    public Produto[] listarProdutos() throws AVException {

        return estoque.produtosEmEstoque();

    }

    public Produto[] listarProdutosEmFalta() throws AVException {

        return estoque.produtosEmFalta();

    }

//=| Save do estoque |==================================================================================================

    public void gerarRelatorios() throws AVException, IOException {

//====| Atributos |=====================================================================================================

        Produto[] produtos;
        File relatorio, relatorioSave, relatorioSavePeressivel;
        FileWriter fw, fw2, fw3;
        int indice = 0, indice2 = 0, contador = 1;

//====| Abrir os arquivos |==============================================================================================

        relatorio = new File("src/com/danxter/relatorios/relatorio.txt");
        fw = new FileWriter(relatorio);

        relatorioSave = new File("src/com/danxter/relatorios/relatorioSave.txt");
        fw2 = new FileWriter(relatorioSave);

        relatorioSavePeressivel = new File("src/com/danxter/relatorios/relatorioSavePerecivel.txt");
        fw3 = new FileWriter(relatorioSavePeressivel);

        produtos = listarProdutos();

//====| Escrever no relatorio |=========================================================================================

        fw.write("| RELATÓRIO DE ESTOQUE DA APLICAÇÃO BODEGA |\n\n");
        fw.write("- O estoque possui "+estoque.quantidade()+" produtos armazenados\n\n");
        fw.write("| Listas de produtos cadastrados |\n\n");

        while (produtos[indice] != null) {

            if(produtos[indice] instanceof ProdutoPerecivel){
                ProdutoPerecivel pp;
                pp = (ProdutoPerecivel) produtos[indice];
                fw.write("[" + contador + "] Código do produto: " + produtos[indice].getCodigoDoProduto() + " | Nome do produto: " + produtos[indice].getNomeDoProduto() + " | Preço do produto: " + produtos[indice].getPrecoDoProduto() + " | Quantidade em estoque: " + produtos[indice].getQuantidadeDoProduto() + " | Data de validade: "+pp.getValidadeDoProduto()+ "\n");
                indice++;
                contador++;

            } else if(produtos[indice] instanceof Produto){
                fw.write("[" + contador + "] Código do produto: " + produtos[indice].getCodigoDoProduto() + " | Nome do produto: " + produtos[indice].getNomeDoProduto() + " | Preço do produto: " + produtos[indice].getPrecoDoProduto() + " | Quantidade em estoque: " + produtos[indice].getQuantidadeDoProduto() + "\n");
                indice++;
                contador++;
            }


        }
        fw.flush();
        fw.close();

//====| Escrever no relatorio de save |=================================================================================

        while (produtos[indice2] != null) {

            if(produtos[indice2] instanceof ProdutoPerecivel){
                ProdutoPerecivel pp2;
                pp2 = (ProdutoPerecivel) produtos[indice2];
                fw3.write(produtos[indice2].getCodigoDoProduto() + " " + produtos[indice2].getNomeDoProduto() + " " + produtos[indice2].getPrecoDoProduto() + " " + produtos[indice2].getQuantidadeDoProduto() + " "+pp2.getValidadeDoProduto()+ "\n");
                indice2++;

            } else if(produtos[indice2] instanceof Produto){
                fw2.write(produtos[indice2].getCodigoDoProduto() + " " +produtos[indice2].getNomeDoProduto() + " " + produtos[indice2].getPrecoDoProduto() + " " + produtos[indice2].getQuantidadeDoProduto() + "\n");
                indice2++;
            }

        }
        fw2.flush();
        fw3.flush();

        fw2.close();
        fw3.close();

//======================================================================================================================

    }

    public void lerRelatorio() throws IOException, PJCException, NullPointerException {

//====| Atributos |=====================================================================================================

        String codigo, nome, preco, quantidade;

        double precoD;
        int quantidadeI;

        boolean acabou = false;

//====| Abrir arquivo |=================================================================================================

        FileReader fr = new FileReader("src/com/danxter/relatorios/relatorioSave.txt");
        BufferedReader br = new BufferedReader(fr);

//====| Guarda os produtos |============================================================================================

        while (!acabou) {

            String[] palavras = br.readLine().split(" ");

            codigo = palavras[0];
            nome = palavras[1];
            preco = palavras[2];
            quantidade = palavras[3];

            if (codigo == null) {
                break;
            }

            precoD = Double.parseDouble(preco);
            quantidadeI = Integer.parseInt(quantidade);

            adicionarProduto(new Produto(nome, codigo, precoD, quantidadeI));

//======================================================================================================================

        }

    }

    public void lerRelatorioPeressivel() throws IOException, PJCException, NullPointerException {

//====| Atributos |=====================================================================================================

        String codigo, nome, preco, quantidade, validade;

        double precoD;
        int quantidadeI;

        boolean acabou = false;

//====| Abrir arquivo |=================================================================================================

        FileReader fr = new FileReader("src/com/danxter/relatorios/relatorioSavePerecivel.txt");
        BufferedReader br = new BufferedReader(fr);

//====| Guarda os produtos |============================================================================================

        while (!acabou) {

            String[] palavras = br.readLine().split(" ");

            codigo = palavras[0];
            nome = palavras[1];
            preco = palavras[2];
            quantidade = palavras[3];
            validade = palavras[4];

            if (codigo == null) {
                break;
            }

            precoD = Double.parseDouble(preco);
            quantidadeI = Integer.parseInt(quantidade);

            adicionarProduto(new ProdutoPerecivel(nome, codigo, precoD, quantidadeI, validade));

        }

//======================================================================================================================

    }

//======================================================================================================================

}
