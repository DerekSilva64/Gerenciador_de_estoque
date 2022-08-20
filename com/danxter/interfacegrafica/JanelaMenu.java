package com.danxter.interfacegrafica;

import com.danxter.estoque.EstoqueVector;
import com.danxter.exceptions.AVException;
import com.danxter.exceptions.PJCException;
import com.danxter.gerenciador.Gerenciador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class JanelaMenu implements ActionListener  {

//=| Atributo e elemento do menu |======================================================================================

    Gerenciador gerenciador = new Gerenciador(new EstoqueVector());

    JFrame frame;
    JFrame frame2;

    JButton botaoCadastarProduto;
    JButton botaoRemoverProduto;
    JButton botaoPesquisarProduto;
    JButton botaoEstocarProduto;
    JButton botaoVenderProduto;
    JButton botaoListarProduto;
    JButton botaoListarProdutoEmFalta;
    JButton botaoGerarRelatorios;

    JButton botaoOk;

//=| Construtor |========================================================================================================

    public JanelaMenu(){

        try {
            gerenciador.lerRelatorio();
            gerenciador.lerRelatorioPeressivel();
        } catch (IOException | PJCException | NullPointerException ignored) {
        }

        frame = new JFrame("Aplicação bodega");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(660, 440);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        ImageIcon logo = new ImageIcon("src/br/ufc/dc/tpi/interfacegrafica/imagens/Icone.jpg");
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

        painelCI.setPreferredSize(new Dimension(100, 80));
        painelBA.setPreferredSize(new Dimension(100, 20));

        painelCI.setLayout(new FlowLayout(FlowLayout.CENTER));
        painelBA.setLayout(new FlowLayout(FlowLayout.LEADING));
        painelCE.setLayout(new FlowLayout(FlowLayout.CENTER, 500, 10));

        frame.add(painelCI, BorderLayout.NORTH);
        frame.add(painelDE, BorderLayout.WEST);
        frame.add(painelES, BorderLayout.EAST);
        frame.add(painelBA, BorderLayout.SOUTH);
        frame.add(painelCE, BorderLayout.CENTER);

        //=| Painel de cima |===============================================================================================
        JLabel titulo = new JLabel("APLICAÇÃO BODEGA");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 40));

        painelCI.add(titulo);

        //=| Painel do centro |=============================================================================================
        // | Botão de cadastrar produto |
        botaoCadastarProduto = new JButton("Cadastrar produto");
        botaoCadastarProduto.setSize(80, 30);
        botaoCadastarProduto.setFocusable(false);

        botaoCadastarProduto.addActionListener(this);

        painelCE.add(botaoCadastarProduto);

        // | Botão de remover produto |
        botaoRemoverProduto = new JButton("Remover produto ");
        botaoRemoverProduto.setSize(80, 30);
        botaoRemoverProduto.setFocusable(false);

        botaoRemoverProduto.addActionListener(this);

        painelCE.add(botaoRemoverProduto);

        // | Botão de pesquisar produto
        botaoPesquisarProduto = new JButton("Pesquisar produto");
        botaoPesquisarProduto.setSize(80, 30);
        botaoPesquisarProduto.setFocusable(false);

        botaoPesquisarProduto.addActionListener(this);

        painelCE.add(botaoPesquisarProduto);

        // | Botão de estocar produto |
        botaoEstocarProduto = new JButton("  Estocar produto  ");
        botaoEstocarProduto.setSize(80, 30);
        botaoEstocarProduto.setFocusable(false);

        botaoEstocarProduto.addActionListener(this);

        painelCE.add(botaoEstocarProduto);

        // | Botão de vender produto |
        botaoVenderProduto = new JButton("   Vender produto  ");
        botaoVenderProduto.setSize(80, 30);
        botaoVenderProduto.setFocusable(false);

        botaoVenderProduto.addActionListener(this);

        painelCE.add(botaoVenderProduto);

        // | Botão de Listar produto |
        botaoListarProduto = new JButton("   Listar produto    ");
        botaoListarProduto.setSize(80, 30);
        botaoListarProduto.setFocusable(false);

        botaoListarProduto.addActionListener(this);

        painelCE.add(botaoListarProduto);

        // | Botão de Listar produtos em falta |
        botaoListarProdutoEmFalta = new JButton("Produtos em falta ");
        botaoListarProdutoEmFalta.setSize(80, 30);
        botaoListarProdutoEmFalta.setFocusable(false);

        botaoListarProdutoEmFalta.addActionListener(this);

        painelCE.add(botaoListarProdutoEmFalta);

        // | Botão para gerar os relatorios |
        botaoGerarRelatorios = new JButton("  Gerar relatórios  ");
        botaoGerarRelatorios.setSize(80, 30);
        botaoGerarRelatorios.setFocusable(false);

        botaoGerarRelatorios.addActionListener(this);

        painelCE.add(botaoGerarRelatorios);

        frame.setVisible(true);

    }

    public void janelaRelatorio(){
        frame2 = new JFrame();

        frame2.setSize(280, 100);
        frame2.setLocationRelativeTo(null);
        frame2.setResizable(false);
        frame2.setUndecorated(true);

        frame2.setLayout(new BorderLayout());

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
        JLabel titulo = new JLabel("RELATÓRIOS CRIADOS COM SUCESSO");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelCE.add(titulo, BorderLayout.NORTH);

        //=| Botão OK |
        botaoOk = new JButton("OK");
        botaoOk.setSize(80, 20);
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(this);

        painelCE.add(botaoOk);

        //=| Visible |
        frame2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == botaoCadastarProduto){
            JanelaEscolha je = new JanelaEscolha(gerenciador);
        } else if(e.getSource() == botaoRemoverProduto){
            JanelaRemoverProduto jrp = new JanelaRemoverProduto(gerenciador);
        } else if(e.getSource() == botaoPesquisarProduto){
            JanelaPesquisarProduto jpp = new JanelaPesquisarProduto(gerenciador);
        } else if(e.getSource() == botaoEstocarProduto){
            JanelaEstocarProduto jep = new JanelaEstocarProduto(gerenciador);
        } else if(e.getSource() == botaoVenderProduto){
            JanelaVenderProduto jep = new JanelaVenderProduto(gerenciador);
        } else if(e.getSource() == botaoListarProduto){
            try {
                JanelaListaDeProdutos jlp = new JanelaListaDeProdutos(gerenciador);
            } catch (AVException ex) {
                ex.janelaDeErro();
            }
        } else if(e.getSource() == botaoListarProdutoEmFalta){
            try {
                JanelaListaDeProdutosEmFalta jlpef = new JanelaListaDeProdutosEmFalta(gerenciador);
            } catch (AVException ex) {
                ex.janelaDeErro2();
            }
        } else if(e.getSource() == botaoGerarRelatorios){
            try {
                gerenciador.gerarRelatorios();
                janelaRelatorio();
            } catch (AVException ex) {
                ex.janelaDeErro();
            } catch (IOException ex) {
            }

        }

        if(e.getSource() == botaoOk){
            frame2.dispose();
        }

    }
}
