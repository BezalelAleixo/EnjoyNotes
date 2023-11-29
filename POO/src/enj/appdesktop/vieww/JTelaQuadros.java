package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.controller.NotaController;
import enj.appdesktop.controller.QuadroController;
import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.NotasVO;
import enj.appdesktop.model.vo.QuadroVO;

public class JTelaQuadros extends JPanel{
	private JPanel pnBarra, pnPrincipal, pnColuna, pnQuadros;
	private JLabel lblMockupLogo;
	private JButton btnNovoQuadro, btnCriarLista;
	private JButton btnVoltarMenu;
	private ContaVO conta;
    private JTelaSessoes telaSessoes;
  
	
	public static JTelaConfigurações frame;

	
	public JTelaQuadros(ContaVO conta, JTelaSessoes telaSessoes) {
		this.conta = conta;
		this.telaSessoes = telaSessoes;
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
        MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 10, 0, new Color(0x84CAED));
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        pnBarra.setBorder(compoundBorder);
		
        pnPrincipal = new JPanel();
        FlowLayout flowLayoutLEFT = new FlowLayout(FlowLayout.LEFT, 20, 10);
        pnPrincipal.setLayout(flowLayoutLEFT);
        pnPrincipal.setBackground(new Color(0x84CAED));
        
        
        pnColuna = new JPanel();
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 20);
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
        
        pnQuadros = new JPanel();
        pnQuadros.setLayout(flowLayout);
        pnQuadros.setPreferredSize(new Dimension(250, 660));
        pnQuadros.setBackground(new Color(0x345389));
        
        
       
        
       add(pnBarra, BorderLayout.NORTH);
       add(pnPrincipal, BorderLayout.CENTER);
       add(scrollPane, BorderLayout.WEST);
	}

	private void posicionandoComponentes() {
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(60, 17, 139, 77);
		
		Font fonte = new Font("Bernoru", Font.BOLD, 17);
		Font fonte2 = new Font("Garet", Font.PLAIN, 30);
		
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        
		btnNovoQuadro = new JButton("Novo +");
		btnNovoQuadro.setFont(fonte);
		btnNovoQuadro.setBackground(pnColuna.getBackground());
		btnNovoQuadro.setPreferredSize(new Dimension(225,30));
		btnNovoQuadro.setBorder(compoundBorder);
		btnNovoQuadro.setForeground(Color.WHITE);
		
		btnCriarLista = new JButton("Criar Lista");
		btnCriarLista.setFont(fonte);
		btnCriarLista.setBackground(new Color(0x84CAED));
		btnCriarLista.setPreferredSize(new Dimension(225,40));
		btnCriarLista.setMaximumSize(new Dimension(225,40));
		btnCriarLista.setBorder(new LineBorder(Color.WHITE));
		btnCriarLista.setForeground(Color.WHITE);
		
		
		btnVoltarMenu = new JButton("<<");
		btnVoltarMenu.setFont(fonte2);
		btnVoltarMenu.setBackground(pnBarra.getBackground());
		btnVoltarMenu.setBounds(20, 37, 42, 35);
		btnVoltarMenu.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnVoltarMenu.setForeground(Color.WHITE);
		
		pnBarra.add(lblMockupLogo);
		pnBarra.add(btnVoltarMenu);
		pnColuna.add(btnNovoQuadro);
		pnColuna.add(pnQuadros);

		
		
		pnPrincipal.add(btnCriarLista);
		
		
	}

	private void definirEventos() {
		
		QuadroController quadrocontroller = new QuadroController();
		quadrocontroller.listarListas(conta.getNome_perfil());
		List<JTelaListaQuadros> quadrosPreparadas;
		quadrosPreparadas = new ArrayList<>();
		List<QuadroVO> QuadrosProntas =quadrocontroller.ListasPreparadasdaCOnta();
		
		for(QuadroVO quadro : QuadrosProntas) {
			JTelaListaQuadros blocos = new JTelaListaQuadros(conta, quadro, telaSessoes, JTelaQuadros.this);
			quadrosPreparadas.add(blocos);
		}

		for (JTelaListaQuadros blocosProntos : quadrosPreparadas) {
		    pnQuadros.add(blocosProntos);
		}
		
		btnCriarLista.addMouseListener(new MouseListener() {
			
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
				
			}
		});
		
		btnNovoQuadro.addMouseListener(new MouseListener() {
			
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
			    btnNovoQuadro.setBorder(compoundBorder);
			    btnNovoQuadro.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
				MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
			    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
			    btnNovoQuadro.setBorder(compoundBorder);
			    btnNovoQuadro.setForeground(new Color(0x84CAED));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTelaCriarQuadro quadro = new JTelaCriarQuadro(conta, telaSessoes);
				pnPrincipal.removeAll();
				pnPrincipal.add(quadro);
				pnPrincipal.revalidate();
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
				String nome_perfil = conta.getNome_perfil();
				telaSessoes.getContentpane().removeAll();
                JTelaMenu telaMenu = new JTelaMenu(conta, nome_perfil, telaSessoes);
                telaSessoes.getContentpane().add(telaMenu, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
				
			}
		});
	}
	public JPanel getPrincipal() {
		return pnPrincipal;
	}
}
