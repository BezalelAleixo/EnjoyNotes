package enj.appdesktop.vieww;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class JConfigCartao extends JPanel{
	private JPanel pnBarra, pnPrincipal;
	private JLabel lbltitulo;
	private JButton btnSalvar;
	private JTextArea taDescricao;
	
	public JConfigCartao() {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(new FlowLayout());
		setOpaque(false);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,400));
		setMaximumSize(new Dimension(500,400));
		
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Garet", Font.PLAIN, 20);
		Font fonte2 = new Font("Garet", Font.PLAIN, 17);
		
		pnBarra = new JPanel();
		pnBarra.setLayout(new BorderLayout());
		pnBarra.setPreferredSize(new Dimension(490,23));
		pnBarra.setBackground(Color.WHITE);
		
		lbltitulo = new JLabel("Caneta Azul");
		lbltitulo.setFont(fonte);
		lbltitulo.setForeground(Color.BLACK);
		lbltitulo.setPreferredSize(new Dimension(450, 23));
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 40, 0, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        lbltitulo.setBorder(compoundBorder);
        
        btnSalvar = new JButton("(ºuº)");
        btnSalvar.setFont(fonte);
        btnSalvar.setPreferredSize(new Dimension(40,23));
        btnSalvar.setBackground(Color.WHITE);
        btnSalvar.setBorder(new EmptyBorder(0, 0, 0, 0));
        
		pnBarra.add(lbltitulo, BorderLayout.WEST);
		pnBarra.add(btnSalvar, BorderLayout.EAST);
		
		pnPrincipal = new JPanel();
		FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 10);
		pnPrincipal.setLayout(flowLayout);
		pnPrincipal.setPreferredSize(new Dimension(490,357));
		pnPrincipal.setBackground(Color.WHITE);
		
		taDescricao = new JTextArea();
		taDescricao.setFont(fonte2);
		taDescricao.setPreferredSize(new Dimension(480, 357));
		
		pnPrincipal.add(taDescricao, FlowLayout.LEFT);
		
        
		add(pnBarra, FlowLayout.LEFT);
		add(pnPrincipal, FlowLayout.CENTER);
	}

	private void definirEventos() {
		
		
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
		
		JConfigCartao bloco = new JConfigCartao();
		
		frame.add(bloco, FlowLayout.LEFT);
		frame.validate();
		
	}
}
