package com.danxter.exceptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaDeAvisoVII implements ActionListener {

//=| Atributos |========================================================================================================

    JFrame frame;

    JButton botaoOk;

    JLabel titulo;

//=| Construtor |=======================================================================================================

    public JanelaDeAvisoVII() {
        frame = new JFrame("AVISO");

        frame.setSize(200, 100);
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
        titulo = new JLabel("VALOR INSERIDO INVÁLIDO");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(titulo, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk = new JButton("OK");
        botaoOk.setSize(80, 20);
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(this);

        painelCE.add(botaoOk);

        //=| Visible |
        frame.setVisible(true);

    }

//=| Listener |=========================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botaoOk) {
            frame.dispose();
        }

    }

//======================================================================================================================

}
