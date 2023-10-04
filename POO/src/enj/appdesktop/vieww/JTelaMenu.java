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
		lblTitulo.setBounds(300, 30, 250, 50);
		
		btnCriarLista.setBounds(50, 490, 65, 65);
		btnCriarNota.setBounds(50, 300, 65, 65);
		btnSair.setBounds(1290, 30, 55,45);
		btnIcone.setBounds(1267, 130, 63,63);
		
	/*	btnCriarLista.setBackground(Color.BLACK);
		btnCriarNota.setBackground(Color.BLACK);
		btnSair.setBackground(Color.BLACK);
		btnIcone.setBackground(Color.BLACK);*/
		

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
	                String termoDePesquisa = txtPesquisa.getText();
	                Pesquisar pesquisador = new Pesquisar(termoDePesquisa);
	               // ConsultaDAO amor = new ConsultaDAO();
	                // Verifica se o termo de pesquisa não está vazio
	                if (!termoDePesquisa.isEmpty() && pesquisador.verificarPesquisa()) {
	                    
	                //	if(amor.verificarPesquisa(termoDePesquisa)) {

		                    // Realiza a pesquisa nas notas
		                   pesquisador.pesquisarNotasPorNomes(); 
		                        // Exiba ou faça algo com a nota encontrada
		                        JOptionPane.showMessageDialog(null, "Nota encontrada: \n" + pesquisador.resultadoNT1());
		                    
	                	} else if(!termoDePesquisa.isEmpty() && pesquisador.verificarPesquisaLIS()) {
							//Pesquisar pesquisador = new Pesquisar(termoDePesquisa);
	                    // Realiza a pesquisa nas listas
	                        pesquisador.pesquisarListasPorNome();
	                        // Exiba ou faça algo com a lista encontrada
	                        JOptionPane.showMessageDialog(null, "Lista encontrada: \n" + pesquisador.resultadoLT1());
						}
	                 else {
	                    JOptionPane.showMessageDialog(null, "Digite um termo de pesquisa válido.");
	                }
				}	
	        });
		/*txtPesquisa.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				Pesquisar pesquisador = new Pesquisar(txtPesquisa.getText());
	                if (!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisa()) {
	           
		                    
		                		
		                    
	                	} else if(!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisaLIS()) {
							
						}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				Pesquisar pesquisador = new Pesquisar(txtPesquisa.getText());
	                if (!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisa()) {
		                  
	                        
		                    
	                	} else if(!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisaLIS()) {

					}
			}	
			
		
			@Override
			public void changedUpdate(DocumentEvent e) {
				Pesquisar pesquisador = new Pesquisar(txtPesquisa.getText());
	               
	                if (!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisa()) {
	                    
	                	
		                    
	                	} else if(!txtPesquisa.getText().isEmpty() && pesquisador.verificarPesquisaLIS()) {
						
						}
				
			}
		});*/
	
		pnTela.add(txtPesquisa);
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

public static void main(String[] args) {
	JTelaMenu frame = new JTelaMenu();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}
}