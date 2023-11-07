package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.UsuarioVO;

/**
 * @author AleixoUNI
 * @see Classe para mostrar continuação da tela de cadastro
 */
public class JTelaCadastro2 extends JPanel{
	private Container quadro;
	private JPanel pnTela;
	private JLabel lblDados, lblNome, lblSenha, lblConfSenha;
	private JTextField tfNome;
	private JPasswordField pfSenha, pfConfSenha;
	private JButton btnConcluir;
	private JButton btnVoltar, btnVoltarInicio;
	private JCheckBox cksenha;
	Font fonte1, fonte2, fonte3;
	private JTelaSessoes telaSessoes;
	private String nome;
	private String sexo;
	private String dataNasc;
	
	
	public JTelaCadastro2(JTelaSessoes telaSessoes, String nome, String sexo, String dataNasc) {
		this.telaSessoes = telaSessoes;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNasc = dataNasc;

	
		
	
		setLayout(null); // Layout nulo para posicionar elementos manualmente
		setSize(1366,768);
        
        ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\4300.jpg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());


		
		lblDados = new JLabel("");
		lblNome = new JLabel("");
		lblSenha = new JLabel("");
		lblConfSenha = new JLabel("");
		tfNome = new JTextField();
		pfSenha = new JPasswordField();
		pfSenha.setEchoChar('*');
		pfConfSenha = new JPasswordField();
		pfConfSenha.setEchoChar('*');
		cksenha = new JCheckBox("");
	    cksenha.setBorder(BorderFactory.createEmptyBorder()); 
		btnConcluir = new JButton("");
		btnVoltar = new JButton("");
		btnVoltarInicio = new JButton("");
		
		//Fontes
		fonte1 = new Font("Arial", Font.BOLD,30);
		fonte2 = new Font("Verdana", Font.PLAIN, 19);
		fonte3 = new Font("Verdana", Font.PLAIN, 16);
		
		//Adicionando as fontes aos componentes
		
		lblDados.setFont(fonte1);
		lblNome.setFont(fonte3);
		btnVoltar.setFont(fonte2);
		lblSenha.setFont(fonte3);
		lblConfSenha.setFont(fonte3);
		tfNome.setFont(fonte3);
		pfConfSenha.setFont(fonte3);
		pfSenha.setFont(fonte3);
		btnVoltar.setFont(fonte2);
		btnVoltarInicio.setFont(fonte2);
		btnConcluir.setFont(fonte2);
		
		// Torna os botões transparentes
		
		tfNome.setOpaque(false);
        tfNome.setBorder(BorderFactory.createEmptyBorder()); 
        tfNome.setForeground(Color.BLACK);
        
        pfSenha.setOpaque(false);
        pfSenha.setBorder(BorderFactory.createEmptyBorder()); 
        pfSenha.setForeground(Color.BLACK);
        
        pfConfSenha.setOpaque(false);
        pfConfSenha.setBorder(BorderFactory.createEmptyBorder()); 
        pfConfSenha.setForeground(Color.BLACK);
		
		btnConcluir.setOpaque(false);
        btnConcluir.setContentAreaFilled(false);
        btnConcluir.setBorderPainted(false);

        btnVoltar.setOpaque(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorderPainted(false);
		
		btnVoltarInicio.setOpaque(false);
	    btnVoltarInicio.setContentAreaFilled(false);
	    btnVoltarInicio.setBorderPainted(false);
	        
	    cksenha.setOpaque(false);
	    cksenha.setContentAreaFilled(false);
	    cksenha.setBorderPainted(false); 
	

		lblDados.setBounds(310,50,250,40);
		lblNome.setBounds(150,200,190,20);
		lblSenha.setBounds(150,230,190,20);
		lblConfSenha.setBounds(150,260,190,20);
		tfNome.setBounds(535,285,300,30);
		pfSenha.setBounds(535,375,300,30);
		pfConfSenha.setBounds(535,465,300,30);
		cksenha.setBounds(534,504,300,30);
		btnConcluir.setBounds(519,550,149,50);
		btnVoltar.setBounds(686,550, 149, 50);	
		btnVoltarInicio.setBounds(615,628,140,50);

		//Posicionando
				/*tfNome.setBackground(Color.BLACK);
				pfSenha.setBackground(Color.BLACK);
				pfConfSenha.setBackground(Color.BLACK);
				btnConcluir.setBackground(Color.BLACK);
				btnVoltar.setBackground(Color.BLACK);*/
		
		
		add(tfNome);
		add(pfSenha);
		add(pfConfSenha);
		add(mockupLabel);
		add(lblDados);
		add(lblNome);
		add(lblSenha);
		add(lblConfSenha);
		add(btnConcluir);
		add(btnVoltar);
		add(btnVoltarInicio);
		add(cksenha);
		
		definirEventos();
		
	}
	private void definirEventos() {
		btnConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario, senha, consenha;
				nomeUsuario = tfNome.getText();
				senha = pfSenha.getText();
				consenha = pfConfSenha.getText();
				if(nomeUsuario.isEmpty() || senha.isEmpty() || consenha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}else {
				
				}
				if(pfConfSenha.getText().length() == pfSenha.getText().length()) {
					UsuarioVO usuario = new UsuarioVO(nome, sexo, dataNasc);
					telaSessoes.getContentpane().removeAll();
		            JTelaSelecionarFoto foto = new JTelaSelecionarFoto(telaSessoes, usuario, nomeUsuario, senha);
		            telaSessoes.getContentpane().add(foto, BorderLayout.CENTER);
		            telaSessoes.revalidate();
		            telaSessoes.repaint();
					
				}else {
					JOptionPane.showMessageDialog(null, "Verifique a senha!");
				}
				
			}
		});
		cksenha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cksenha.isSelected()) {
					pfConfSenha.setEchoChar((char)0);
					pfSenha.setEchoChar((char)0);
				}else {
					pfConfSenha.setEchoChar('*');
					pfSenha.setEchoChar('*');
				}
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	
				telaSessoes.getContentpane().removeAll();
	            JTelaCadastro cadastro = new JTelaCadastro(telaSessoes);
	            telaSessoes.getContentpane().add(cadastro, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
		       
		    }
		});
		btnVoltarInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				telaSessoes.getContentpane().removeAll();
	            JTelaInicial inicio = new JTelaInicial(telaSessoes);
	            telaSessoes.getContentpane().add(inicio, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
				
			}
		});
	}
	
}