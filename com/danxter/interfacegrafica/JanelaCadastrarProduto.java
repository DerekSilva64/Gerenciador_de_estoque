package com.danxter.interfacegrafica;

import com.danxter.exceptions.CNPException;
import com.danxter.exceptions.JanelaDeAvisoVII;
import com.danxter.exceptions.PJCException;
import com.danxter.gerenciador.Gerenciador;
import com.danxter.produto.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class JanelaCadastrarProduto implements ActionListener {

//=| Atributos |========================================================================================================

    JFrame frame;

    JTextField preencherNome;
    JTextField preencherCodigo;
    JTextField preencherPreco;

    JButton botaoConfirmar;
    JButton botaoVoltar;

    Gerenciador gerenciador;

//=| Construtor |=======================================================================================================

    public JanelaCadastrarProduto(Gerenciador gerenciador) {
        this.gerenciador = gerenciador;
        //=| Especificações da janela |=====================================================================================
        frame = new JFrame("Aplicação bodega");

        frame.setSize(380, 330);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        ImageIcon logo = new ImageIcon("src/br/ufc/dc/tpi/gui/imagens/Icone.jpg");
        frame.setIconImage(logo.getImage());

        //=| Gerar paineis |================================================================================================
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

        //=| Painel de cima |===============================================================================================
        JLabel titulo = new JLabel("CADASTRAR PRODUTO");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));

        painelCI.add(titulo, BorderLayout.NORTH);

        //=| Painel do centro |=============================================================================================
        // | Preencher nome |
        JLabel textoNome = new JLabel("Digite o nome do produto");
        textoNome.setFont(new Font("SansSerif", Font.BOLD, 10));

        painelCE.add(textoNome, BorderLayout.NORTH);

        preencherNome = new JTextField();
        preencherNome.setPreferredSize(new Dimension(200, 20));

        painelCE.add(preencherNome);

        // | Preencher código |
        JLabel textoCodigo = new JLabel("Digite o codigo do produto");
        textoCodigo.setFont(new Font("SansSerif", Font.BOLD, 10));

        painelCE.add(textoCodigo, BorderLayout.NORTH);

        preencherCodigo = new JTextField();
        preencherCodigo.setPreferredSize(new Dimension(200, 20));

        painelCE.add(preencherCodigo);

        // | Preencher código |
        JLabel textoPreco = new JLabel("Digite o preço do produto");
        textoPreco.setFont(new Font("SansSerif", Font.BOLD, 10));

        painelCE.add(textoPreco, BorderLayout.NORTH);

        preencherPreco = new JTextField();
        preencherPreco.setPreferredSize(new Dimension(200, 20));

        painelCE.add(preencherPreco);

        // | Botão de confirmação |
        botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setSize(80, 30);

        botaoConfirmar.addActionListener(this);

        painelCE.add(botaoConfirmar);

        // | Botão de voltar |
        botaoVoltar = new JButton("   Voltar   ");
        botaoVoltar.setSize(80, 30);

        botaoVoltar.addActionListener(this);

        painelCE.add(botaoVoltar);

        // | visible |
        frame.setVisible(true);

    }

//=| Métodos |==========================================================================================================

    public boolean isPreenchido() throws CNPException {
        String nome = preencherNome.getText();
        String codigo = preencherCodigo.getText();
        String preco = preencherPreco.getText();

        if (!nome.equals("") && !codigo.equals("") && !preco.equals("")) {
            return true;
        } else {
            throw new CNPException();
        }
    }

    public void cadastrarProduto() throws PJCException, NumberFormatException {
        String nome = preencherNome.getText().toLowerCase(Locale.ROOT);
        String codigo = preencherCodigo.getText();
        String preco = preencherPreco.getText();

        double precoD = Double.parseDouble(preco);

        gerenciador.adicionarProduto(new Produto(nome, codigo,precoD));
    }

//=| Listener |=========================================================================================================

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botaoConfirmar){
            try {
                if(isPreenchido()){
                    try {
                        cadastrarProduto();
                        frame.dispose();
                    } catch (PJCException ex) {
                        ex.janelaDeErro();
                    } catch (NumberFormatException ex){
                        JanelaDeAvisoVII vii = new JanelaDeAvisoVII();
                    }
                }
            } catch (CNPException ex) {
                ex.janelaDeErro();
            }
        } else if(e.getSource() == botaoVoltar){
            frame.dispose();
        }

    }
}
