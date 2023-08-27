package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import enj.appdesktop.model.daoo.LoginDAO;

/**
 * @author AleixoUNI
 * @see Classe para tela de Entrar no Menu Principal
 */
public class JTelaEntrar extends JFrame{
	private Container contentpane;
	private JPanel pnTela;
	private JLabel lblEntre, lblUsuario, lblSenha;
	private JTextField tfUsuario; 
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JCheckBox ckMostrar;
	Font fonte1, fonte2, fonte3;
	
	public JTelaEntrar() {
		setTitle("EnjoyNotes - Login");
		contentpane = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
        contentpane.setBackground(Color.PINK);

		
		pnTela = new JPanel();
		lblEntre = new JLabel("Entre na sua Conta");
		lblUsuario = new JLabel("Usuário:");
		lblSenha = new JLabel("Senha:");
		tfUsuario = new JTextField();
		pfSenha = new JPasswordField();
		pfSenha.setEchoChar('*');
		ckMostrar = new JCheckBox("Mostrar Senha");
		ckMostrar.setBackground(Color.WHITE);
		btnEntrar = new JButton("Entrar");
		btnVoltar = new JButton("Voltar");
		
		//Fontes
				fonte1 = new Font("Arial", Font.BOLD,30);
				fonte2 = new Font("Verdana", Font.PLAIN, 19);
				fonte3 = new Font("Verdana", Font.PLAIN, 16);
				
				//Adicionando as fontes aos componentes
				
				lblEntre.setFont(fonte1);
				lblUsuario.setFont(fonte3);
				lblSenha.setFont(fonte3);
				pfSenha.setFont(fonte3);
				tfUsuario.setFont(fonte3);
				btnEntrar.setFont(fonte2);
				btnVoltar.setFont(fonte2);
				
				
		
		pnTela.setLayout(null);
		pnTela.setBounds(90,90,800,600);
		pnTela.setBackground(Color.WHITE);
		lblEntre.setBounds(290,50,300,30);
		lblUsuario.setBounds(150,200,120,20);
		lblSenha.setBounds(150,230,190,20);
		tfUsuario.setBounds(400,200,140,30);
		pfSenha.setBounds(400,230,140,30);
		btnEntrar.setBounds(220,310,150,30);
		btnVoltar.setBounds(480, 310, 150, 30);
		ckMostrar.setBounds(150,260,150,20);
		
		pnTela.add(lblEntre);
		pnTela.add(lblUsuario);
		pnTela.add(lblSenha);
		pnTela.add(tfUsuario);
		pnTela.add(pfSenha);
		pnTela.add(btnEntrar);
		pnTela.add(btnVoltar);
		pnTela.add(ckMostrar);
		add(pnTela);
		definirEventos();
}
	private void definirEventos() {
		btnVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog( null, "Voltando à tela anterior");
		        dispose(); // Fecha a janela atual (tela de login)
		        JTelaInicial.abreInicial();
		    }
		});
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDAO dao = new LoginDAO();
				if (dao.VerificarLogin(tfUsuario.getText(), pfSenha.getText())) {
					dispose();
					JTelaEntrar.abreMenu();
				}else{
					JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreta!");
				};
				
			}
		});
		ckMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ckMostrar.isSelected()) {
					pfSenha.setEchoChar((char)0);
				}else {
					pfSenha.setEchoChar('*');
				}
				
			}
		});
	}
	public static void abre() {
		JTelaEntrar frame = new JTelaEntrar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	public static void abreMenu() {
		JTelaMenu menu = new JTelaMenu();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLocationRelativeTo(menu);
		menu.setVisible(true);
	}
	/*public static void main(String[] args) {
		JTelaEntrar frame = new JTelaEntrar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}*/
}