package com.danxter.interfacegrafica;

import com.danxter.gerenciador.Gerenciador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaEscolha implements ActionListener {

    JFrame frame;

    JButton botaoSim;
    JButton botaoNao;
    Gerenciador gerenciador;

    public JanelaEscolha(Gerenciador gerenciador){
        this.gerenciador = gerenciador;

        frame = new JFrame("Aplicação bodega");

        frame.setSize(380, 180);
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
        painelCE.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 15));

        frame.add(painelCI, BorderLayout.NORTH);
        frame.add(painelDE, BorderLayout.WEST);
        frame.add(painelES, BorderLayout.EAST);
        frame.add(painelBA, BorderLayout.SOUTH);
        frame.add(painelCE, BorderLayout.CENTER);

        //=| Titulo |
        JLabel titulo = new JLabel("O produto que deseja cadastrar é peressivel?");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 15));

        painelCI.add(titulo, BorderLayout.NORTH);

        //=| Botão OK |
        botaoSim = new JButton("SIM ");
        botaoSim.setSize(80, 20);
        botaoSim.setFocusable(false);
        botaoSim.addActionListener(this);

        painelCE.add(botaoSim);

        //=| Botão OK |
        botaoNao = new JButton("NÃO");
        botaoNao.setSize(80, 20);
        botaoNao.setFocusable(false);
        botaoNao.addActionListener(this);

        painelCE.add(botaoNao);

        //=| Visible |
        frame.setVisible(true);

    }

//=| Listener |=========================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botaoNao) {
            JanelaCadastrarProduto jcp = new JanelaCadastrarProduto(gerenciador);
            frame.dispose();
        } else if (e.getSource() == botaoSim) {
            JanelaCadastrarProdutoPerecivel jcpp = new JanelaCadastrarProdutoPerecivel(gerenciador);
            frame.dispose();
        }

    }
}
