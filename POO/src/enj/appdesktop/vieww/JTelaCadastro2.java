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

import enj.appdesktop.model.daoo.ConexaoDAOCadastro;
import enj.appdesktop.model.daoo.ConexaoDAOCadastro02;
import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author AleixoUNI
 * @see Classe para mostrar continuação da tela de cadastro
 */
public class JTelaCadastro2 extends JFrame{
	private Container quadro;
	private JPanel pnTela;
	private JLabel lblDados, lblNome, lblSenha, lblConfSenha;
	private JTextField tfNome, tfSenha, tfConfSenha;
	private JButton btnConcluir;
	private JButton btnVoltar;
	
	public JTelaCadastro2() {
		setTitle("Cadastro");
		quadro = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
		
		lblDados = new JLabel("Dados da Conta");
		lblNome = new JLabel("Nome do Usuário:");
		lblSenha = new JLabel("Digite sua senha:");
		lblConfSenha = new JLabel("Confirmar senha:");
		tfNome = new JTextField();
		tfSenha = new JTextField();
		tfConfSenha = new JTextField();
		btnConcluir = new JButton("Concluir");
		pnTela = new JPanel();
		btnVoltar = new JButton("Cancelar");
		
		pnTela.setLayout(null);
		pnTela.setBackground(Color.WHITE);
		pnTela.setBounds(90,90,800,600);
		lblDados.setBounds(350,50,140,20);
		lblNome.setBounds(150,200,110,20);
		lblSenha.setBounds(150,230,110,20);
		lblConfSenha.setBounds(150,260,130,20);
		tfNome.setBounds(400,200,140,20);
		tfSenha.setBounds(400,230,140,20);
		tfConfSenha.setBounds(400,260,140,20);
		btnConcluir.setBounds(350,300,90,30);
		btnVoltar.setBounds(450, 300, 90, 30);
		
		pnTela.add(lblDados);
		pnTela.add(lblNome);
		pnTela.add(lblSenha);
		pnTela.add(lblConfSenha);
		pnTela.add(tfNome);
		pnTela.add(tfSenha);
		pnTela.add(tfConfSenha);
		pnTela.add(btnConcluir);
		pnTela.add(btnVoltar);
		add(pnTela);
		definirEventos();
	}
	private void definirEventos() {
		btnConcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomeUsuario, senha;
				nomeUsuario = tfNome.getText();
				senha = tfSenha.getText();
				CadastroVO usuario = new CadastroVO();
				usuario.setNomeUsuario(nomeUsuario);
				if(tfConfSenha.getText().length() == tfSenha.getText().length()) {
					usuario.setSenha(senha);
				}
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
				ConexaoDAOCadastro02 dados = new ConexaoDAOCadastro02();
				dados.ConexaoDAOCadastro(usuario);
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	JTelaCadastro.abrir();
		       
		    }
		});
	}
	public static void abre() {
		JTelaCadastro2 frame = new JTelaCadastro2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		JTelaCadastro2 frame = new JTelaCadastro2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}*/

}
