package enj.appdesktop.vieww;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import java.awt.BorderLayout;
import java.awt.Color;

public class JTelaCarregamento extends JWindow {
    public JTelaCarregamento() {
        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\AleixoUNI\\git\\EnjoyNotes\\b.gif"));
        getContentPane().add(imageLabel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null); // Centraliza a janela de carregamento
        setBackground(new Color(0, 0, 0, 0)); // Define o fundo da janela de carregamento como transparente
    }

    public void mostrarTelaInicial() {
        setVisible(true);
        try {
            Thread.sleep(18000); // Aguarda 3 segundos (ou o tempo necessário para o GIF ser exibido completamente)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dispose(); // Fecha a tela de carregamento
        JTelaSessoes.abrir();
    }

    public static void main(String[] args) {
        JTelaCarregamento telaCarregamento = new JTelaCarregamento();
        telaCarregamento.mostrarTelaInicial();
    }
}