package com.danxter.interfacegrafica;

import com.danxter.produto.ProdutoPerecivel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaProdutoPerecivel implements ActionListener {

    JFrame frame;

    JButton botaoOk;

    public JanelaProdutoPerecivel(ProdutoPerecivel produto){

        //=| Especificações da janela |=====================================================================================
        frame = new JFrame("Aplicação bodega");

        frame.setSize(240, 260);
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
        painelCE.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 15));

        frame.add(painelCI, BorderLayout.NORTH);
        frame.add(painelDE, BorderLayout.WEST);
        frame.add(painelES, BorderLayout.EAST);
        frame.add(painelBA, BorderLayout.SOUTH);
        frame.add(painelCE, BorderLayout.CENTER);

        //=| Texto nome |
        JLabel textoNome = new JLabel("Nome do produto: "+produto.getNomeDoProduto());
        textoNome.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(textoNome, BorderLayout.NORTH);

        //=| Texto código |
        JLabel textoCodigo = new JLabel("Código do produto: "+produto.getCodigoDoProduto());
        textoCodigo.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(textoCodigo, BorderLayout.NORTH);

        //=| Texto preco |
        JLabel textoPreco = new JLabel("\nPreço do produto: "+produto.getPrecoDoProduto());
        textoPreco.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(textoPreco, BorderLayout.NORTH);

        //=| Texto quantidade |
        JLabel textoQuantidade = new JLabel("\nQuantidade em estoque: "+produto.getQuantidadeDoProduto());
        textoQuantidade.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(textoQuantidade, BorderLayout.NORTH);

        //=| Texto validade |
        JLabel textoValidade = new JLabel("\nValidade em do produto: "+produto.getValidadeDoProduto());
        textoValidade.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(textoValidade, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk = new JButton("OK");
        botaoOk.setSize(80, 20);
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(this);

        painelCE.add(botaoOk);

        //=| Visible |
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoOk){
            frame.dispose();
        }
    }
}
