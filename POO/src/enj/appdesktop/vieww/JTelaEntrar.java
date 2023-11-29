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

import enj.appdesktop.controller.ContaController;
import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.controller.UsuarioController;
import enj.appdesktop.model.daoo.LoginDAO;
import enj.appdesktop.model.vo.ContaVO;


/**
 * @author AleixoUNI
 * @see Classe para tela de Entrar no Menu Principal
 */
public class JTelaEntrar extends JPanel {
	private Container contentpane;
	private JPanel pnTela;
	private static JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnEntrar;
	private JButton btnVoltar;
	private JCheckBox ckMostrar;
	Font fonte1, fonte2, fonte3;
	private JTelaSessoes telaSessoes;
	
	public JTelaEntrar(JTelaSessoes telaSessoes) {
		this.telaSessoes = telaSessoes;
		

		setLayout(null); // Layout nulo para posicionar elementos manualmente
	

		// aqui ele puxa a imagem tela.png que ta no pacote
		ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\2300.jpg");
		JLabel mockupLabel = new JLabel(mockupImage);
		mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());

		tfUsuario = new JTextField();
		pfSenha = new JPasswordField();
		pfSenha.setEchoChar('*');
		ckMostrar = new JCheckBox("");
		ckMostrar.setOpaque(false);
		ckMostrar.setBorder(BorderFactory.createEmptyBorder());
		btnEntrar = new JButton("");
		btnVoltar = new JButton("");

		// Fontes
		fonte1 = new Font("Arial", Font.BOLD, 30);
		fonte2 = new Font("Verdana", Font.PLAIN, 19);
		fonte3 = new Font("Verdana", Font.PLAIN, 16);

		// Adicionando as fontes aos componentes

		// lblEntre.setFont(fonte1);
		// lblUsuario.setFont(fonte3);
		// lblSenha.setFont(fonte3);
		pfSenha.setFont(fonte3);
		tfUsuario.setFont(fonte3);
		// btnEntrar.setFont(fonte2);
		// btnVoltar.setFont(fonte2);

		tfUsuario.setBounds(535, 298, 300, 30);
		pfSenha.setBounds(535, 394, 300, 30);
		btnEntrar.setBounds(604, 510, 149, 50);
		btnVoltar.setBounds(604, 575, 149, 50);
		ckMostrar.setBounds(538, 442, 150, 20);

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

		add(tfUsuario);
		add(pfSenha);
		add(mockupLabel); 
		add(btnEntrar);
		add(btnVoltar);
		add(ckMostrar);
		

		definirEventos();
		add(mockupLabel);
		
	}

	private void definirEventos() {
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaSessoes.getContentpane().removeAll();
	            JTelaInicial inicio = new JTelaInicial(telaSessoes);
	            telaSessoes.getContentpane().add(inicio, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
			}
		});
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDAO dao = new LoginDAO();
				if (dao.VerificarLogin(tfUsuario.getText(), pfSenha.getText())) {
					String nome_perfil = tfUsuario.getText();
					UsuarioController usuario = new UsuarioController();
					usuario.BuscarID_conta(nome_perfil);
					int id_conta = usuario.getID_CONTA();
					SessaoController sessao = new SessaoController();
					sessao.atualizarSessao("L", id_conta);
					
					ContaController conta = new ContaController();
					conta.ContaBuscada(id_conta);
					ContaVO minhaConta = conta.ContaMMinha();
					
					telaSessoes.getContentpane().removeAll();
		            JTelaMenu menu = new JTelaMenu(minhaConta, nome_perfil, telaSessoes);
		            telaSessoes.getContentpane().add(menu, BorderLayout.CENTER);
		            telaSessoes.revalidate();
		            telaSessoes.repaint();
					
				} else {
					JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreta!");
				}	
				
			}
		});
		ckMostrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ckMostrar.isSelected()) {
					pfSenha.setEchoChar((char) 0);
				} else {
					pfSenha.setEchoChar('*');
				}

			}
		});
	}
	
	public static String getNome() {
		String n = tfUsuario.getText();
		return n;
	}

}