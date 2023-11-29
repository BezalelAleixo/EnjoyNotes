package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.controller.CartaoController;
import enj.appdesktop.controller.Lista_Cartao_Controller;
import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class JBlocoListaQuadro extends JPanel{
	private JPanel pnBarra, pnPrincipal, btnPanel;
	private JTextField tftitulo;
	private JButton btnAddCartão;
	private Lista_CartaoVO list_cartao;
	private JTelaSessoes telaSessoes;
	private QuadroVO quadro;
	int newAltur = 0;
	
	
	public JBlocoListaQuadro(Lista_CartaoVO list_cartao,JTelaSessoes telaSessoes, QuadroVO quadro) {
		this.list_cartao = list_cartao;
		this.telaSessoes = telaSessoes;
		this.quadro = quadro;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
		adicionarScrollPane();
	}

	private void inicializarComponentes() {
		setLayout(new FlowLayout());
		setOpaque(false);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300,100));
		setMaximumSize(new Dimension(300,100));
		
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Garet", Font.PLAIN, 20);
		
		pnBarra = new JPanel();
		pnBarra.setLayout(new BorderLayout());
		pnBarra.setPreferredSize(new Dimension(290,23));
		pnBarra.setBackground(Color.WHITE);
		
		tftitulo = new JTextField(list_cartao.getTitulo_list());
		tftitulo.setFont(fonte);
		tftitulo.setForeground(Color.BLACK);
		tftitulo.setPreferredSize(new Dimension(290, 23));
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 90, 0, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        tftitulo.setBorder(compoundBorder);
        
		pnBarra.add(tftitulo);
		
		pnPrincipal = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 0, 10);
		pnPrincipal.setLayout(flowLayout);
		pnPrincipal.setPreferredSize(new Dimension(290,60));
		pnPrincipal.setBackground(Color.WHITE);
		
		btnAddCartão = new JButton("Add+ Cartão");
		btnAddCartão.setFont(fonte);
		btnAddCartão.setBackground(Color.WHITE);
		btnAddCartão.setPreferredSize(new Dimension(290,60));
		btnAddCartão.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		
		
	    
		
        
		add(pnBarra, FlowLayout.LEFT);
		add(pnPrincipal, FlowLayout.CENTER);
		
	}

	private void definirEventos() {
		
		CartaoController controller = new CartaoController();
		controller.listarListas(list_cartao.getTitulo_list());
		List<JCartaoQuadro> cartoesPreparadas;
		cartoesPreparadas = new ArrayList<>();
		List<CartaoVO> cartoesProntas = controller.ListasPreparadasdaCOnta();
		
		for(CartaoVO cartoes : cartoesProntas) {
			JCartaoQuadro blocos = new JCartaoQuadro(cartoes, telaSessoes, list_cartao);
			cartoesPreparadas.add(blocos);
		}

		for (JCartaoQuadro blocosProntos : cartoesPreparadas) {
		    pnPrincipal.add(blocosProntos);
		    newAltur = newAltur + blocosProntos.getPreferredSize().height;
		}
		pnPrincipal.add(btnAddCartão);
		int novaAltura = newAltur+btnAddCartão.getPreferredSize().height;
		
		setPreferredSize(new Dimension(300, 100+novaAltura));
		setMaximumSize(new Dimension(300, 100+novaAltura));
		
		pnPrincipal.setPreferredSize(new Dimension(290, 60+novaAltura));
		pnPrincipal.setMaximumSize(new Dimension(290, 60+novaAltura));
		
		
		
		
		btnAddCartão.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CartaoVO cart = new CartaoVO("", "", list_cartao.getId());
				JCartaoQuadro cartao = new JCartaoQuadro(cart, telaSessoes,list_cartao);
	            pnPrincipal.add(cartao);
	            pnPrincipal.add(btnAddCartão);

	            int newAltura = pnPrincipal.getPreferredSize().height+btnAddCartão.getHeight();

	            newAltura += cartao.getPreferredSize().height;
	            
	            int diminui = 40;
	            diminui += 10;

	            pnPrincipal.setPreferredSize(new Dimension(pnPrincipal.getWidth(), newAltura-diminui));
	            pnPrincipal.setMaximumSize(new Dimension(pnPrincipal.getWidth(), newAltura-diminui));

	            revalidate();
	            repaint();

	            int novaAltura = getPreferredSize().height+btnAddCartão.getHeight();

	            novaAltura += cartao.getPreferredSize().height;

	            setPreferredSize(new Dimension(300, novaAltura-diminui));
	            setMaximumSize(new Dimension(300, novaAltura-diminui));

	            revalidate();
	            repaint();
			
			}
		});
		 tftitulo.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    Lista_Cartao_Controller controller = new Lista_Cartao_Controller();
	                    controller.salvarLista(tftitulo.getText(), quadro.getId());
	                    tftitulo.setForeground(new Color(0x84CAED));
	                    revalidate();
	                    repaint();
	               
	            }}
	        });
	}
	
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int width = getWidth();
	        int height = getHeight();

	        // Crie um formato com bordas curvas
	        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, 20, 20);

	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setColor(getBackground());
	        g2d.fill(roundedRectangle);
	        g2d.setColor(getForeground());
	        g2d.draw(roundedRectangle);
	    }
	 


	 private void reajustarAltura() {
		    int novaAltura = 0;

		    // Adiciona a altura dos filhos do pnPrincipal
		    for (Component component : pnPrincipal.getComponents()) {
		        novaAltura += component.getPreferredSize().height;
		    }

		    // Adiciona a altura do btnAddCartão
		    novaAltura += btnAddCartão.getHeight();

		   

		    // Define as dimensões e repinta o componente
		    setPreferredSize(new Dimension(300, novaAltura));
		    setMaximumSize(new Dimension(300, novaAltura));

		    revalidate();
		    repaint();
		}
	 

		
		private void adicionarScrollPane() {
	        // Adicione o pnPrincipal a um JScrollPane
	        JScrollPane scrollPane = new JScrollPane(pnPrincipal);
	        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
	        
	        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	        // Adicione o JScrollPane ao painel principal
	        add(scrollPane, BorderLayout.CENTER);
	    
		}
            
}        
