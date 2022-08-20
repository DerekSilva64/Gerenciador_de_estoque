package com.danxter.estoque;

import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PJCException;
import com.danxter.exceptions.PNEException;
import com.danxter.produto.Produto;

import java.util.Vector;

/**
|=======================================================================================================================
    - Classe que armazena os objetos da classe "Produto".
|=======================================================================================================================
*/

public class EstoqueVector implements IEstoque{

//=| Atributos |========================================================================================================

    Vector<Produto> vetorDeProdutos;

//=| Construtores |=====================================================================================================

    public EstoqueVector(){
        vetorDeProdutos = new Vector<>();
    }

//=| Métodos |==========================================================================================================

    @Override
    public void adicionar(Produto produto) throws PJCException {

        int indice = 0;
        boolean achou = false;

        while (!achou && indice < vetorDeProdutos.size()) {
            if (produto.getCodigoDoProduto().equals(vetorDeProdutos.get(indice).getCodigoDoProduto())) {
                achou = true;
            } else {
                indice++;
            }
        }

        if (achou) {
            throw new PJCException(produto.getCodigoDoProduto());
        } else {
            vetorDeProdutos.add(produto);
        }

    }

    @Override
    public Produto buscarCodigo(String codigo) throws PNEException {

        int indice = 0;
        boolean achou = false;

        while (!achou && indice < vetorDeProdutos.size()) {
            if (vetorDeProdutos.get(indice).getCodigoDoProduto().equals(codigo)) {
                achou = true;
            } else {
                indice++;
            }
        }

        if (achou) {
            return vetorDeProdutos.get(indice);
        } else {
            throw new PNEException(codigo);
        }

    }

    @Override
    public void apagar(String codigo) throws PNEException {

        Produto produto;

        produto = buscarCodigo(codigo);

        vetorDeProdutos.remove(produto);

    }

    @Override
    public int quantidade() {

        int somaTotal = 0;
        int indice;

        for (indice = 0; indice < vetorDeProdutos.size(); indice++) {
            somaTotal += vetorDeProdutos.get(indice).getQuantidadeDoProduto();
        }

        return somaTotal;
    }

    @Override
    public Produto[] produtosEmEstoque() throws AVException {

        Produto[] p = new Produto[1000];
        int i;

        for (i = 0; i < vetorDeProdutos.size(); i++) {
            p[i] = vetorDeProdutos.get(i);
        }

        if(p[0] != null){
            return p;
        } else{
            throw new AVException();
        }

    }

    @Override
    public Produto[] produtosEmFalta() throws AVException {

        Produto[] p = new Produto[1000];
        int i;
        int j = 0;

        for (i = 0; i < vetorDeProdutos.size(); i++) {
            if(vetorDeProdutos.get(i).getQuantidadeDoProduto() == 0){
                p[j] = vetorDeProdutos.get(i);
                j++;
            }
        }

        if(p[0] != null){
            return p;
        } else{
            throw new AVException();
        }

    }

//======================================================================================================================

}
