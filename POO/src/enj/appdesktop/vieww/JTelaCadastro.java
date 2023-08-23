package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
	private static JRadioButton rbtMasculino, rbtFeminino;
	private static JTextField tfNome, tfDataNasc;
	private JButton btnContinuar;
	private JButton btnVoltar;
	Font fonte1, fonte2, fonte3;
	private String nome, sexo, dataN;
	private String n,s,dn;
	
	public JTelaCadastro() {
		setTitle("Cadastro");
		contentpane = getContentPane();
		setLayout(null);
		setBounds(0,0,1000,800);
        contentpane.setBackground(Color.PINK);

		
		quadro = new JPanel();
		quadro.setBackground(Color.WHITE);
		lblDados =  new JLabel("Dados Pessoais");
		lblNome = new JLabel("Nome:");
		lblSexo = new JLabel("Sexo:");
		lblDataNasc = new JLabel("Data de Nascimento:");
		tfNome = new JTextField();
		rbtMasculino = new JRadioButton("masculino");
		rbtMasculino.setBackground(Color.WHITE);
		rbtFeminino = new JRadioButton("feminino");
		rbtFeminino.setBackground(Color.WHITE);
		escolha = new ButtonGroup();
		tfDataNasc = new JTextField("YYYY/MM/DD");
		btnContinuar = new JButton("Continuar");
		btnVoltar = new JButton("Voltar");
		
		
				//Fontes
				fonte1 = new Font("Arial", Font.BOLD,30);
				fonte2 = new Font("Verdana", Font.PLAIN, 19);
				fonte3 = new Font("Verdana", Font.PLAIN, 16);
				
				//Adicionando as fontes aos componentes
				
				lblDados.setFont(fonte1);
				btnContinuar.setFont(fonte2);
				btnVoltar.setFont(fonte2);
				lblNome.setFont(fonte3);
				lblSexo.setFont(fonte3);
				lblDataNasc.setFont(fonte3);
				tfNome.setFont(fonte3);
				rbtFeminino.setFont(fonte3);
				rbtMasculino.setFont(fonte3);
				tfDataNasc.setFont(fonte3);
				
		quadro.setLayout(null);
		quadro.setBounds(90,90,800,600);
		lblDados.setBounds(310,50,250,40);
		lblNome.setBounds(150,200,110,20);
		lblSexo.setBounds(150,230,110,20);
		lblDataNasc.setBounds(150,260,190,20);
		tfNome.setBounds(400,200,140,30);
		rbtMasculino.setBounds(400,230,110,20);
		rbtFeminino.setBounds(510,230,110,20);
		tfDataNasc.setBounds(400,260,110,30);
		btnContinuar.setBounds(220,350,140,30);
		btnVoltar.setBounds(450, 350, 140, 30);
		
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
		/*btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				n= tfNome.getText();
				if(rbtFeminino.isSelected()) {
					s = "feminino";
				}else {
					s = "masculino";
				}
				dn = tfDataNasc.getText();

				
				
			}
		});*/
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando à tela anterior");
				dispose(); // Fecha a janela atual (tela de login)
				JTelaInicial.abreInicial();
			}
		});
	}
	public static String getNome() {
		String n = tfNome.getText();
		return n;
	}
	//public void setSexo(String sexo) {
	//	this.sexo = sexo;
	//}
	public static String getSexo() {
		String s;
		if(rbtFeminino.isSelected()) {
			s = "feminino";
		}else {
			s = "masculino";
		}
		return s;
	}
	//public void setNasc(String Nasc) {
	//	this.dataN = Nasc;
	//}
	public static String getNasc() {
		String dn = tfDataNasc.getText();
		return dn;
		
	}
	//public void setNome(String nome) {
	//	this.nome = nome;
	//}
	

	
	
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
