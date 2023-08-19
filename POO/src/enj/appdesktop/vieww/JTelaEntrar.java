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
	private JTextField tfUsuario, tfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	
	public JTelaEntrar() {
		setTitle("EnjoyNotes - Login");
		contentpane = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
		
		pnTela = new JPanel();
		lblEntre = new JLabel("Entre na sua Conta");
		lblUsuario = new JLabel("Usuário:");
		lblSenha = new JLabel("Senha:");
		tfUsuario = new JTextField();
		tfSenha = new JTextField();
		btnEntrar = new JButton("Entrar");
		btnVoltar = new JButton("Cancelar");
		
		pnTela.setLayout(null);
		pnTela.setBounds(90,90,800,600);
		pnTela.setBackground(Color.WHITE);
		lblEntre.setBounds(350,50,150,20);
		lblUsuario.setBounds(150,200,110,20);
		lblSenha.setBounds(150,230,110,20);
		tfUsuario.setBounds(400,200,140,20);
		tfSenha.setBounds(400,230,140,20);
		btnEntrar.setBounds(350,270,120,30);
		btnVoltar.setBounds(480, 270, 120, 30);
		
		pnTela.add(lblEntre);
		pnTela.add(lblUsuario);
		pnTela.add(lblSenha);
		pnTela.add(tfUsuario);
		pnTela.add(tfSenha);
		pnTela.add(btnEntrar);
		pnTela.add(btnVoltar);
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
				if (dao.VerificarLogin(tfUsuario.getText(), tfSenha.getText())) {
					new testPrincipal().setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Senha incorreta!");
				};
				
			}
		});
		
	}
	public static void abre() {
		JTelaEntrar frame = new JTelaEntrar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	/*public static void main(String[] args) {
		JTelaEntrar frame = new JTelaEntrar();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}*/
}