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

import enj.appdesktop.controller.NotaController;
import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;
	
	public class JTelaMenu extends JPanel{
	
		private JPanel pnPrincipal, pnBarra;
		private JPanel pnOpcoes, pnNotas, pnListas;
		private JButton btn3linhas, btnCronometro, btnAgenda, btnPesquisar, btnConfiguracoes, btnConta, btnQuadro, btnVideos;
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
	             fontIcon = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\AleixoUNI\\BEZALEL\\Fontes\\font-awesome-4.7.0\\font-awesome-4.7.0\\fonts\\FontAwesome.otf")).deriveFont(45f);       
	         } catch (IOException | FontFormatException e) {
	             e.printStackTrace();
	         }
	        
			lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
			lblMockupLogo.setBounds(51, 29, 139, 77);
			
			pnOpcoes = new JPanel();
			pnOpcoes.setLayout(new BoxLayout(pnOpcoes, BoxLayout.X_AXIS));
			pnOpcoes.setPreferredSize(new Dimension(1366,115));
			pnOpcoes.setBackground(Color.WHITE);
			
			btn3linhas = new JButton("\uf0c9");
			btn3linhas.setFont(fontIcon);
			btn3linhas.setBackground(Color.WHITE);
			btn3linhas.setPreferredSize(new Dimension(52,41));
			MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(0, 40, 0, 900, Color.WHITE);
			MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
			btn3linhas.setBorder(compoundBorder1);
			
			btnCronometro = new JButton("\uf017");
			btnCronometro.setFont(fontIcon);
			btnCronometro.setBackground(Color.WHITE);
			btnCronometro.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder2 = BorderFactory.createMatteBorder(0, 0, 0, 20, Color.WHITE);
		    Border compoundBorder2 = BorderFactory.createCompoundBorder(emptyBorder2, redBottomBorder2);
			btnCronometro.setBorder(compoundBorder2);
			
			btnAgenda = new JButton("\uf073");
			btnAgenda.setFont(fontIcon);
			btnAgenda.setBackground(Color.WHITE);
			btnAgenda.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder3 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder3 = BorderFactory.createMatteBorder(0, 0, 0, 20, Color.WHITE);
		    Border compoundBorder3 = BorderFactory.createCompoundBorder(emptyBorder3, redBottomBorder3);
			btnAgenda.setBorder(compoundBorder3);
			
			btnPesquisar = new JButton("\uf002");
			btnPesquisar.setFont(fontIcon);
			btnPesquisar.setBackground(Color.WHITE);
			btnPesquisar.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder4 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder4 = BorderFactory.createMatteBorder(0, 0, 0, 20, Color.WHITE);
		    Border compoundBorder4 = BorderFactory.createCompoundBorder(emptyBorder4, redBottomBorder4);
			btnPesquisar.setBorder(compoundBorder4);
			
			btnConfiguracoes = new JButton("\uf013");
			btnConfiguracoes.setFont(fontIcon);
			btnConfiguracoes.setBackground(Color.WHITE);
			btnConfiguracoes.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 20, Color.WHITE);
		    Border compoundBorder5 = BorderFactory.createCompoundBorder(emptyBorder5, redBottomBorder5);
			btnConfiguracoes.setBorder(compoundBorder5);
			
			btnConta = new JButton("\uf2bd");
			btnConta.setFont(fontIcon);
			btnConta.setBackground(Color.WHITE);
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
			FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 5); // 20 pixels de espaçamento horizontal
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
			
			btnQuadro = new JButton("Quadros");
			btnQuadro.setFont(fonte);
			btnQuadro.setBackground(Color.WHITE);
			btnQuadro.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder9 = BorderFactory.createMatteBorder(0, 0, 0, 20, Color.WHITE);
			MatteBorder redBottomBorder9 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		    Border compoundBorder9 = BorderFactory.createCompoundBorder(emptyBorder9, redBottomBorder9);
			btnQuadro.setBorder(compoundBorder9);
			
			btnVideos = new JButton("Videos");
			btnVideos.setFont(fonte);
			btnVideos.setBackground(Color.WHITE);
			btnVideos.setPreferredSize(new Dimension(52,52));
			MatteBorder emptyBorder10 = BorderFactory.createMatteBorder(0, 0, 0, 720, Color.WHITE);
			MatteBorder redBottomBorder10 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
		    Border compoundBorder10 = BorderFactory.createCompoundBorder(emptyBorder10, redBottomBorder10);
			btnVideos.setBorder(compoundBorder10);
	
			
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
			btnVideos.addMouseListener(new MouseListener() {
				
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
					JTelaVideos videos = new JTelaVideos(conta, sessoes);
	                sessoes.getContentpane().add(videos, BorderLayout.CENTER);
	                sessoes.revalidate();
	                sessoes.repaint();
				}
			});
			btnQuadro.addMouseListener(new MouseListener() {
				
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
					JTelaQuadros quadros = new JTelaQuadros(conta, sessoes);
	                sessoes.getContentpane().add(quadros, BorderLayout.CENTER);
	                sessoes.revalidate();
	                sessoes.repaint();
					
				}
			});
			
			
			btn3linhas.addMouseListener(new MouseListener() {
				
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
					
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(0, 40, 0, 20, Color.WHITE);
					MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
				    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
					btn3linhas.setBorder(compoundBorder1);
					AddMaisOpcoes(btnQuadro, btnVideos);
					revalidate();
					repaint();
				}
			});
			
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
		public void AddMaisOpcoes(JButton btnQuadros, JButton btnVideos) {
			pnOpcoes.add(btn3linhas); 
			pnOpcoes.add(btnQuadros); 
			pnOpcoes.add(btnVideos); 
			pnOpcoes.add(btnCronometro);
			pnOpcoes.add(btnAgenda);
			pnOpcoes.add(btnPesquisar);
			pnOpcoes.add(btnConfiguracoes);
			pnOpcoes.add(btnConta);
		}
		}
