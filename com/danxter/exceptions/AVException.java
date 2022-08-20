package com.danxter.exceptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
|=======================================================================================================================
    - Classe de exception "Array vazio".
|=======================================================================================================================
*/

public class AVException extends Exception implements ActionListener {

//=| Atributos |========================================================================================================

    JFrame frame;
    JFrame frame2;

    JButton botaoOk;
    JButton botaoOk2;

//=| Construtor |=======================================================================================================

    public AVException(){
        super();
    }

//=| Métodos |==========================================================================================================

    public void mensagemDeErro(){
        System.out.println("NAO HA PRODUTOS CADASTRADO");
    }

    public void mensagemDeErro2(){
        System.out.println("NAO HA PRODUTOS EM FALTA");
    }

    public void janelaDeErro(){
        frame = new JFrame("AVISO");

        frame.setSize(230, 90);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setUndecorated(true);

        frame.setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon("src/br/ufc/dc/br.tpi/gui/imagens/aviso.jpg");
        frame.setIconImage(logo.getImage());

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
        JLabel titulo = new JLabel("NÃO HÁ PRODUTO CADASTRADOS");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCI.add(titulo, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk = new JButton("OK");
        botaoOk.setSize(80, 20);
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(this);

        painelCE.add(botaoOk);

        //=| Visible |
        frame.setVisible(true);
    }

    public void janelaDeErro2(){
        frame2 = new JFrame("AVISO");

        frame2.setSize(220, 90);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setUndecorated(true);

        frame2.setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon("src/br/ufc/dc/br.tpi/gui/imagens/aviso.jpg");
        frame2.setIconImage(logo.getImage());

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

        frame2.add(painelCI, BorderLayout.NORTH);
        frame2.add(painelDE, BorderLayout.WEST);
        frame2.add(painelES, BorderLayout.EAST);
        frame2.add(painelBA, BorderLayout.SOUTH);
        frame2.add(painelCE, BorderLayout.CENTER);

        //=| Titulo |
        JLabel titulo = new JLabel("NÃO HÁ PRODUTOS EM FALTA");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCI.add(titulo, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk2 = new JButton("OK");
        botaoOk2.setSize(80, 20);
        botaoOk2.setFocusable(false);
        botaoOk2.addActionListener(this);

        painelCE.add(botaoOk2);

        //=| Visible |
        frame2.setVisible(true);
    }

//=| Listener |=========================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoOk){
            frame.dispose();
        }

        if (e.getSource() == botaoOk2){
            frame2.dispose();
        }
    }

//======================================================================================================================

}
