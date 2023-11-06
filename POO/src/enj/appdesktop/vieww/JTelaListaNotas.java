package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

// ... (outros imports)

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;

public class JTelaListaNotas extends JPanel {
    private JTextField tfTitulo;
    private JTextArea taConteudo;
    private NotasVO nota;
    private JTelaSessoes telaSessoes; // Deixe essa declaração

    public JTelaListaNotas(NotasVO nota, JTelaSessoes telaSessoes) {
        this.nota = nota;
        this.telaSessoes = telaSessoes;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setSize(150, 150);
        setLayout(new BorderLayout());
        setBackground(new Color(0x84CAED));
    }

    private void posicionandoComponentes() {
    	
        Font fonte = new Font("Garet", Font.PLAIN, 20);
        tfTitulo = new JTextField(nota.getTitulo());
        tfTitulo.setFont(fonte);
        tfTitulo.setPreferredSize(new Dimension(150,20));
        tfTitulo.setBackground(new Color(0x84CAED));
        tfTitulo.setEditable(false);
        tfTitulo.setBorder(new LineBorder(new Color(0x84CAED)));
        
        Font fonte2 = new Font("Garet", Font.PLAIN, 17);
        taConteudo = new JTextArea(nota.getContent());
        taConteudo.setFont(fonte2);
        taConteudo.setPreferredSize(new Dimension(150,130));
        taConteudo.setBackground(new Color(0x84CAED));
        taConteudo.setEditable(false);
        taConteudo.setBorder(new LineBorder(new Color(0x84CAED)));
        

        add(tfTitulo, BorderLayout.NORTH);
        add(taConteudo, BorderLayout.CENTER);
    }

    private void definirEventos() {
        
    }

    // Restante do código...
}