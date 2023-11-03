package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class JTelaUsuario extends JFrame{
	private Container contentpane;
	private JPanel pnBarra, pnPrincipal, pnColuna;
	private JLabel lblMockupLogo;
	private JButton btnDados, btnAlterarPerfil, btnAlterarSenha;
	private JButton btnVoltarMenu;
	
	public static JTelaUsuario frame;

	
	public JTelaUsuario() {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
		
	}


	private void inicializarComponentes() {
		setTitle("Conta de Bezalel");
		contentpane = getContentPane();
		setSize(1366,768);
		setLayout(new BorderLayout());
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));
        MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(0x84CAED));
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        pnBarra.setBorder(compoundBorder);
		
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(new BorderLayout());
        pnPrincipal.setBackground(new Color(0x84CAED));
        
        
        pnColuna = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 40);
        pnColuna.setLayout(flowLayout);
        pnColuna.setPreferredSize(new Dimension(250, 660));
        pnColuna.setBackground(new Color(0x345389));
        JScrollPane scrollPane = new JScrollPane(pnColuna);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollbarUI());
        MatteBorder emptyBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 10, new Color(0x84CAED));
        Border compoundBorder2 = BorderFactory.createCompoundBorder(emptyBorder2, redBottomBorder2);
        scrollPane.setBorder(compoundBorder2);
        
        contentpane.add(pnBarra, BorderLayout.NORTH);
        contentpane.add(pnPrincipal, BorderLayout.CENTER);
        contentpane.add(scrollPane, BorderLayout.WEST);
	}

	private void posicionandoComponentes() {
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(60, 17, 139, 77);
		
		Font fonte = new Font("Bernoru", Font.BOLD, 17);
		Font fonte2 = new Font("Garet", Font.PLAIN, 30);
		
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        
		btnDados = new JButton("Dados Gerais");
		btnDados.setFont(fonte);
		btnDados.setBackground(pnColuna.getBackground());
		btnDados.setPreferredSize(new Dimension(225,40));
		btnDados.setBorder(compoundBorder);
		btnDados.setForeground(Color.WHITE);
		
		btnAlterarPerfil = new JButton("Alterar dados de perfil");
		btnAlterarPerfil.setFont(fonte);
		btnAlterarPerfil.setBackground(pnColuna.getBackground());
		btnAlterarPerfil.setPreferredSize(new Dimension(225,40));
		btnAlterarPerfil.setBorder(compoundBorder);
		btnAlterarPerfil.setForeground(Color.WHITE);
		
		btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.setFont(fonte);
		btnAlterarSenha.setBackground(pnColuna.getBackground());
		btnAlterarSenha.setPreferredSize(new Dimension(225,40));
		btnAlterarSenha.setBorder(compoundBorder);
		btnAlterarSenha.setForeground(Color.WHITE);
		
		btnVoltarMenu = new JButton("<<");
		btnVoltarMenu.setFont(fonte2);
		btnVoltarMenu.setBackground(pnBarra.getBackground());
		btnVoltarMenu.setBounds(20, 37, 42, 35);
		btnVoltarMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnVoltarMenu.setForeground(Color.WHITE);
		
		pnBarra.add(lblMockupLogo);
		pnBarra.add(btnVoltarMenu);
		pnColuna.add(btnDados);
		pnColuna.add(btnAlterarPerfil);
		pnColuna.add(btnAlterarSenha);
		
		JTelaDadosGerais dados = new JTelaDadosGerais();
		pnPrincipal.add(dados, BorderLayout.CENTER);
		pnPrincipal.validate();
		
	}

	private void definirEventos() {
		btnVoltarMenu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnVoltarMenu.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnVoltarMenu.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTelaMenu.abreMenuPrincipal();
				
			}
		});
		btnDados.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnDados.setBorder(compoundBorder);
			    btnDados.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnDados.setBorder(compoundBorder);
			    btnDados.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnPrincipal.removeAll();
				JTelaDadosGerais dados = new JTelaDadosGerais();
				pnPrincipal.add(dados, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
				
			}
		});
		btnAlterarPerfil.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnAlterarPerfil.setBorder(compoundBorder);
			    btnAlterarPerfil.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnAlterarPerfil.setBorder(compoundBorder);
			    btnAlterarPerfil.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnPrincipal.removeAll();
				JTelaAlterarPerfil perfil = new JTelaAlterarPerfil();
				pnPrincipal.add(perfil, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
				
			}
		});
		btnAlterarSenha.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnAlterarSenha.setBorder(compoundBorder);
			    btnAlterarSenha.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnAlterarSenha.setBorder(compoundBorder);
			    btnAlterarSenha.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnPrincipal.removeAll();
				JTelaAlterarSenha senha = new JTelaAlterarSenha();
				pnPrincipal.add(senha, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
				
			}
		});
	}
	
	public static void abrir() {
		frame = new JTelaUsuario();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	


	    public static void fechar() {
	        if (frame != null) {
	            frame.dispose(); 
	        }
	    }
	
	public static void main(String[] args) {
		JTelaUsuario.abrir();
	}
}
