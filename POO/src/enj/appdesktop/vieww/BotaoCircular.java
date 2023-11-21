package enj.appdesktop.vieww;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotaoCircular extends JFrame {
	JButtonCircular botao;
    public BotaoCircular() {
        super("Botão Circular");

        // Criação de um botão personalizado
        botao = new JButtonCircular(Color.decode("0x84CAED"));
       

        // Configurando o layout do frame para null
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando o botão ao frame
        add(botao);

        // Definindo o tamanho e a posição do botão
        botao.setBounds(50, 50, 20, 20);
       

        // Adicionando um ouvinte de ação ao botão
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        
        // Configurando o tamanho e a visibilidade do frame
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BotaoCircular();
            }
        });
    }
}

class JButtonCircular extends JButton {
	Color c;
    public JButtonCircular(Color c) {
    	this.c = c;
        setContentAreaFilled(false); // Tornar a área de conteúdo transparente para que o fundo seja visível
        setBorder(new LineBorder(Color.BLACK));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.black);
        } else {
            g.setColor(c);
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        // Adicionando uma borda ao redor do círculo
      
        

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
    	 g.setColor(Color.BLACK);
    	 g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        // Verificar se o ponto (x, y) está dentro do círculo
        int radius = Math.min(getWidth(), getHeight()) / 2;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        return Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2) <= Math.pow(radius, 2);
    }
}
