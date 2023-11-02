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

public class JTelaConfigurações extends JFrame{
	private Container contentpane;
	private JPanel pnBarra, pnPrincipal, pnColuna;
	private JLabel lblMockupLogo;
	private JButton btnConta, btnNotificacoes, btnAparencia, btnDesempenho, btnRegiao, btnData, btnManual, btnSobre;
	private JButton btnVoltarMenu;
	
	public static JTelaConfigurações frame;

	
	public JTelaConfigurações() {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
		
	}


	private void inicializarComponentes() {
		setTitle("Configurações");
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
        
		btnConta = new JButton("Você e EnjoyNotes");
		btnConta.setFont(fonte);
		btnConta.setBackground(pnColuna.getBackground());
		btnConta.setPreferredSize(new Dimension(225,40));
		btnConta.setBorder(compoundBorder);
		btnConta.setForeground(Color.WHITE);
		
		btnNotificacoes = new JButton("Notificações");
		btnNotificacoes.setFont(fonte);
		btnNotificacoes.setBackground(pnColuna.getBackground());
		btnNotificacoes.setPreferredSize(new Dimension(225,40));
		btnNotificacoes.setBorder(compoundBorder);
		btnNotificacoes.setForeground(Color.WHITE);
		
		btnAparencia = new JButton("Aparência e Tema");
		btnAparencia.setFont(fonte);
		btnAparencia.setBackground(pnColuna.getBackground());
		btnAparencia.setPreferredSize(new Dimension(225,40));
		btnAparencia.setBorder(compoundBorder);
		btnAparencia.setForeground(Color.WHITE);
		
		btnDesempenho = new JButton("Desempenho");
		btnDesempenho.setFont(fonte);
		btnDesempenho.setBackground(pnColuna.getBackground());
		btnDesempenho.setPreferredSize(new Dimension(225,40));
		btnDesempenho.setBorder(compoundBorder);
		btnDesempenho.setForeground(Color.WHITE);
		
		btnRegiao = new JButton("Região e Idioma");
		btnRegiao.setFont(fonte);
		btnRegiao.setBackground(pnColuna.getBackground());
		btnRegiao.setPreferredSize(new Dimension(225,40));
		btnRegiao.setBorder(compoundBorder);
		btnRegiao.setForeground(Color.WHITE);
		
		btnData = new JButton("Data e Hora");
		btnData.setFont(fonte);
		btnData.setBackground(pnColuna.getBackground());
		btnData.setPreferredSize(new Dimension(225,40));
		btnData.setBorder(compoundBorder);
		btnData.setForeground(Color.WHITE);
		
		btnManual = new JButton("Manual do Usuário");
		btnManual.setFont(fonte);
		btnManual.setBackground(pnColuna.getBackground());
		btnManual.setPreferredSize(new Dimension(225,40));
		btnManual.setBorder(compoundBorder);
		btnManual.setForeground(Color.WHITE);
		
		btnSobre = new JButton("Sobre o EnjoyNotes");
		btnSobre.setFont(fonte);
		btnSobre.setBackground(pnColuna.getBackground());
		btnSobre.setPreferredSize(new Dimension(225,40));
		btnSobre.setBorder(compoundBorder);
		btnSobre.setForeground(Color.WHITE);
		
		btnVoltarMenu = new JButton("<<");
		btnVoltarMenu.setFont(fonte2);
		btnVoltarMenu.setBackground(pnBarra.getBackground());
		btnVoltarMenu.setBounds(20, 37, 42, 35);
		btnVoltarMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnVoltarMenu.setForeground(Color.WHITE);
		
		pnBarra.add(lblMockupLogo);
		pnBarra.add(btnVoltarMenu);
		pnColuna.add(btnConta);
		pnColuna.add(btnNotificacoes);
		pnColuna.add(btnAparencia);
		pnColuna.add(btnDesempenho);
		pnColuna.add(btnRegiao);
		pnColuna.add(btnData);
		pnColuna.add(btnManual);
		pnColuna.add(btnSobre);
		
		JTelaConta conta = new JTelaConta();
		pnPrincipal.add(conta, BorderLayout.CENTER);
		pnPrincipal.validate();
	}

	private void definirEventos() {
		btnConta.addMouseListener(new MouseListener() {
			
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
			    btnConta.setBorder(compoundBorder);
			    btnConta.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnConta.setBorder(compoundBorder);
			    btnConta.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnPrincipal.removeAll();
				JTelaConta conta = new JTelaConta();
				pnPrincipal.add(conta, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
			}
		});

		btnNotificacoes.addMouseListener(new MouseListener() {
			
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
			    btnNotificacoes.setBorder(compoundBorder);
			    btnNotificacoes.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnNotificacoes.setBorder(compoundBorder);
			    btnNotificacoes.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				pnPrincipal.removeAll();
				JTelaNotificacoes notificacoes = new JTelaNotificacoes();
				pnPrincipal.add(notificacoes, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
			}
		});
		
		btnAparencia.addMouseListener(new MouseListener() {
			
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
			    btnAparencia.setBorder(compoundBorder);
			    btnAparencia.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnAparencia.setBorder(compoundBorder);
			    btnAparencia.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pnPrincipal.removeAll();
				JTelaTema tema = new JTelaTema();
				pnPrincipal.add(tema, BorderLayout.CENTER);
				pnPrincipal.revalidate(); // Atualiza o layout para exibir a nova tela
		        pnPrincipal.repaint();
			}
		});
	
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
	}
	
	public static void abrir() {
		frame = new JTelaConfigurações();
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
		JTelaConfigurações.abrir();
	}
}
