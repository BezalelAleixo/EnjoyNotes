package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
	private JPanel pnTela;
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
		setLayout(new BorderLayout());
		
		pnTela = new JPanel();
		pnTela.setLayout(null); // Layout nulo para posicionar elementos manualmente
        pnTela.setBackground(Color.WHITE);
        
        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\cad.jpeg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());

		
		lblDados =  new JLabel("Dados Pessoais");
		lblNome = new JLabel("Nome:");
		lblSexo = new JLabel("Sexo:");
		lblDataNasc = new JLabel("Data de Nascimento:");
		tfNome = new JTextField();
		rbtMasculino = new JRadioButton();
		/*rbtMasculino.setBackground(Color.WHITE);*/
		rbtFeminino = new JRadioButton();
		/*rbtFeminino.setBackground(Color.WHITE);*/
		escolha = new ButtonGroup();
		tfDataNasc = new JTextField();
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
				
				
			
				
 // Torna os botões transparentes
		        
				tfNome.setOpaque(false);
		        tfNome.setBorder(BorderFactory.createEmptyBorder()); 
		        tfNome.setForeground(Color.BLACK);
				
		        tfDataNasc.setOpaque(false);
		        tfDataNasc.setBorder(BorderFactory.createEmptyBorder()); 
		        tfDataNasc.setForeground(Color.BLACK);
		        
		        btnContinuar.setOpaque(false);
		        btnContinuar.setContentAreaFilled(false);
		        btnContinuar.setBorderPainted(false);

		        btnVoltar.setOpaque(false);
		        btnVoltar.setContentAreaFilled(false);
		        btnVoltar.setBorderPainted(false);
		        
		        rbtFeminino.setOpaque(false);
		        rbtFeminino.setContentAreaFilled(false);
		        rbtFeminino.setBorderPainted(false);

		        rbtMasculino.setOpaque(false);
		        rbtMasculino.setContentAreaFilled(false);
		        rbtMasculino.setBorderPainted(false);
				
		
		lblDados.setBounds(310,50,250,40);
		lblNome.setBounds(150,200,110,20);
		lblSexo.setBounds(150,230,110,20);
		lblDataNasc.setBounds(150,260,190,20);
		tfNome.setBounds(540,298,140,30);
		rbtMasculino.setBounds(526,400,17,17);
		rbtFeminino.setBounds(692,400,17,17);
		tfDataNasc.setBounds(540,488,110,30);
		btnContinuar.setBounds(510,555,168,50);
		btnVoltar.setBounds(682, 555, 168, 50);
		
		//Posicionando
		/*tfNome.setBackground(Color.BLACK);
		rbtMasculino.setBackground(Color.BLACK);
		rbtFeminino.setBackground(Color.BLACK);
		tfDataNasc.setBackground(Color.BLACK);
		btnContinuar.setBackground(Color.BLACK);
		btnVoltar.setBackground(Color.BLACK);*/
		
		escolha.add(rbtMasculino);
		escolha.add(rbtFeminino);
		pnTela.add(tfNome);
		pnTela.add(tfDataNasc);
		pnTela.add(mockupLabel);
	
		pnTela.add(lblDados);
		pnTela.add(lblNome);
		pnTela.add(lblSexo);
		pnTela.add(lblDataNasc);
		
		pnTela.add(btnContinuar);
		pnTela.add(rbtMasculino);
		pnTela.add(rbtFeminino);
		
		pnTela.add(btnContinuar);
		pnTela.add(btnVoltar);
		add(pnTela);
		definirEventos();
		setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight()); // Ajusta o tamanho da janela com base na imagem
				
	}
	private void definirEventos() {
		rbtMasculino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				rbtMasculino.setOpaque(true);
				rbtMasculino.setBackground(Color.WHITE);
			}
		});
		
		rbtFeminino.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				rbtFeminino.setOpaque(true);
				rbtFeminino.setBackground(Color.WHITE);
			}
		});
		
		btnContinuar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				String n1 = tfNome.getText();
				String n2 = tfDataNasc.getText();
				if(n1.isEmpty() || n2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}else {
				setVisible(false);
				JTelaCadastro2.abre();
				}
				
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
