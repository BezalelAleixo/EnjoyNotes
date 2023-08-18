package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public JTelaInicial() {
		setTitle("EnjoyNotes");
		quadro = getContentPane();
		setLayout(null);
		setSize(1000,800);
		
		lblTitulo = new JLabel("ENJOYNOTES");
		btnCadastrar = new JButton("Cadastre-se");
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.PINK);		
		lblTitulo.setBounds(450,100,120,20);
		btnCadastrar.setBounds(200, 500, 120, 30);
		btnEntrar.setBounds(600,500,120,30);
		
		add(lblTitulo);
		add(btnCadastrar);
		add(btnEntrar);
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
