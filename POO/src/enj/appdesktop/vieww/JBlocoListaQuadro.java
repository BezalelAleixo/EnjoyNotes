package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class JBlocoListaQuadro extends JPanel{
	private JPanel pnBarra, pnPrincipal, btnPanel;
	private JLabel lbltitulo;
	private JButton btnAddCartão;
	private JFrame frame;
	
	public JBlocoListaQuadro(JFrame frame) {
		this.frame = frame;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
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
		
		lbltitulo = new JLabel("Caneta Azul");
		lbltitulo.setFont(fonte);
		lbltitulo.setForeground(Color.BLACK);
		lbltitulo.setPreferredSize(new Dimension(290, 23));
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 90, 0, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        lbltitulo.setBorder(compoundBorder);
        
		pnBarra.add(lbltitulo);
		
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
		
		pnPrincipal.add(btnAddCartão, FlowLayout.LEFT);
		
	    
		
        
		add(pnBarra, FlowLayout.LEFT);
		add(pnPrincipal, FlowLayout.CENTER);
		
	}

	private void definirEventos() {
		btnAddCartão.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCartaoQuadro cartao = new JCartaoQuadro(frame);
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
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1366,768));
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JBlocoListaQuadro bloco = new JBlocoListaQuadro(frame);
		
		frame.add(bloco, FlowLayout.LEFT);
		frame.validate();
		
	}
}
