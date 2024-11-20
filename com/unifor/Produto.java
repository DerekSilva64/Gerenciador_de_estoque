package com.unifor;

public class Produto {
	
	private int id;
    private String nome;
    private String descricao;
    private int quantidade;

    public Produto(int idDoProduto, String nomeDoProduto, String descricaoDoProduto, int quantidadeDoProduto){
        this.nome = nomeDoProduto;
        this.id = idDoProduto;
        this.descricao = descricaoDoProduto;
        this.quantidade = quantidadeDoProduto;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\n" +
        		"Nome: " + nome + "\n" +
        		"Descricao: " + descricao + "\n" +
        		"Quantidade: " + quantidade + "\n";
    }


//=| Getters |==========================================================================================================

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
    	return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

//=| Setters |==========================================================================================================
    public void setCodigo(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
