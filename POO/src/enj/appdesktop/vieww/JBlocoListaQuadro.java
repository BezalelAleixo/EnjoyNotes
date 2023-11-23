package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JBlocoListaQuadro extends JPanel{
	private JPanel pnBarra, pnPrincipal;
	private JLabel lbltitulo;
	
	public JBlocoListaQuadro() {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(new FlowLayout());
		setOpaque(false);
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(300,500));
		setMaximumSize(new Dimension(300,500));
	}

	private void posicionandoComponentes() {
		
		
	}

	private void definirEventos() {
		
		
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        // Crie um formato com bordas curvas
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getBackground());
        g2d.fill(roundedRectangle);
    }
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(1366,768));
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		
		JBlocoListaQuadro bloco = new JBlocoListaQuadro();
		
		frame.add(bloco, FlowLayout.LEFT);
		frame.validate();
		
	}
}
