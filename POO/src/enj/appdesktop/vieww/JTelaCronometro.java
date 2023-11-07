package enj.appdesktop.vieww;

import javax.swing.*;

import enj.appdesktop.model.vo.ContaVO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JTelaCronometro extends JPanel {
	private JLabel tempoLabel;
	private JTextField minutosTextField;
	private JTextField segundosTextField;
	private Timer timer;
	private int segundos;
	private int minutosEscolhidos;
	private int segundosEscolhidos;
	private boolean telaCheia = false;
	private ContaVO conta;
    private JTelaSessoes telaSessoes;

	public JTelaCronometro(ContaVO conta, JTelaSessoes telaSessoes) {
		this.conta = conta;
        this.telaSessoes = telaSessoes;
		setLayout(null);
		setSize(1366,768);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.setBounds(0,0,1366,768);
		
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
				String nome_perfil = conta.getNome_perfil();
				telaSessoes.getContentpane().removeAll();
                JTelaMenu telaMenu = new JTelaMenu(conta, nome_perfil, telaSessoes);
                telaSessoes.getContentpane().add(telaMenu, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
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
				
			}
		});

		ImageIcon mockupImage = new ImageIcon("C:\\Users\\AleixoUNI\\git\\EnjoyNotes\\1000.png");
		JLabel mockupLabel = new JLabel(mockupImage);
		mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
		layeredPane.add(mockupLabel, JLayeredPane.DEFAULT_LAYER);

		Font fonte = new Font("Bernoru Ultra", Font.BOLD, 25);
		Font fonte2 = new Font("Bernoru Ultra", Font.BOLD, 16);

		tempoLabel = new JLabel("0 minutos, 0 segundos");
		tempoLabel.setBounds(550, 270, 500, 200);
		tempoLabel.setFont(fonte);
		tempoLabel.setForeground(new Color(25, 25, 112));
		layeredPane.add(tempoLabel, JLayeredPane.PALETTE_LAYER);

		JLabel minutosLabel = new JLabel("Minutos para estudar:");
		minutosLabel.setBounds(560, 140, 590, 50);
		minutosLabel.setFont(fonte);
		minutosLabel.setForeground(Color.WHITE);
		layeredPane.add(minutosLabel, JLayeredPane.PALETTE_LAYER);

		minutosTextField = new JTextField(10);
		minutosTextField.setBounds(515, 565, 100, 50);
		minutosTextField.setFont(fonte2);
		minutosTextField.setHorizontalAlignment(JTextField.CENTER);
		minutosTextField.setOpaque(false);
		minutosTextField.setBorder(BorderFactory.createEmptyBorder());
		minutosTextField.setForeground(new Color(25, 25, 112));
		minutosTextField.setText("min"); // Dica de preenchimento
		layeredPane.add(minutosTextField, JLayeredPane.PALETTE_LAYER);

		minutosTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (minutosTextField.getText().equals("min")) {
					minutosTextField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (minutosTextField.getText().isEmpty()) {
					minutosTextField.setText("min");
				}
			}
		});

		segundosTextField = new JTextField(10);
		segundosTextField.setBounds(740, 565, 100, 50);
		segundosTextField.setFont(fonte2);
		segundosTextField.setHorizontalAlignment(JTextField.CENTER);
		segundosTextField.setOpaque(false);
		segundosTextField.setBorder(BorderFactory.createEmptyBorder());
		segundosTextField.setForeground(new Color(25, 25, 112));
		segundosTextField.setText("seg");
		layeredPane.add(segundosTextField, JLayeredPane.PALETTE_LAYER);

		segundosTextField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (segundosTextField.getText().equals("seg")) {
					segundosTextField.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (segundosTextField.getText().isEmpty()) {
					segundosTextField.setText("seg");
				}
			}
		});

		JButton iniciarButton = new JButton();
		iniciarButton.setBounds(487, 640, 150, 50);
		iniciarButton.setContentAreaFilled(false);
		iniciarButton.setBorderPainted(false);
		layeredPane.add(iniciarButton, JLayeredPane.PALETTE_LAYER);

		JButton pararButton = new JButton();
		pararButton.setBounds(724, 640, 130, 50);
		pararButton.setContentAreaFilled(false);
		pararButton.setBorderPainted(false);
		layeredPane.add(pararButton, JLayeredPane.PALETTE_LAYER);

		JButton reiniciarButton = new JButton(new ImageIcon("C:\\Users\\AleixoUNI\\git\\EnjoyNotes\\100.png")); 
		reiniciarButton.setBounds(1235, 100, 50, 50);
		reiniciarButton.setContentAreaFilled(false);
		reiniciarButton.setBorderPainted(false);
		layeredPane.add(reiniciarButton, JLayeredPane.PALETTE_LAYER);
		add(layeredPane);

		iniciarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String minutosInput = minutosTextField.getText();
					String segundosInput = segundosTextField.getText();
					minutosInput = minutosInput.equals("min") ? "0" : minutosInput;
					segundosInput = segundosInput.equals("seg") ? "0" : segundosInput;

					minutosEscolhidos = Integer.parseInt(minutosInput);
					segundosEscolhidos = Integer.parseInt(segundosInput);
					segundos = minutosEscolhidos * 60 + segundosEscolhidos;
					atualizarLabelTempo();
					timer.start();
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(JTelaCronometro.this,
							"Por favor, insira um número válido de minutos e segundos.");
				}
			}
		});

		pararButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});

		reiniciarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Reiniciar os minutos para 0
				minutosTextField.setText("0");
				segundosTextField.setText("0");
				segundos = 0;
				atualizarLabelTempo();
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
					telaSessoes.getContentpane().removeAll();
	                JTelaMensagem telaMensagem = new JTelaMensagem(conta, telaSessoes);
	                telaSessoes.getContentpane().add(telaMensagem, BorderLayout.CENTER);
	                telaSessoes.revalidate();
	                telaSessoes.repaint();
				}
			}
		});
	}

	private void atualizarLabelTempo() {
		int minutosRestantes = segundos / 60;
		int segundosRestantes = segundos % 60;
		tempoLabel.setText(minutosRestantes + " minutos, " + segundosRestantes + " segundos");
		tempoLabel.setForeground(new Color(25, 25, 112));
	}

}