package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JTelaMenu extends JFrame {
	private Container contentPane;
	private JPanel panel;
	private JLabel lblTitulo;
	private JButton btnCriarLista, btnCriarNota, btnSair;

	public JTelaMenu() {
		setTitle(" Menu");
		contentPane = getContentPane();
		setLayout(null);
		setBounds(0, 0, 1000, 800);
		contentPane.setBackground(Color.PINK);

		panel = new JPanel();
		lblTitulo = new JLabel("Bem vindo, escolha o que fazer:");
		btnCriarLista = new JButton("Criar Lista");
		btnCriarNota = new JButton("Criar Notas");
		btnSair = new JButton("Sair");
		panel.setLayout(null);
		panel.setBounds(100, 100, 800, 600);
		lblTitulo.setBounds(300, 30, 250, 50);
		btnCriarLista.setBounds(30, 200, 100, 30);
		btnCriarNota.setBounds(150, 200, 120, 30);
		btnSair.setBounds(350, 500, 100,30);
		
		int panelWidth = panel.getWidth();
        int btnWidth = btnCriarLista.getWidth();
        int btnX = (panelWidth - btnWidth) / 2;
        btnCriarLista.setBounds(btnX, 200, 100, 30);

        btnWidth = btnCriarNota.getWidth();
        btnX = (panelWidth - btnWidth) / 2;
        btnCriarNota.setBounds(btnX, 240, 120, 30);
		
		
		

		
		 btnCriarLista.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, "Abrindo Lista");
	            	dispose();
	            	JTelaMenu.abreTelaListas();
	                

	               }
	        });
		 
		 btnCriarNota.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, "Abrindo Notas");
	            	dispose();
	            	JTelaMenu.abreTelaNotas();
	                

	               }
	        });
		 btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		 
		 
		panel.add(lblTitulo);
		panel.add(btnCriarLista);
		panel.add(btnCriarNota);
		panel.add(btnSair);
		contentPane.add(panel);
		
		  }

	

	





public static void abreTelaListas() {
		JTelaListas frame = new JTelaListas();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}

public static void abreTelaNotas() {
	JTelaNotas frame = new JTelaNotas();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
}

public static void main(String[] args) {
	JTelaMenu frame = new JTelaMenu();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}
}
