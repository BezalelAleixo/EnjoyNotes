package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enj.appdesktop.model.daoo.ConexaoDAOCadastro;
import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author AleixoUNI
 * @see Classe para tela de Cadastro
 */
public class JTelaCadastro extends JFrame{
	private Container contentpane;
	private JPanel quadro;
	private JLabel lblDados, lblNome, lblSexo, lblDataNasc;
	private ButtonGroup escolha;
	private JRadioButton rbtMasculino, rbtFeminino;
	private JTextField tfNome, tfDataNasc;
	private JButton btnContinuar;
	private JButton btnVoltar;
	
	public JTelaCadastro() {
		setTitle("Cadastro");
		contentpane = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
		
		quadro = new JPanel();
		quadro.setBackground(Color.WHITE);
		lblDados =  new JLabel("Dados Pessoais");
		lblNome = new JLabel("Nome:");
		lblSexo = new JLabel("Sexo:");
		lblDataNasc = new JLabel("Data de Nascimento:");
		tfNome = new JTextField();
		rbtMasculino = new JRadioButton("masculino");
		rbtFeminino = new JRadioButton("feminino");
		escolha = new ButtonGroup();
		tfDataNasc = new JTextField("YYYY/MM/DD");
		btnContinuar = new JButton("Continuar");
		btnVoltar = new JButton("Cancelar");
		
		quadro.setLayout(null);
		quadro.setBounds(90,90,800,600);
		lblDados.setBounds(350,50,140,20);
		lblNome.setBounds(150,200,110,20);
		lblSexo.setBounds(150,230,110,20);
		lblDataNasc.setBounds(150,260,130,20);
		tfNome.setBounds(400,200,140,20);
		rbtMasculino.setBounds(400,230,110,20);
		rbtFeminino.setBounds(510,230,110,20);
		tfDataNasc.setBounds(400,260,110,20);
		btnContinuar.setBounds(350,300,90,30);
		btnVoltar.setBounds(450, 300, 90, 30);
		
		escolha.add(rbtMasculino);
		escolha.add(rbtFeminino);
		quadro.add(lblDados);
		quadro.add(lblNome);
		quadro.add(lblSexo);
		quadro.add(lblDataNasc);
		quadro.add(tfNome);
		quadro.add(btnContinuar);
		quadro.add(rbtMasculino);
		quadro.add(rbtFeminino);
		quadro.add(tfDataNasc);
		quadro.add(btnContinuar);
		quadro.add(btnVoltar);
		add(quadro);
		definirEventos();
	}
	private void definirEventos() {
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JTelaCadastro2.abre();
				
			}
		});		
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nome, sexo = null;
				String datanasc;
				nome = tfNome.getText();
				if(rbtFeminino.isSelected()) {
					sexo = "feminino";
				}else {
					sexo = "masculino";
				}
				datanasc = tfDataNasc.getText();
				CadastroVO usuario = new CadastroVO();
				usuario.setNome(nome);
				usuario.setSexo(sexo);
				usuario.setDatanasc(datanasc);
				ConexaoDAOCadastro dados = new ConexaoDAOCadastro();
				dados.ConexaoDAOCadastro(usuario);
				
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando à tela anterior");
				dispose(); // Fecha a janela atual (tela de login)
				JTelaInicial.abreInicial();
			}
		});
	}
	public static void abrir() {
		JTelaCadastro frame = new JTelaCadastro();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		
	}
	/*public static void main(String[] args) {
		JTelaCadastro frame = new JTelaCadastro();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(frame);
			frame.setVisible(true);
	}*/
}
