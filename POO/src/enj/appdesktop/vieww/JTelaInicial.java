package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author AleixoUNI
 * @see Classe para Tela inicial
 */
public class JTelaInicial extends JFrame{
	/**
	 * @see Tela Inicial
	 */
	private Container quadro;
	private JLabel lblTitulo;
	private JButton btnCadastrar, btnEntrar;
	private JLabel image;
	private ImageIcon imagem;
	Font fonte1, fonte2;
	
	public JTelaInicial() {
		setTitle("EnjoyNotes");
		quadro = getContentPane();
		setLayout(null);
		setSize(1000,800);
		
		quadro.setBackground(Color.PINK);

		lblTitulo = new JLabel("ENJOYNOTES");
		btnCadastrar = new JButton("Cadastre-se");
		btnEntrar = new JButton("Entrar");
		imagem = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\logo.png");
		image = new JLabel(imagem);
		
		
		//Fontes
		fonte1 = new Font("Arial", Font.BOLD,50);
		fonte2 = new Font("Verdana", Font.PLAIN, 19); 
		
		//Adicionando as fontes aos componentes
		
		lblTitulo.setFont(fonte1);
		btnCadastrar.setFont(fonte2);
		btnEntrar.setFont(fonte2);
		
		//
		
		lblTitulo.setBounds(330,100,500,100);
		btnCadastrar.setBounds(200, 500, 150, 35);
		btnEntrar.setBounds(600,500,150,35);
		image.setBounds(350,200,257,244);
		
		add(lblTitulo);
		add(btnCadastrar);
		add(btnEntrar);
		add(image);
		definirEventos();
		
	}

	private void definirEventos() {	
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			    JTelaCadastro.abrir();
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JTelaEntrar.abre();
			}
		});
	}
	public static void abreInicial() {
		JTelaInicial frame = new JTelaInicial();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // cetraliza a tela
		frame.setVisible(true);
		frame.setResizable(false);// desativa botão maximizar e minimizar
		//frame.setExtendedState(MAXIMIZED_BOTH);
	}
	public static void main(String[] args) {
		JTelaInicial frame = new JTelaInicial();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	

}
