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

import enj.appdesktop.model.daoo.ConexaoDAOCadastro;
import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author AleixoUNI
 * @see Classe para mostrar continuação da tela de cadastro
 */
public class JTelaCadastro2 extends JFrame{
	private Container quadro;
	private JPanel pnTela;
	private JLabel lblDados, lblNome, lblSenha, lblConfSenha;
	private JTextField tfNome;
	private JPasswordField pfSenha, pfConfSenha;
	private JButton btnConcluir;
	private JButton btnVoltar, btnVoltarInicio;
	private JCheckBox cksenha;
	private JTelaCadastro fonte;
	Font fonte1, fonte2, fonte3;
	
	public JTelaCadastro2() {
		setTitle("Cadastro");
		quadro = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
        quadro.setBackground(Color.PINK);

		
		lblDados = new JLabel("Dados da Conta");
		lblNome = new JLabel("Nome do Usuário:");
		lblSenha = new JLabel("Digite sua senha:");
		lblConfSenha = new JLabel("Confirmar senha:");
		tfNome = new JTextField();
		pfSenha = new JPasswordField();
		pfSenha.setEchoChar('*');;
		pfConfSenha = new JPasswordField();
		pfConfSenha.setEchoChar('*');
		cksenha = new JCheckBox("Mostrar Senha");
		cksenha.setBackground(Color.WHITE);
		btnConcluir = new JButton("Concluir");
		pnTela = new JPanel();
		btnVoltar = new JButton("Cancelar");
		btnVoltarInicio = new JButton("Voltar ao inicio");
		
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
		
		pnTela.setLayout(null);
		pnTela.setBackground(Color.WHITE);
		pnTela.setBounds(90,90,800,600);
		lblDados.setBounds(310,50,250,40);
		lblNome.setBounds(150,200,190,20);
		lblSenha.setBounds(150,230,190,20);
		lblConfSenha.setBounds(150,260,190,20);
		tfNome.setBounds(400,200,140,30);
		pfSenha.setBounds(400,230,140,30);
		pfConfSenha.setBounds(400,260,140,30);
		btnConcluir.setBounds(220,360,120,30);
		btnVoltar.setBounds(450,360, 120, 30);
		btnVoltarInicio.setBounds(400, 540,190,30);
		cksenha.setBounds(150, 300,140,20);
		
		pnTela.add(lblDados);
		pnTela.add(lblNome);
		pnTela.add(lblSenha);
		pnTela.add(lblConfSenha);
		pnTela.add(tfNome);
		pnTela.add(pfSenha);
		pnTela.add(pfConfSenha);
		pnTela.add(btnConcluir);
		pnTela.add(btnVoltar);
		pnTela.add(btnVoltarInicio);
		pnTela.add(cksenha);
		add(pnTela);
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
				//String nome, sexo, datanasc;
				/*CadastroVO dados = new CadastroVO();
				nome = dados.getNome();
				sexo = dados.getSexo();
				datanasc = dados.getDatanasc();*/
				CadastroVO usuario = new CadastroVO();
				
				
				usuario.setNome(JTelaCadastro.getNome());
				usuario.setSexo(JTelaCadastro.getSexo());
				usuario.setDatanasc(JTelaCadastro.getNasc());//2006/07/28
				usuario.setNomeUsuario(nomeUsuario);
				usuario.setSenha(senha);
			
				if(pfConfSenha.getText().length() == pfSenha.getText().length()) {
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
					ConexaoDAOCadastro dadosusuario = new ConexaoDAOCadastro();
					dadosusuario.ConexaoDAOCadastro(usuario);
				}else {
					JOptionPane.showMessageDialog(null, "Verifique a senha!");
				}
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
		    	JTelaCadastro.abrir();
		       
		    }
		});
		btnVoltarInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JTelaCadastro2.abreInicio();
				
				
			}
		});
	}
	public static void abre() {
		JTelaCadastro2 frame = new JTelaCadastro2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	public static void abreInicio() {
		JTelaInicial inicio = new JTelaInicial();
		inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicio.setLocationRelativeTo(inicio);
		inicio.setVisible(true);
	}
	
	/*public static void main(String[] args) {
		JTelaCadastro2 frame = new JTelaCadastro2();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}*/

}
