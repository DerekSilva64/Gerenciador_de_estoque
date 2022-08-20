package com.danxter.produto;

/**
|=======================================================================================================================
    - Subclasse da classe "Produto".
|=======================================================================================================================
*/

public class ProdutoPerecivel extends  Produto{

//=| Atributos |========================================================================================================

    private String validadeDoProduto;

//=| Construtores |=====================================================================================================

    public ProdutoPerecivel(String nomeDoProduto, String codigoDoProduto, String validadeDoProduto, double precoDoProduto){
        super(nomeDoProduto, codigoDoProduto, precoDoProduto);
        this.validadeDoProduto = validadeDoProduto;
    }

    public ProdutoPerecivel(String nomeDoProduto, String codigoDoProduto, double precoDoProduto, int quantidadeDoProduto, String validadeDoProduto){
        super(nomeDoProduto, codigoDoProduto, precoDoProduto, quantidadeDoProduto);
        this.validadeDoProduto = validadeDoProduto;
    }

//=| Getters |==========================================================================================================

    public String getValidadeDoProduto() {
        return validadeDoProduto;
    }

//=| Setters |==========================================================================================================

    public void setValidadeDoProduto(String validadeDoProduto) {
        this.validadeDoProduto = validadeDoProduto;
    }

//======================================================================================================================


}
