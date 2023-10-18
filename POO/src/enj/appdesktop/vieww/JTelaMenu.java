package enj.appdesktop.vieww;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import enj.appdesktop.model.daoo.ConsultaDAO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;
import enj.appdesktop.model.vo.Pesquisar;

public class JTelaMenu extends JFrame {
	private Container contentPane;
	private JPanel pnTela;
	private JLabel lblTitulo;
	private JButton btnCriarLista, btnCriarNota, btnSair;
	private static JTextField txtPesquisa;
    private JButton btnPesquisar;
    private JButton btnIcone;
    private JButton btnAgenda;
    private DefaultTableModel model;
    private JTable tabela;
    private JPanel panel;

	
    

	public JTelaMenu() {
		setTitle(" Menu");
		contentPane = getContentPane();
		setLayout(new BorderLayout());
		
		pnTela = new JPanel();
		pnTela.setLayout(null); // Layout nulo para posicionar elementos manualmente
        pnTela.setBackground(Color.WHITE);
        
        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\menu\\convert-dpi.com\\5300.jpg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
		

		Font customFont = new Font("Arial", Font.BOLD | Font.BOLD, 17);
		Font customFont2 = new Font("Arial", Font.BOLD | Font.BOLD, 22);
		
		lblTitulo = new JLabel("Bem vindo, escolha o que fazer:");
		lblTitulo.setFont(customFont);
		

		
		txtPesquisa = new JTextField();
        txtPesquisa.setFont(customFont);
        txtPesquisa.setBounds(215, 146, 150, 30);
        
 
     // Crie a tabela com o modelo atualizado
      

        
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.setFont(customFont);
        btnPesquisar.setBounds(528, 132, 60, 60);
        btnPesquisar.setBackground(Color.BLACK);
        
        
        
     
        
        btnIcone = new JButton("icone");
        
        btnIcone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abreTelaUsuario(); // Quando o botão de ícone for clicado, abra a tela de usuário
            }
        });
		
		btnCriarLista = new JButton("Criar Lista");
		btnCriarNota = new JButton("Criar Notas");
		btnSair = new JButton("Sair");
		btnAgenda = new JButton("Agenda");
		lblTitulo.setBounds(300, 30, 250, 50);
		
		btnAgenda.setFont(customFont2);
		
		btnCriarLista.setBounds(50, 490, 65, 65);
		btnCriarNota.setBounds(50, 300, 65, 65);
		btnSair.setBounds(1290, 30, 55,45);
		btnIcone.setBounds(1267, 130, 63,63);
		btnAgenda.setBounds(600,130, 120,63);
		
	/*	btnCriarLista.setBackground(Color.BLACK);
		btnCriarNota.setBackground(Color.BLACK);
		btnSair.setBackground(Color.BLACK);
		btnIcone.setBackground(Color.BLACK);*/
		
		btnAgenda.setForeground(Color.BLACK);
		

		// Torna os botões transparentes
		txtPesquisa.setOpaque(false);
        txtPesquisa.setBorder(BorderFactory.createEmptyBorder()); 
        txtPesquisa.setForeground(Color.BLACK);
		
        btnCriarLista.setOpaque(false);
        btnCriarLista.setContentAreaFilled(false);
        btnCriarLista.setBorderPainted(false);

        btnCriarNota.setOpaque(false);
        btnCriarNota.setContentAreaFilled(false);
        btnCriarNota.setBorderPainted(false);
        
        btnPesquisar.setOpaque(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.setBorderPainted(false);
        
        btnIcone.setOpaque(false);
        btnIcone.setContentAreaFilled(false);
        btnIcone.setBorderPainted(false);
        
        btnSair.setOpaque(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setBorderPainted(false);
        
        btnCriarLista.setOpaque(false);
        btnCriarLista.setContentAreaFilled(false);
        btnCriarLista.setBorderPainted(false);
		
        btnAgenda.setOpaque(false);
        btnAgenda.setContentAreaFilled(false);
        btnAgenda.setBorderPainted(false);
		
		

		
		 btnCriarLista.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, "Abrindo Lista");
	            	dispose();
	            	JTelaMenu.abreTelaListas();
	                

	               }
	        });
		 
		 btnCriarNota.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JOptionPane.showMessageDialog(null, "Abrindo Notas");
	            	dispose();
	            	JTelaMenu.abreTelaNotas();
	                

	               }
	        });
		 btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		 
		 btnPesquisar.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {	
				FiltroPesquisa.abrir();
				dispose();
				}
	        });
		 
		 btnAgenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AgendaApp.abrirAgenda();
				
			}
		});
	
	
		pnTela.add(txtPesquisa);
		pnTela.add(btnAgenda);
		pnTela.add(mockupLabel);
		pnTela.add(lblTitulo);
		pnTela.add(btnCriarLista);
		pnTela.add(btnCriarNota);
		pnTela.add(btnPesquisar);
		pnTela.add(btnSair);
		pnTela.add(btnIcone);
		add(pnTela);
		setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight()); // Ajusta o tamanho da janela com base na imagem
		  }
	
	public static String getPesquisa() {
		String n = txtPesquisa.getText();
		return n;
	}

public static void abreTelaListas() {
		JTelaListas frame = new JTelaListas();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}


public static void abreTelaNotas() {
	JTelaNotas frame = new JTelaNotas();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setResizable(false);
	
}
public static void abreTelaUsuario() {
    // Você precisará fornecer os detalhes do usuário a partir do seu aplicativo, como nome, sexo e data de nascimento.
    JTelaUsuario frame = new JTelaUsuario();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setLocationRelativeTo(frame);
    		frame.setVisible(true);
}
public static void abreMenuPrincipal() {
    // Você precisará fornecer os detalhes do usuário a partir do seu aplicativo, como nome, sexo e data de nascimento.
    JTelaMenu frame = new JTelaMenu();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setLocationRelativeTo(frame);
    		frame.setVisible(true);
}
public static void main(String[] args) {
	JTelaMenu frame = new JTelaMenu();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}
}