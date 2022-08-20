package com.danxter.exceptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
|=======================================================================================================================
    - Classe de exception "Produto insuficiente em estoque".
|=======================================================================================================================
*/

public class PIEException extends Exception implements ActionListener {

//=| Atributos |========================================================================================================

    JFrame frame;

    JButton botaoOk;

    int quantidade;

//=| Construtor |=======================================================================================================

    public PIEException(int quantidade) {
        super();
        this.quantidade = quantidade;
    }

//=| Métodos |==========================================================================================================

    public void mensagemDeErro() {
        System.out.println("NAO HA PRODUTO SUFICIENTE NO ESTOQUE!");
        System.out.println("SO HA " + quantidade + " UNIDADES NO ESTOQUE");
    }

    public void janelaDeErro() {
        frame = new JFrame("AVISO");

        frame.setSize(380, 120);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        frame.setLayout(new BorderLayout());

        JPanel painelCI = new JPanel();
        JPanel painelDE = new JPanel();
        JPanel painelES = new JPanel();
        JPanel painelBA = new JPanel();
        JPanel painelCE = new JPanel();

        painelCI.setBackground(new Color(0x9ba58d));
        painelDE.setBackground(new Color(0x9ba58d));
        painelES.setBackground(new Color(0x9ba58d));
        painelBA.setBackground(new Color(0xffebbe));
        painelCE.setBackground(new Color(0x9ba58d));
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

        //=| Titulo |
        JLabel texto1 = new JLabel("NÃO HÁ PRODUTO SUFICIENTE NO ESTOQUE");
        texto1.setFont(new Font("SansSerif", Font.BOLD, 15));

        painelCI.add(texto1, BorderLayout.NORTH);

        //=| Titulo |
        JLabel texto2 = new JLabel("SÓ HÁ " + quantidade + " UNIDADES DO PRODUTO NO ESTOQUE");
        texto2.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(texto2, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk = new JButton("OK");
        botaoOk.setSize(80, 20);
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(this);

        painelCE.add(botaoOk);

        //=| Visible |
        frame.setVisible(true);
    }

//=| Listener |========================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoOk) {
            frame.dispose();
        }
    }

//======================================================================================================================
}

