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
		setLayout(new BorderLayout()); 

		
		pnTela = new JPanel();
		pnTela.setLayout(null); // Layout nulo para posicionar elementos manualmente
        pnTela.setBackground(Color.WHITE);
		
      //aqui ele puxa a imagem tela.png que ta no pacote
        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\login.png");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
        
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
				
				//lblEntre.setFont(fonte1);
				//lblUsuario.setFont(fonte3);
				//lblSenha.setFont(fonte3);
				pfSenha.setFont(fonte3);
				tfUsuario.setFont(fonte3);
				//btnEntrar.setFont(fonte2);
				//btnVoltar.setFont(fonte2);
				
				
		
		
		
		
				lblEntre.setBounds(350, 50, 150, 20);
		        lblUsuario.setBounds(250, 200, 110, 20);
		        lblSenha.setBounds(150, 230, 110, 20);
		        tfUsuario.setBounds(550, 300, 240, 20);
		        pfSenha.setBounds(550, 400, 240, 20);
		        btnEntrar.setBounds(610, 479, 130, 30);
		        btnVoltar.setBounds(610, 550, 120, 30);
		        ckMostrar.setBounds(550,430,150,20);
		        
		     // Torna os botões transparentes
		        
		        tfUsuario.setOpaque(false);
		        tfUsuario.setBorder(BorderFactory.createEmptyBorder()); 
		        tfUsuario.setForeground(Color.BLACK);
		        
		        pfSenha.setOpaque(false);
		        pfSenha.setBorder(BorderFactory.createEmptyBorder()); 
		        pfSenha.setForeground(Color.BLACK);
		        
		        btnEntrar.setOpaque(false);
		        btnEntrar.setContentAreaFilled(false);
		        btnEntrar.setBorderPainted(false);

		        btnVoltar.setOpaque(false);
		        btnVoltar.setContentAreaFilled(false);
		        btnVoltar.setBorderPainted(false);
		
		
		        pnTela.add(tfUsuario);
				pnTela.add(pfSenha);        
				pnTela.add(mockupLabel); // Adiciona a imagem como plano de fundo
				pnTela.add(lblEntre);
				pnTela.add(lblUsuario);
				pnTela.add(lblSenha);
		
				pnTela.add(btnEntrar);
				pnTela.add(btnVoltar);
				pnTela.add(ckMostrar);
				add(pnTela);
		
		definirEventos();
		
		setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight()); // Ajusta o tamanho da janela com base na imagem
		
}
	private void definirEventos() {
		btnVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog( null, "Voltando à tela anterior");
		    	setVisible(false); // Fecha a janela atual (tela de login)
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
				int numero = 1;
				
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
		JTelaEntrar f = new JTelaEntrar();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(f);   
        f.setVisible(true);
		 
		
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