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



/**
 * @author AleixoUNI
 * @see Classe para tela de Cadastro
 */
public class JTelaCadastro extends JPanel {
	private Container contentpane;
	private JPanel pnTela;
	private ButtonGroup escolha;
	private static JRadioButton rbtMasculino, rbtFeminino;
	private static JTextField tfNome, tfDataNasc;
	private JButton btnContinuar;
	private JButton btnVoltar;
	Font fonte1, fonte2, fonte3;
	private String n2;
	private JTelaSessoes telaSessoes;
	public JTelaCadastro(JTelaSessoes telaSessoes) {
		this.telaSessoes = telaSessoes;
		

		
		setLayout(null); // Layout nulo para posicionar elementos manualmente
		

		ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\3300.jpg");
		JLabel mockupLabel = new JLabel(mockupImage);
		mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());

		tfNome = new JTextField();
		rbtMasculino = new JRadioButton();
		rbtFeminino = new JRadioButton();
		escolha = new ButtonGroup();
		tfDataNasc = new JTextField();
		btnContinuar = new JButton("          ");
		btnVoltar = new JButton("           ");

		// Fontes
		fonte1 = new Font("Arial", Font.BOLD, 30);
		fonte2 = new Font("Verdana", Font.PLAIN, 19);
		fonte3 = new Font("Verdana", Font.PLAIN, 16);

		// Adicionando as fontes aos componentes

		btnContinuar.setFont(fonte2);
		btnVoltar.setFont(fonte2);
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

		tfNome.setBounds(540, 298, 140, 30);
		rbtMasculino.setBounds(526, 400, 17, 17);
		rbtFeminino.setBounds(692, 400, 17, 17);
		tfDataNasc.setBounds(540, 488, 110, 30);
		btnContinuar.setBounds(510, 555, 168, 50);
		btnVoltar.setBounds(682, 555, 168, 50);

		escolha.add(rbtMasculino);
		escolha.add(rbtFeminino);
		add(tfNome);
		add(tfDataNasc);
		add(mockupLabel);
		add(btnContinuar);
		add(rbtMasculino);
		add(rbtFeminino);

		add(btnContinuar);
		add(btnVoltar);
		
		definirEventos();

		
	
															// imagem
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
				if(rbtMasculino.isSelected()) {
					 n2 = "masculino";
				}else {
					 n2 = "feminino";
				}
				String n1 = tfNome.getText();
				String n3 = tfDataNasc.getText();
				if (n1.isEmpty() || n3.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				} else {
					telaSessoes.getContentpane().removeAll();
		            JTelaCadastro2 cadastra2 = new JTelaCadastro2(telaSessoes, n1,n2,n3);
		            telaSessoes.getContentpane().add(cadastra2, BorderLayout.CENTER);
		            telaSessoes.revalidate();
		            telaSessoes.repaint();
				}

			}
		});
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando à tela anterior");
				telaSessoes.getContentpane().removeAll();
	            JTelaInicial inicio = new JTelaInicial(telaSessoes);
	            telaSessoes.getContentpane().add(inicio, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
			
			}
		});
	}

}