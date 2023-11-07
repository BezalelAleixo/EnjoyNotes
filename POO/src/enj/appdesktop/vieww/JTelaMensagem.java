package enj.appdesktop.vieww;

import javax.swing.*;

import enj.appdesktop.model.vo.ContaVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTelaMensagem extends JPanel {
	private ContaVO conta;
    private JTelaSessoes telaSessoes;
    public JTelaMensagem(ContaVO conta, JTelaSessoes telaSessoes) {
    	this.conta = conta;
        this.telaSessoes = telaSessoes;

        Icon gifIcon = new ImageIcon("C:\\Users\\AleixoUNI\\git\\EnjoyNotes\\a.gif");
        JLabel gifLabel = new JLabel(gifIcon);
        gifLabel.setBounds(0,0,1366,768);
        
       

        JButton voltarButton = new JButton();
        
        voltarButton.setContentAreaFilled(false);
        voltarButton.setBorderPainted(false);
        voltarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	telaSessoes.getContentpane().removeAll();
	            JTelaCronometro cronometro = new JTelaCronometro(conta, telaSessoes);
	            telaSessoes.getContentpane().add(cronometro, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
            }
        });

        // Defina o layout para null para posicionar o botão manualmente
        setLayout(null);
        add(gifLabel);
        add(voltarButton);
        voltarButton.setBounds(445, 600, 350, 120); 
        
        setVisible(true);
    }




}