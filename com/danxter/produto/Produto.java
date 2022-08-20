package com.danxter.produto;

import com.danxter.exceptions.PIEException;

/**
|=======================================================================================================================
    - Classe que guarda o atributos de cada objeto do tipo produto que seja criado.
|=======================================================================================================================
*/

public class Produto {

//=| Atributos |========================================================================================================

    private String nomeDoProduto;
    private String codigoDoProduto;
    private double precoDoProduto;
    private int quantidadeDoProduto;

//=| Construtores |=====================================================================================================

    public Produto(String nomeDoProduto, String codigoDoProduto , double precoDoProduto){
        this.nomeDoProduto = nomeDoProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.precoDoProduto = precoDoProduto;
        quantidadeDoProduto = 0;
    }

    public Produto(String nomeDoProduto, String codigoDoProduto, double precoDoProduto, int quantidadeDoProduto){
        this.nomeDoProduto = nomeDoProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.precoDoProduto = precoDoProduto;
        this.quantidadeDoProduto = quantidadeDoProduto;
    }

//=| Métodos |==========================================================================================================

    public void adicionarProduto(int quantidadeAdiconada){
        quantidadeDoProduto += quantidadeAdiconada;
    }

    public void removerProduto(int quantidadeRetirada) throws PIEException {

        if(quantidadeRetirada > quantidadeDoProduto){
            throw new PIEException(quantidadeDoProduto);
        } else{
            quantidadeDoProduto -= quantidadeRetirada;
        }

    }

//=| Getters |==========================================================================================================

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }


    public double getPrecoDoProduto() {
        return precoDoProduto;
    }

    public int getQuantidadeDoProduto() {
        return quantidadeDoProduto;
    }

//=| Setters |==========================================================================================================

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public void setPrecoDoProduto(double precoDoProduto) {
        this.precoDoProduto = precoDoProduto;
    }

    public void setQuantidadeDoProduto(int quantidadeDoProduto) {
        this.quantidadeDoProduto = quantidadeDoProduto;
    }

//======================================================================================================================

}


