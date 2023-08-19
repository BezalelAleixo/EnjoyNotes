package enj.appdesktop.view;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * @author AleixoUNI
 * @see Classe para Tela do menu principal
 */
public class JTelaMenu extends JFrame{
	private Container quadro;
	private JScrollPane Spane;
	//private JScrollBar Sbar;
	private JLabel lblNota, lblLista;
	private JPanel pnLadoCima, pnLadoNotas, pnLadoListas;
	
	public JTelaMenu() {
		setTitle("Menu Principal");
		quadro = getContentPane();
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(0,0,1000,800);
		setLayout(null);
		
		//setForeground(Color.RED);
		lblNota = new JLabel("Notas");
		lblLista = new JLabel("Listas");
		pnLadoCima = new JPanel();
		pnLadoCima.setBackground(Color.WHITE);
		pnLadoNotas = new JPanel();
		pnLadoNotas.setBackground(Color.WHITE);
		pnLadoListas = new JPanel();
		pnLadoListas.setBackground(Color.WHITE);
		Spane = new JScrollPane();
		//Sbar = new JScrollBar(JScrollBar.VERTICAL, 980,0,20,800);
		
		pnLadoCima.setBounds(0,0,1000,100);
		pnLadoNotas.setBounds(0,200,1000,80);
		pnLadoListas.setBounds(0,380,1000,80);
		lblNota.setBounds(50,130,100,30);
		lblLista.setBounds(50,310,100,30);
		Spane.setBounds(0,0,1000,800);
	//	Sbar.setBounds(980,0,20,800);
		
		Spane.setLayout(null);
		Spane.add(pnLadoCima);
		Spane.add(lblNota);
		Spane.add(pnLadoNotas);
		Spane.add(lblLista);
		Spane.add(pnLadoListas);
		//Spane.add(Sbar);
		add(Spane);
		//add(Sbar);
	}
	public static void main(String[] args) {
		JTelaMenu frame = new JTelaMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}

}
