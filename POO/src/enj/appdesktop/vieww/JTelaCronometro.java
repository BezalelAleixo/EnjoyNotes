package enj.appdesktop.vieww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTelaCronometro extends JFrame {
    private JLabel tempoLabel;
    private JTextField minutosTextField;
    private Timer timer;
    private int segundos;
    private int minutosEscolhidos;
    private boolean telaCheia = false;

    public JTelaCronometro() {
        setTitle("Cronômetro");
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1366,768);
        setUndecorated(telaCheia);  // Remove as bordas da janela em tela cheia
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(getContentPane());

        // Usar um JLayeredPane para posicionar os elementos em cima da imagem
        JLayeredPane layeredPane = new JLayeredPane();
        setContentPane(layeredPane);
        
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        
     // Botões
        JButton closeButton = new JButton();
        closeButton.setBounds(1300, 10, 50, 50);
        layeredPane.add(closeButton);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JButton voltarButton = new JButton();
        voltarButton.setBounds(1160, 10, 50, 50);
        layeredPane.add(voltarButton);
        voltarButton.setContentAreaFilled(false);
        voltarButton.setBorderPainted(false);
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Voltando à tela anterior");
                setVisible(false);
               
            }
        });

        JButton minimizeButton = new JButton();
        minimizeButton.setBounds(1235, 10, 50, 50);
        layeredPane.add(minimizeButton);
        minimizeButton.setContentAreaFilled(false);
        minimizeButton.setBorderPainted(false);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });


        ImageIcon mockupImage = new ImageIcon("C:\\Users\\AleixoUNI\\git\\EnjoyNotes\\1000.png");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
        layeredPane.add(mockupLabel, JLayeredPane.DEFAULT_LAYER);
        
        Font fonte = new Font("Verdana", Font.BOLD, 20);


        tempoLabel = new JLabel("0 minutos, 0 segundos");
        tempoLabel.setBounds(550, 270, 500, 200);
        tempoLabel.setFont(fonte);
        tempoLabel.setForeground(new Color(25,25,112));
        layeredPane.add(tempoLabel, JLayeredPane.PALETTE_LAYER);

        JLabel minutosLabel = new JLabel("Minutos para estudar:");
        minutosLabel.setBounds(570, 150, 550, 20);
        minutosLabel.setFont(fonte);
        minutosLabel.setForeground(Color.WHITE);
        layeredPane.add(minutosLabel, JLayeredPane.PALETTE_LAYER);

        minutosTextField = new JTextField(10);
        minutosTextField.setBounds(630, 555, 100, 50);
        minutosTextField.setFont(fonte);
        minutosTextField.setHorizontalAlignment(JTextField.CENTER);
        minutosTextField.setOpaque(false);
        minutosTextField.setBorder(BorderFactory.createEmptyBorder());
        minutosTextField.setForeground(new Color(25,25,112));
        layeredPane.add(minutosTextField, JLayeredPane.PALETTE_LAYER);

        JButton iniciarButton = new JButton();
        iniciarButton.setBounds(515, 617, 130, 50);
        iniciarButton.setContentAreaFilled(false);
        iniciarButton.setBorderPainted(false);

        layeredPane.add(iniciarButton, JLayeredPane.PALETTE_LAYER);

        JButton pararButton = new JButton();
        pararButton.setBounds(720, 617, 130, 50);
        pararButton.setContentAreaFilled(false);
        pararButton.setBorderPainted(false);
        layeredPane.add(pararButton, JLayeredPane.PALETTE_LAYER);


        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    minutosEscolhidos = Integer.parseInt(minutosTextField.getText());
                    segundos = minutosEscolhidos * 60;
                    atualizarLabelTempo();
                    timer.start();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(JTelaCronometro.this, "Por favor, insira um número válido de minutos.");
                }
            }
        });

        pararButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos--;
                if (segundos >= 0) {
                    atualizarLabelTempo();
                } else {
                    timer.stop();
                    JTelaMensagem mensagem = new JTelaMensagem();
                    mensagem.setVisible(true);
                }
            }
        });
    }

    private void atualizarLabelTempo() {
        int minutosRestantes = segundos / 60;
        int segundosRestantes = segundos % 60;
        tempoLabel.setText(minutosRestantes + " minutos, " + segundosRestantes + " segundos");
        tempoLabel.setForeground(new Color(25,25,112));

    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTelaCronometro telaCronometro = new JTelaCronometro();
                telaCronometro.setVisible(true);
            }
        });
    }
}
