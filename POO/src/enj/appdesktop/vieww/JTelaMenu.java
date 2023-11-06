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
		private JPanel pnOpcoes, pnNotas, pnListas, pnQuadros;
		private JButton btn3linhas, btnCronometro, btnAgenda, btnPesquisar, btnConfiguracoes, btnConta;
		private JPanel pnLBLNotas, pnListaNotas;
		private JLabel lblNotas;
		private JPanel pnLBLListas, pnListaListas;
		private JPanel pnLBLQuadros, pnListaQuadros;
		private JLabel lblPergunta, lblMockupLogo;
		private String nome_perfil;
		private JTelaSessoes sessoes;
		
		public JTelaMenu (String nome_perfil, JTelaSessoes sessoes) {
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
			MatteBorder redBottomBorder7 = BorderFactory.createMatteBorder(0, 40, 0, 0, Color.WHITE);
		    Border compoundBorder7 = BorderFactory.createCompoundBorder(emptyBorder7, redBottomBorder7);
			lblNotas.setBorder(compoundBorder7);
	       
			pnListaNotas = new JPanel();
			FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 30, 0); // 20 pixels de espaçamento horizontal
			pnListaNotas.setLayout(flowLayout);
			pnListaNotas.setPreferredSize(new Dimension(1366, 160));
			pnListaNotas.setMaximumSize(new Dimension(1366,160));
			pnListaNotas.setBackground(Color.WHITE);
			
			pnBarra.add(lblMockupLogo);
			pnPrincipal.add(pnNotas, FlowLayout.LEFT);
			pnPrincipal.add(pnOpcoes, FlowLayout.LEFT);
			pnOpcoes.add(btn3linhas); 
			pnOpcoes.add(btnCronometro);
			pnOpcoes.add(btnAgenda);
			pnOpcoes.add(btnPesquisar);
			pnOpcoes.add(btnConfiguracoes);
			pnOpcoes.add(btnConta);
			pnLBLNotas.add(lblNotas);
			pnNotas.add(pnLBLNotas);
			pnNotas.add(pnListaNotas);
		}
	
		private void definirEventos() {
			NotaController notacontroller = new NotaController();
			if(!notacontroller.verificarSeTemNotas(nome_perfil)) {
			notacontroller.listarNotas(nome_perfil);
			List<JTelaListaNotas> notasPreparadas;
			notasPreparadas = new ArrayList<>();
			List<NotasVO> NotasProntas =notacontroller.NotasPreparadasdaCOnta();
			
			for(NotasVO notas : NotasProntas) {
				JTelaListaNotas blocos = new JTelaListaNotas(notas, sessoes);
				notasPreparadas.add(blocos);
			}
			for(JTelaListaNotas blocosProntos : notasPreparadas) {
				blocosProntos.setPreferredSize(new Dimension(150, 150));
				blocosProntos.setBorder(new LineBorder(Color.BLACK));
				pnListaNotas.add(blocosProntos);
			}
			
		} else {
			pnListaNotas.add(new JLabel("Adicione"));
		}
	}}
