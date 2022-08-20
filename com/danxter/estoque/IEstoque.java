package com.danxter.estoque;

import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PJCException;
import com.danxter.exceptions.PNEException;
import com.danxter.produto.Produto;

public interface IEstoque {

/**
 |=======================================================================================================================
    - Interface para as classes do tipo estoque.
 |=======================================================================================================================
 */

//=| Métodos |==========================================================================================================

public void adicionar(Produto produto) throws PJCException;
    public Produto buscarCodigo(String codigo) throws PNEException;
    public void apagar(String codigo) throws PNEException;
    public int quantidade();
    public Produto[] produtosEmEstoque() throws AVException;
    public Produto[] produtosEmFalta() throws AVException;

//======================================================================================================================

}
