package UI;

import javax.swing.*;

import Controle.ControladorJogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMenu {
    PrincipalPainel painel;

    public void atualizar(){
        painel.repaint();
    }

    public void trocarJogador(){
        painel.trocarJogador();
    }

    public void definirVencedor(int vencedor){
        painel.definirVencedor(vencedor);
    }

    public IMenu(ControladorJogo controladorJogo){
        JFrame frame = new JFrame("Menu do Jogo Mancala"); //Configurações da janela

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        painel = new PrincipalPainel(controladorJogo);
        painel.setLocation(10, 10);
        painel.setSize(new Dimension(800, 700));

        frame.add(painel);

        JMenuBar menuBar = new JMenuBar(); //barra de menu

        JMenu jogoMenu = new JMenu("Jogo");

        JMenuItem novoJogoItem = new JMenuItem("Novo Jogo"); //Itens adicionados na barra de menu
        JMenuItem sobreJogo = new JMenuItem("Sobre"); //Itens adicionados na barra de menu
        JMenuItem sairItem = new JMenuItem("Sair");

        novoJogoItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Novo jogo iniciado");
                
            }
        });

        sobreJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, ColetorDeString.funcionamentoJogo());
                
            }
        });

        sairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jogoMenu.add(novoJogoItem);
        jogoMenu.addSeparator();
        jogoMenu.add(sobreJogo);
        jogoMenu.addSeparator();
        jogoMenu.add(sairItem);

        menuBar.add(jogoMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        
    }

class PrincipalPainel extends JPanel {

    ControladorJogo controladorJogo;
    int jogadorAtual = 1;

    int vencedor = 0;

    
    public PrincipalPainel(ControladorJogo controlador) {
        this.controladorJogo = controlador;
    }

    public void definirVencedor(int vencedor){
        this.vencedor = vencedor;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Set background color
        setBackground(new Color(255, 228, 181));

        // Draw top row of pits
        for (int i = 0; i < 6; i++) {
            g.setColor(new Color(255, 165, 0));
            g.fillRoundRect(140 + i * 100, 100, 80, 80, 50, 50);
            g.setColor(new Color(0, 128, 0));
            for (int j = 0; j < controladorJogo.getF1().getFazenda().getCasa(7 - (i + 1)).getQuantidadeSementes(); j++) {
                g.fillOval(150 + i * 100 + (j % 4) * 15, 110 + (j / 4) * 15, 10, 10);
            }
            if ((jogadorAtual == 1 && vencedor != 2)  || vencedor == 1 || vencedor == 3){
                
                if (vencedor == 1) {
                    g.setColor(new Color(0, 128, 0));
                } else if (vencedor == 3) {
                    g.setColor(new Color(255, 255, 0));
                } else {
                    g.setColor(new Color(100, 160, 180));
                }

                Font font = new Font("Arial", Font.BOLD, 30);
                g.setFont(font);
                g.drawString(Integer.toString(7 - i - 1), 170 + i * 100, 85);
            }
        }

        if ((jogadorAtual == 1 && vencedor != 2)  || vencedor == 1 || vencedor == 3){
            g.drawString("Fazendeiro 1", 350, 40);
        }

        // Draw bottom row of pits
        for (int i = 0; i < 6; i++) {
            g.setColor(new Color(255, 165, 0));
            g.fillRoundRect(140 + i * 100, 220, 80, 80, 50, 50);
            g.setColor(new Color(0, 128, 0));
            for (int j = 0; j < controladorJogo.getF2().getFazenda().getCasa(i + 1).getQuantidadeSementes(); j++) {
                g.fillOval(150 + i * 100 + (j % 4) * 15, 230 + (j / 4) * 15, 10, 10);
            }
            if ((jogadorAtual == 2 && vencedor != 1) || vencedor == 2 || vencedor == 3){
                if (vencedor == 2) {
                    g.setColor(new Color(0, 128, 0));
                } else if (vencedor == 3) {
                    g.setColor(new Color(255, 255, 0));
                } else {
                    g.setColor(new Color(100, 160, 180));
                }
                Font font = new Font("Arial", Font.BOLD, 30);
                g.setFont(font);
                g.drawString(Integer.toString(i + 1), 170 + i * 100, 340);
            }
        }

        if ((jogadorAtual == 2 && vencedor != 1) || vencedor == 2 || vencedor == 3){
            g.drawString("Fazendeiro 2", 350, 385);
        }

        // Draw top Kalah
        g.setColor(new Color(255, 140, 0));
        g.fillRoundRect(40, 100, 80, 200, 50, 50);
        g.setColor(new Color(0, 128, 0));
        for (int i = 0; i < controladorJogo.getF1().getFazenda().getSilo().getQuantidadeSementes(); i++) {
            g.fillOval(50 + (i % 4) * 15, 110 + (i / 4) * 15, 10, 10);
        }

        // Draw bottom Kalah
        g.setColor(new Color(255, 140, 0));
        g.fillRoundRect(740, 100, 80, 200, 50, 50);
        g.setColor(new Color(0, 128, 0));
        for (int i = 0; i < controladorJogo.getF2().getFazenda().getSilo().getQuantidadeSementes(); i++) {
            g.fillOval(750 + (i % 4) * 15, 110 + (i / 4) * 15, 10, 10);
        }
    }

    public void trocarJogador(){
        jogadorAtual = jogadorAtual == 1 ? 2 : 1;
    }

}

}