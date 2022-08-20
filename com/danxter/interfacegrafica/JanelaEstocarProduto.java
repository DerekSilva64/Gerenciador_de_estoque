package com.danxter.interfacegrafica;

import com.danxter.exceptions.CNPException;
import com.danxter.exceptions.JanelaDeAvisoVII;
import com.danxter.exceptions.PNEException;
import com.danxter.gerenciador.Gerenciador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaEstocarProduto implements ActionListener {

    JFrame frame;

    Gerenciador gerenciador;

    JButton botaoConfirmar;
    JButton botaoVoltar;

    JTextField preencherCodigo;
    JTextField preencherQuantidade;

    public JanelaEstocarProduto(Gerenciador gerenciador) {
        this.gerenciador = gerenciador;

        //=| Especificações da janela |=====================================================================================
        frame = new JFrame("Aplicação bodega");

        frame.setSize(360, 280);
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
        painelCE.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 10));

        frame.add(painelCI, BorderLayout.NORTH);
        frame.add(painelDE, BorderLayout.WEST);
        frame.add(painelES, BorderLayout.EAST);
        frame.add(painelBA, BorderLayout.SOUTH);
        frame.add(painelCE, BorderLayout.CENTER);

        JLabel titulo = new JLabel("ESTOCAR PRODUTO");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));

        painelCI.add(titulo, BorderLayout.NORTH);

        JLabel textoCodigo = new JLabel("Digite o código do produto");
        textoCodigo.setFont(new Font("SansSerif", Font.BOLD, 10));

        painelCE.add(textoCodigo, BorderLayout.NORTH);

        preencherCodigo = new JTextField();
        preencherCodigo.setPreferredSize(new Dimension(200, 20));

        painelCE.add(preencherCodigo);

        JLabel textoQuantidade = new JLabel("Digite a quantidade que deseja estocar");
        textoQuantidade.setFont(new Font("SansSerif", Font.BOLD, 10));

        painelCE.add(textoQuantidade, BorderLayout.NORTH);

        preencherQuantidade = new JTextField();
        preencherQuantidade.setPreferredSize(new Dimension(200, 20));

        painelCE.add(preencherQuantidade);

        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setSize(80, 30);

        botaoConfirmar.addActionListener(this);

        painelCE.add(botaoConfirmar);

        botaoVoltar = new JButton("   Voltar   ");
        botaoVoltar.setSize(80, 30);

        botaoVoltar.addActionListener(this);

        painelCE.add(botaoVoltar);

        frame.setVisible(true);

    }

//=| Métodos |==========================================================================================================

    public boolean isPreenchido() throws CNPException {
        String codigo = preencherCodigo.getText();
        String quantidade = preencherQuantidade.getText();

        if (!codigo.equals("") && !quantidade.equals("")) {
            return true;
        } else {
            throw new CNPException();
        }
    }

    public void estocarProduto() throws PNEException, NumberFormatException {
        String codigo = preencherCodigo.getText();
        String quantidade = preencherQuantidade.getText();

        int quantidadeI = Integer.parseInt(quantidade);

        gerenciador.estocarProduto(codigo,quantidadeI);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botaoConfirmar) {
            try {
                if(isPreenchido()){
                    try {
                        estocarProduto();
                        frame.dispose();
                    } catch (PNEException ex) {
                        ex.janelaDeErro();
                    } catch (NumberFormatException ex){
                        JanelaDeAvisoVII vii = new JanelaDeAvisoVII();
                    }
                }
            } catch (CNPException ex) {
                ex.janelaDeErro();
            }
        } else if (e.getSource() == botaoVoltar) {
            frame.dispose();
        }

    }

}
