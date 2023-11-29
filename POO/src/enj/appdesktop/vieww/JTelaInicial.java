package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enj.appdesktop.model.vo.ContaVO;

import java.lang.String;
/**
 * @author AleixoUNI
 * @see Classe para Tela inicial
 */
public class JTelaInicial extends JPanel{
	/**
	 * @see Tela Inicial
	 */
	private Container quadro;
	private JPanel pnTela;
	private JLabel lblTitulo;
	private JButton btnCadastrar, btnEntrar;
	private JLabel image;
	private ImageIcon imagem;
	Font fonte1, fonte2;
	
    private JTelaSessoes telaSessoes;
	
	public JTelaInicial(JTelaSessoes telaSessoes) {
		
        this.telaSessoes = telaSessoes;
		
		setLayout(null); // Layout nulo para posicionar elementos manualmente
        setSize(1366,768);
        
        ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\1300.jpg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
		
		lblTitulo = new JLabel("ENJOYNOTES");
		btnCadastrar = new JButton("Cadastre-se");
		btnEntrar = new JButton("Entrar");
		
		//Fontes
		fonte1 = new Font("Arial", Font.BOLD,50);
		fonte2 = new Font("Verdana", Font.PLAIN, 19); 
		
		//Adicionando as fontes aos componentes
		
		lblTitulo.setFont(fonte1);
		btnCadastrar.setFont(fonte2);
		btnEntrar.setFont(fonte2);
		
		//
		
		lblTitulo.setBounds(330,100,500,100);
		btnCadastrar.setBounds(543, 493, 200, 80);
		btnEntrar.setBounds(543,377,200,80);
		//btnCadastrar.setBackground(Color.BLACK);
		//btnEntrar.setBackground(Color.BLACK);
		
		// Torna os botões transparentes
        btnEntrar.setOpaque(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setBorderPainted(false);

        btnCadastrar.setOpaque(false);
        btnCadastrar.setContentAreaFilled(false);
        btnCadastrar.setBorderPainted(false);
        
        add(mockupLabel); // Adiciona a imagem como plano de fundo
		add(btnEntrar);
		add(btnCadastrar);

		definirEventos();
		
	}

	private void definirEventos() {	
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				telaSessoes.getContentpane().removeAll();
	            JTelaCadastro cadastra = new JTelaCadastro(telaSessoes);
	            telaSessoes.getContentpane().add(cadastra, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
			}
		});
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaSessoes.getContentpane().removeAll();
	            JTelaEntrar entrar = new JTelaEntrar(telaSessoes);
	            telaSessoes.getContentpane().add(entrar, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
			}
		});
	
	}
}
