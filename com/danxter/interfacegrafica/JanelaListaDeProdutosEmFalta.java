package com.danxter.interfacegrafica;

import com.danxter.exceptions.AVException;
import com.danxter.gerenciador.Gerenciador;
import com.danxter.produto.Produto;
import com.danxter.produto.ProdutoPerecivel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaListaDeProdutosEmFalta implements ActionListener {

    JFrame frame;

    JButton botaoVoltar;
    JButton botaoFechar;
    JButton botaoAvancar;

    Gerenciador gerenciador;

    Produto[] produto;

    int i = 0;

    public void janela(){
        //=| Especificações da janela |=====================================================================================
        frame = new JFrame("Aplicação bodega");

        frame.setSize(340, 380);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon("src/br/ufc/dc/tpi/gui/imagens/Icone.jpg");
        frame.setIconImage(logo.getImage());

        JPanel painelCI = new JPanel();
        JPanel painelDE = new JPanel();
        JPanel painelES = new JPanel();
        JPanel painelBA = new JPanel();
        JPanel painelCE = new JPanel();

        painelCI.setBackground(new Color(0x7ba58d));
        painelDE.setBackground(new Color(0x7ba58d));
        painelES.setBackground(new Color(0x7ba58d));
        painelBA.setBackground(new Color(0xf8ebbe));
        painelCE.setBackground(new Color(0x7ba58d));
        // Cor original: 0xbbbbcd

        painelCI.setLayout(new FlowLayout());
        painelDE.setLayout(new FlowLayout());
        painelES.setLayout(new FlowLayout());
        painelBA.setLayout(new FlowLayout());
        painelCE.setLayout(new FlowLayout(FlowLayout.CENTER, 1400, 10));

        frame.add(painelCI, BorderLayout.NORTH);
        frame.add(painelDE, BorderLayout.WEST);
        frame.add(painelES, BorderLayout.EAST);
        frame.add(painelBA, BorderLayout.SOUTH);
        frame.add(painelCE, BorderLayout.CENTER);


        if(produto[i] instanceof ProdutoPerecivel){
            ProdutoPerecivel pp = (ProdutoPerecivel) produto[i];
            //=| Texto nome |
            JLabel titulo = new JLabel("LISTA DE PRODUTOS EM FALTA");
            titulo.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(titulo, BorderLayout.NORTH);

            //=| Divisão |
            JLabel divisao = new JLabel("==================================");
            divisao.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(divisao, BorderLayout.NORTH);

            //=| Texto nome |
            JLabel textoNome = new JLabel("Nome do produto: "+pp.getNomeDoProduto());
            textoNome.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoNome, BorderLayout.NORTH);

            //=| Texto código |
            JLabel textoCodigo = new JLabel("Código do produto: "+pp.getCodigoDoProduto());
            textoCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoCodigo, BorderLayout.NORTH);

            //=| Texto preco |
            JLabel textoPreco = new JLabel("\nPreço do produto: "+pp.getPrecoDoProduto());
            textoPreco.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoPreco, BorderLayout.NORTH);

            //=| Texto validade |
            JLabel textoValidade = new JLabel("\nValidade do produto: "+pp.getValidadeDoProduto());
            textoValidade.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoValidade, BorderLayout.NORTH);

            //=| Divisão |
            JLabel divisao2 = new JLabel("==================================");
            divisao2.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(divisao2, BorderLayout.NORTH);
        } else if(produto[i] instanceof Produto){
            //=| Texto nome |
            JLabel titulo = new JLabel("LISTA DE PRODUTOS FALTA");
            titulo.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(titulo, BorderLayout.NORTH);

            //=| Divisão |
            JLabel divisao = new JLabel("==================================");
            divisao.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(divisao, BorderLayout.NORTH);

            //=| Texto nome |
            JLabel textoNome = new JLabel("Nome do produto: "+produto[i].getNomeDoProduto());
            textoNome.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoNome, BorderLayout.NORTH);

            //=| Texto código |
            JLabel textoCodigo = new JLabel("Código do produto: "+produto[i].getCodigoDoProduto());
            textoCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoCodigo, BorderLayout.NORTH);

            //=| Texto preco |
            JLabel textoPreco = new JLabel("\nPreço do produto: "+produto[i].getPrecoDoProduto());
            textoPreco.setFont(new Font("SansSerif", Font.BOLD, 12));

            painelCE.add(textoPreco, BorderLayout.NORTH);

            //=| Divisão |
            JLabel divisao2 = new JLabel("==================================");
            divisao2.setFont(new Font("SansSerif", Font.BOLD, 15));

            painelCE.add(divisao2, BorderLayout.NORTH);
        }


        //=| Botão voltar |
        botaoVoltar = new JButton("  Voltar   ");
        botaoVoltar.setSize(80, 20);
        botaoVoltar.setFocusable(false);
        botaoVoltar.addActionListener(this);

        painelCE.add(botaoVoltar);

        //=| Botão fechar |
        botaoFechar = new JButton(" Fechar  ");
        botaoFechar.setSize(80, 20);
        botaoFechar.setFocusable(false);
        botaoFechar.addActionListener(this);

        painelCE.add(botaoFechar);

        //=| Botão avançar |
        botaoAvancar = new JButton("Avançar");
        botaoAvancar.setSize(80, 20);
        botaoAvancar.setFocusable(false);
        botaoAvancar.addActionListener(this);

        painelCE.add(botaoAvancar);

        //=| Visible |
        frame.setVisible(true);

    }

    public JanelaListaDeProdutosEmFalta(Gerenciador gerenciador) throws AVException {

        this.gerenciador = gerenciador;

        produto = gerenciador.listarProdutosEmFalta();

        janela();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoVoltar){
            if(i > 0){
                frame.dispose();
                i--;
                janela();
            }
        } else if(e.getSource() == botaoFechar){
            i=0;
            frame.dispose();
        } else if(e.getSource() == botaoAvancar){

            if(produto[i+1] != null){
                i++;
                frame.dispose();
                janela();
            }
        }
    }
}
