	package enj.appdesktop.vieww;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Container;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
	import java.util.List;
import java.util.concurrent.Flow;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.controller.ListaController;
import enj.appdesktop.controller.NotaController;
import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;
	
	public class JTelaMenu extends JPanel{
	
		private JPanel pnPrincipal, pnBarra;
		private JPanel pnOpcoes, pnNotas, pnListas, pnQuadros;
		private JButton btn3linhas, btnCronometro, btnAgenda, btnPesquisar, btnConfiguracoes, btnConta;
		private JPanel pnLBLNotas, pnListaNotas;
		private JLabel lblNotas;
		private JButton btnCriarNota;
		private JPanel pnLBLListas, pnListaListas;
		private JLabel lblListas;
		private JPanel pnLBLQuadros, pnListaQuadros;
		private JLabel lblPergunta, lblMockupLogo;
		private String nome_perfil;
		private JTelaSessoes sessoes;
		private ContaVO conta;
		private Font fontIcon;
		public JTelaMenu (ContaVO conta, String nome_perfil, JTelaSessoes sessoes) {
			this.conta = conta;
			this.nome_perfil = nome_perfil;
			this.sessoes = sessoes;
			
			inicializarComponentes();
			posicionandoComponentes();
			definirEventos();
		}
	
		private void inicializarComponentes() {
			setSize(1366,768);
			
			setLayout(new BorderLayout());
			
			pnBarra = new JPanel();
	        pnBarra.setLayout(null);
	        pnBarra.setBackground(new Color(0x2a4674));
	        pnBarra.setPreferredSize(new Dimension(1366, 128));
	        
	        pnPrincipal = new JPanel();
	        pnPrincipal.setLayout(new FlowLayout());
	        pnPrincipal.setBackground(Color.WHITE);
	        
	        add(pnBarra, BorderLayout.NORTH);
	        add(pnPrincipal, BorderLayout.CENTER);
		}
	
		private void posicionandoComponentes() {
			Font fonte = new Font("League Spartan", Font.PLAIN, 24);
	        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
	        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
			
	        try {
	             fontIcon = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\AleixoUNI\\BEZALEL\\Fontes\\font-awesome-4.7.0\\font-awesome-4.7.0\\fonts\\FontAwesome.otf")).deriveFont(30f);       
	         } catch (IOException | FontFormatException e) {
	             e.printStackTrace();
	         }
	        
			lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
			lblMockupLogo.setBounds(51, 29, 139, 77);
			
			pnOpcoes = new JPanel();
			pnOpcoes.setLayout(new BoxLayout(pnOpcoes, BoxLayout.X_AXIS));
			pnOpcoes.setPreferredSize(new Dimension(1366,115));
			pnOpcoes.setBackground(Color.WHITE);
			
			btn3linhas = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\3linhas.png"));
			btn3linhas.setPreferredSize(new Dimension(52,41));
			MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(0, 40, 0, 900, Color.WHITE);
			MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
			btn3linhas.setBorder(compoundBorder1);
			
			btnCronometro = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoCronometro.png"));
			btnCronometro.setPreferredSize(new Dimension(54,50));
			MatteBorder emptyBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 10, Color.WHITE);
		    Border compoundBorder2 = BorderFactory.createCompoundBorder(emptyBorder2, redBottomBorder2);
			btnCronometro.setBorder(compoundBorder2);
			
			btnAgenda = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoAgenda.png"));
			btnAgenda.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder3 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder3 = BorderFactory.createMatteBorder(0, 0, 0, 10, Color.WHITE);
		    Border compoundBorder3 = BorderFactory.createCompoundBorder(emptyBorder3, redBottomBorder3);
			btnAgenda.setBorder(compoundBorder3);
			
			btnPesquisar = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoPesquisar.png"));
			btnPesquisar.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder4 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder4 = BorderFactory.createMatteBorder(0, 0, 0, 10, Color.WHITE);
		    Border compoundBorder4 = BorderFactory.createCompoundBorder(emptyBorder4, redBottomBorder4);
			btnPesquisar.setBorder(compoundBorder4);
			
			btnConfiguracoes = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoConfiguracoes.png"));
			btnConfiguracoes.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 10, Color.WHITE);
		    Border compoundBorder5 = BorderFactory.createCompoundBorder(emptyBorder5, redBottomBorder5);
			btnConfiguracoes.setBorder(compoundBorder5);
			
			btnConta = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoUsuario.png"));
			btnConta.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder6 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder6 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		    Border compoundBorder6 = BorderFactory.createCompoundBorder(emptyBorder6, redBottomBorder6);
			btnConta.setBorder(compoundBorder6);
			
			pnNotas = new JPanel();
			pnNotas.setLayout(new BoxLayout(pnNotas, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
	        pnNotas.setPreferredSize(new Dimension(1366, 200));
			pnNotas.setBackground(Color.WHITE);
			
			pnLBLNotas = new JPanel();
			pnLBLNotas.setLayout(new FlowLayout(FlowLayout.LEFT));
			pnLBLNotas.setPreferredSize(new Dimension(1366, 40));
			pnLBLNotas.setMaximumSize(new Dimension(1366,40));
			pnLBLNotas.setBackground(Color.WHITE);
			
			lblNotas = new JLabel("NOTAS");
	        lblNotas.setFont(fonte);
	        lblNotas.setBackground(Color.WHITE);
	        lblNotas.setForeground(Color.BLACK);
	        MatteBorder emptyBorder7 = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x2a4674));
			MatteBorder redBottomBorder7 = BorderFactory.createMatteBorder(0, 40, 0, 10, Color.WHITE);
		    Border compoundBorder7 = BorderFactory.createCompoundBorder(emptyBorder7, redBottomBorder7);
			lblNotas.setBorder(compoundBorder7);
			
			btnCriarNota = new JButton("\uf067");
			btnCriarNota.setFont(fontIcon);
			btnCriarNota.setBackground(Color.WHITE);
	        btnCriarNota.setForeground(Color.BLACK);
	        btnCriarNota.setBorder(new LineBorder(Color.WHITE));
	       
			pnListaNotas = new JPanel();
			FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 0); // 20 pixels de espaçamento horizontal
			pnListaNotas.setLayout(flowLayout);
			pnListaNotas.setPreferredSize(new Dimension(1366, 160));
			pnListaNotas.setMaximumSize(new Dimension(1366,160));
			pnListaNotas.setBackground(Color.WHITE);
			
			pnListas = new JPanel();
			pnListas.setLayout(new BoxLayout(pnListas, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
	        pnListas.setPreferredSize(new Dimension(1366, 200));
			pnListas.setBackground(Color.WHITE);
			
			pnLBLListas = new JPanel();
			pnLBLListas.setLayout(new FlowLayout(FlowLayout.LEFT));
			pnLBLListas.setPreferredSize(new Dimension(1366, 40));
			pnLBLListas.setMaximumSize(new Dimension(1366,40));
			pnLBLListas.setBackground(Color.WHITE);
			
			lblListas = new JLabel("LISTAS");
	        lblListas.setFont(fonte);
	        lblListas.setBackground(Color.WHITE);
	        lblListas.setForeground(Color.BLACK);
	        MatteBorder emptyBorder8 = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x2a4674));
			MatteBorder redBottomBorder8 = BorderFactory.createMatteBorder(0, 40, 0, 0, Color.WHITE);
		    Border compoundBorder8 = BorderFactory.createCompoundBorder(emptyBorder8, redBottomBorder8);
			lblListas.setBorder(compoundBorder8);
	       
			pnListaListas = new JPanel();
			FlowLayout flowLayout2 = new FlowLayout(FlowLayout.LEFT, 20, 0); // 20 pixels de espaçamento horizontal
			pnListaListas.setLayout(flowLayout2);
			pnListaListas.setPreferredSize(new Dimension(1600, 160));
			pnListaListas.setMaximumSize(new Dimension(1366,160));
			pnListaListas.setBackground(Color.WHITE);
	
			
			pnBarra.add(lblMockupLogo);
			pnPrincipal.add(pnListas, FlowLayout.LEFT);
			pnPrincipal.add(pnNotas, FlowLayout.LEFT);
			pnPrincipal.add(pnOpcoes, FlowLayout.LEFT);
			pnOpcoes.add(btn3linhas); 
			pnOpcoes.add(btnCronometro);
			pnOpcoes.add(btnAgenda);
			pnOpcoes.add(btnPesquisar);
			pnOpcoes.add(btnConfiguracoes);
			pnOpcoes.add(btnConta);
			pnLBLNotas.add(lblNotas);
			pnLBLNotas.add(btnCriarNota);
			pnNotas.add(pnLBLNotas);
			pnNotas.add(pnListaNotas);
			pnLBLListas.add(lblListas);
			pnListas.add(pnLBLListas);
			pnListas.add(pnListaListas);
		}
	
		private void definirEventos() {
			NotaController notacontroller = new NotaController();
			if(notacontroller.verificarSeTemNotas(nome_perfil)) {
			notacontroller.listarNotas(nome_perfil);
			List<JTelaListaNotas> notasPreparadas;
			notasPreparadas = new ArrayList<>();
			List<NotasVO> NotasProntas =notacontroller.NotasPreparadasdaCOnta();
			
			for(NotasVO notas : NotasProntas) {
				JTelaListaNotas blocos = new JTelaListaNotas(notas, sessoes, conta, this);
				notasPreparadas.add(blocos);
			}

			for (JTelaListaNotas blocosProntos : notasPreparadas) {
			    blocosProntos.setPreferredSize(new Dimension(150, 150));
			    blocosProntos.setMaximumSize(new Dimension(150,150));
			    pnListaNotas.add(blocosProntos);
			}
			
			}
			ListaController listacontroller = new ListaController();
			if(listacontroller.verificarSeTemLista(nome_perfil)) {
			listacontroller.listarListas(nome_perfil);
			List<JTelaListaDeListas> ListasPreparadas;
			ListasPreparadas = new ArrayList<>();
			List<ListaVO> ListasProntas = listacontroller.ListasPreparadasdaCOnta();
			
			for(ListaVO listas : ListasProntas) {
				JTelaListaDeListas blocos = new JTelaListaDeListas(listas, sessoes);
				ListasPreparadas.add(blocos);
			}

			for (JTelaListaDeListas blocosProntos : ListasPreparadas) {
			    blocosProntos.setPreferredSize(new Dimension(150, 150));
			    blocosProntos.setMaximumSize(new Dimension(150,150));
			    pnListaListas.add(blocosProntos);
			}
			
		} else {
			pnListaListas.add(new JLabel("Adicione"));
		}
			btnCriarNota.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JTelaNotas nota = new JTelaNotas(conta, sessoes);
					AddTelaNota(nota);
				}
			});
			btnConfiguracoes.addMouseListener(new MouseListener() {
				
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
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					sessoes.getContentpane().removeAll();
	                JTelaConfigurações configuracoes = new JTelaConfigurações(conta, sessoes);
	                sessoes.getContentpane().add(configuracoes, BorderLayout.CENTER);
	                sessoes.revalidate();
	                sessoes.repaint();
					
				}
			});
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
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					sessoes.getContentpane().removeAll();
		            JTelaUsuario usuario = new JTelaUsuario(conta, sessoes);
		            sessoes.getContentpane().add(usuario, BorderLayout.CENTER);
		            sessoes.revalidate();
		            sessoes.repaint();
					
				}
			});
			btnAgenda.addMouseListener(new MouseListener() {
				
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
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					sessoes.getContentpane().removeAll();
		            AgendaApp agenda = new AgendaApp(conta, sessoes);
		            sessoes.getContentpane().add(agenda, BorderLayout.CENTER);
		            sessoes.revalidate();
		            sessoes.repaint();
					
				}
			});
			btnCronometro.addMouseListener(new MouseListener() {
				
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
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					sessoes.getContentpane().removeAll();
		            JTelaCronometro cronometro = new JTelaCronometro(conta, sessoes);
		            sessoes.getContentpane().add(cronometro, BorderLayout.CENTER);
		            sessoes.revalidate();
		            sessoes.repaint();
					
				}
			});
		}
		public JPanel getPanel(){
			return pnPrincipal;
			}
		public void AddTela(JTelaAtualizaNotas notas) {
			pnPrincipal.add(pnListas, FlowLayout.LEFT);
			pnPrincipal.add(pnNotas, FlowLayout.LEFT);
			pnPrincipal.add(notas, FlowLayout.LEFT);
			pnPrincipal.add(pnOpcoes, FlowLayout.LEFT);
			pnPrincipal.revalidate();
			pnPrincipal.repaint();
		}
		public void AddTelaNota(JTelaNotas notas) {
			pnPrincipal.add(pnListas, FlowLayout.LEFT);
			pnPrincipal.add(pnNotas, FlowLayout.LEFT);
			pnPrincipal.add(notas, FlowLayout.LEFT);
			pnPrincipal.add(pnOpcoes, FlowLayout.LEFT);
			pnPrincipal.revalidate();
			pnPrincipal.repaint();
		}
		}
