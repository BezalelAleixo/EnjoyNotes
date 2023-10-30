package enj.appdesktop.vieww;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTelaMensagem extends JFrame {
    public JTelaMensagem() {
        setTitle("Mensagem do Usuário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

		setUndecorated(true); // Remover a barra de título padrão
		getRootPane().setWindowDecorationStyle(JRootPane.NONE); // Remover a decoração padrão do sistema


        JLabel gifLabel = new JLabel(new ImageIcon("C:\\Users\\Aland\\OneDrive\\Documentos\\LUAN\\oi.gif")); // Substitua pelo caminho do seu GIF
        getContentPane().add(gifLabel);
        gifLabel.setBounds(0, 0, gifLabel.getWidth(), gifLabel.getHeight());

        JButton voltarButton = new JButton("Voltar");
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
				JTelaMensagem.abrirRelogio();
            }
        });
        
        getContentPane().add(voltarButton, BorderLayout.SOUTH);
        setSize(gifLabel.getWidth(), gifLabel.getHeight());
        setContentPane(getContentPane());
        
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void abrirRelogio() {
		JTelaCronometro frame = new JTelaCronometro();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);

	}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTelaMensagem mensagem = new JTelaMensagem();
                mensagem.setVisible(true);
            }
        });
    }
}
