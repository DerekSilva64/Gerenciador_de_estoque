package com.danxter.estoque;

import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PJCException;
import com.danxter.exceptions.PNEException;
import com.danxter.produto.Produto;

/**
|=======================================================================================================================
    - Classe que armazena os objetos da classe "Produto".
|=======================================================================================================================
*/

public class EstoqueArray implements IEstoque{

//=| Atributos |========================================================================================================

    Produto[] arrayDeProdutos;
    int indice;

//=| Construtor |=======================================================================================================

    public EstoqueArray(){
        arrayDeProdutos = new Produto[1000];
        indice = 0;
    }

//=| Métodos de ajuste do array |=======================================================================================

    public void add(Produto produto){
        arrayDeProdutos[indice] = produto;
        indice++;
    }

    public void remove(Produto produto){

        int indice = 0;

        while (indice < this.indice) {

            if (arrayDeProdutos[indice] == produto) {

                arrayDeProdutos[indice] = arrayDeProdutos[this.indice];
                arrayDeProdutos[this.indice] = null;
                this.indice--;
                break;

            } else {
                indice++;
            }

        }

    }

//=| Métodos |==========================================================================================================

    @Override
    public void adicionar(Produto produto) throws PJCException {

        int indice = 0;
        boolean achou = false;

        while (indice < this.indice) {
            if (produto.getCodigoDoProduto().equals(arrayDeProdutos[indice].getCodigoDoProduto())) {
                achou = true;
                break;
            } else {
                indice++;
            }
        }

        if (achou) {
            throw new PJCException(arrayDeProdutos[indice].getCodigoDoProduto());
        } else {
            add(produto);
        }

    }

    @Override
    public Produto buscarCodigo(String codigo) throws PNEException {

        int indice = 0;
        boolean achou = false;

        while (indice < this.indice) {
            if (arrayDeProdutos[indice].getCodigoDoProduto().equals(codigo)) {
                achou = true;
                break;
            } else {
                indice++;
            }
        }

        if (achou) {
            return arrayDeProdutos[indice];
        } else {
            throw new PNEException(codigo);
        }

    }

    @Override
    public void apagar(String codigo) throws PNEException {

        Produto produto;

        produto = buscarCodigo(codigo);

        remove(produto);

    }

    @Override
    public int quantidade() {

        int somaTotal = 0;
        int indice;

        for (indice = 0; indice < this.indice; indice++) {
            somaTotal += arrayDeProdutos[indice].getQuantidadeDoProduto();
        }

        return somaTotal;

    }

    @Override
    public Produto[] produtosEmEstoque() throws AVException {

        Produto[] p = new Produto[indice];
        int indice;

        for (indice = 0; indice < this.indice; indice++) {
            p[indice] = arrayDeProdutos[indice];
        }

        if(p[0] != null){
            return p;
        } else{
            throw new AVException();
        }

    }

    @Override
    public Produto[] produtosEmFalta() throws AVException {

        Produto[] p = new Produto[indice];
        int j = 0;

        for (int i = 0; i < this.indice; i++) {
            if(arrayDeProdutos[i].getQuantidadeDoProduto() == 0){
                p[j] = arrayDeProdutos[i];
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
