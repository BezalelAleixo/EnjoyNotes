package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.model.vo.ContaVO;

public class JTelaSessoes extends JFrame{

	private Container contentpane;
	private JPanel pnPrincipal, pnBarra, pnBlocosContas;
	private JLabel lblPergunta, lblMockupLogo;
	private JButton btnIncio, btnEntrar, btnCadastre;
	
	
	public JTelaSessoes () {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setTitle("Entre na sua conta");
		contentpane = getContentPane();
		setSize(1366,768);
		
		setLayout(new BorderLayout());
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBackground(new Color(0x84CAED));
        
        contentpane.add(pnBarra, BorderLayout.NORTH);
        contentpane.add(pnPrincipal, BorderLayout.CENTER);
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Bernoru", Font.BOLD, 50);
		
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(51, 29, 139, 77);
		
		lblPergunta = new JLabel("Quem está acessando?");
		lblPergunta.setFont(fonte);
		lblPergunta.setForeground(new Color(0x2a4674));
		lblPergunta.setBounds(383, 50, 600, 100);
		
		pnBlocosContas = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 30, 0); // 20 pixels de espaçamento horizontal
		pnBlocosContas.setLayout(flowLayout);
		pnBlocosContas.setBounds(0, 200, 1366, 440);
		pnBlocosContas.setBackground(new Color(0x84CAED));
		
		Font fonte2 = new Font("Bernoru", Font.BOLD, 24);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(fonte2);
		btnEntrar.setBounds(1200, 42, 120, 42);
		btnEntrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEntrar.setBackground(new Color(0x2a4674));
		btnEntrar.setForeground(Color.WHITE);
		
		btnCadastre = new JButton("Cadastre-se");
		btnCadastre.setFont(fonte2);
		btnCadastre.setBounds(1000, 42, 160, 42);
		btnCadastre.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnCadastre.setBackground(new Color(0x2a4674));
		btnCadastre.setForeground(Color.WHITE);
		
		btnIncio = new JButton("Início");
		btnIncio.setFont(fonte2);
		btnIncio.setBounds(860, 42, 100, 42);
		btnIncio.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnIncio.setBackground(new Color(0x2a4674));
		btnIncio.setForeground(Color.WHITE);
		
		
		
		pnBarra.add(lblMockupLogo);
		pnBarra.add(btnEntrar);
		pnBarra.add(btnCadastre);
		pnBarra.add(btnIncio);
		pnPrincipal.add(lblPergunta);
		pnPrincipal.add(pnBlocosContas);
		
	}

	private void definirEventos() {
		SessaoController controller = new SessaoController();
		controller.sessoesLogadas();
		List<JTelaSessoesContas> contasPreparadas;
		contasPreparadas = new ArrayList<>();
		List<ContaVO> contaLogadas = controller.ListaContasFeitas();
		
		for(ContaVO contas : contaLogadas) {
			JTelaSessoesContas blocos = new JTelaSessoesContas(contas, JTelaSessoes.this);
			contasPreparadas.add(blocos);
		}
		for(JTelaSessoesContas blocosProntos : contasPreparadas) {
			blocosProntos.setPreferredSize(new Dimension(193,263));
			pnBlocosContas.add(blocosProntos);
		}
		btnEntrar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnEntrar.setForeground(new Color(0x2b2760));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			//	getContentpane().removeAll();
	          //  JTelaEntrar entrar = new JTelaEntrar(JTelaSessoes.this);
	        //    getContentpane().add(entrar, BorderLayout.CENTER);
	          //  revalidate();
	            //repaint();
				JPanel pn = new JPanel();
				pn.setBackground(Color.pink);
				
				pnPrincipal.add(pn).setBounds(310, 0, 610, 20);;
				pnPrincipal.revalidate();
				pnPrincipal.repaint();
			}
		});
			btnCadastre.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCadastre.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnCadastre.setForeground(new Color(0x2b2760));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentpane().removeAll();
	            JTelaCadastro cadastre = new JTelaCadastro(JTelaSessoes.this);
	            getContentpane().add(cadastre, BorderLayout.CENTER);
	            revalidate();
	            repaint();
				
			}
		});
			btnIncio.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					btnIncio.setForeground(Color.WHITE);
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					
					btnIncio.setForeground(new Color(0x2b2760));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					getContentpane().removeAll();
		            JTelaInicial inicio = new JTelaInicial(JTelaSessoes.this);
		            getContentpane().add(inicio, BorderLayout.CENTER);
		            revalidate();
		            repaint();
					
				}
			});
		
	}
	
	public Container getContentpane() {
	    return contentpane;
	}

	public static void abrir(){
		JTelaSessoes frame = new JTelaSessoes();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		JTelaSessoes.abrir();
	}
}
