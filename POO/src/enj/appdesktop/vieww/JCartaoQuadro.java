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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class JCartaoQuadro extends JPanel{
	private JPanel pnBarra;
	private JTextField tfTitulo;
	private JButton btnAbrirCartao;
	private JFrame frame;
	
	public JCartaoQuadro(JFrame frame) {
		this.frame = frame;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(new FlowLayout());
		setOpaque(false);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(290,60));
		setMaximumSize(new Dimension(290,60));
		
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Garet", Font.PLAIN, 20);
		
		pnBarra = new JPanel();
		pnBarra.setLayout(new BorderLayout());
		pnBarra.setPreferredSize(new Dimension(280,40));
		pnBarra.setBackground(Color.WHITE);
		
		tfTitulo = new JTextField("Título");
		tfTitulo.setFont(fonte);
		tfTitulo.setForeground(Color.BLACK);
		tfTitulo.setPreferredSize(new Dimension(250, 40));
		MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 10, 0, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        tfTitulo.setBorder(compoundBorder);
        
    	btnAbrirCartao = new JButton("A");
		btnAbrirCartao.setFont(fonte);
		btnAbrirCartao.setBackground(Color.WHITE);
		btnAbrirCartao.setPreferredSize(new Dimension(30, 30));
		btnAbrirCartao.setBorder(new EmptyBorder(0, 0, 0, 0));
        
		pnBarra.add(tfTitulo, BorderLayout.WEST);
		pnBarra.add(btnAbrirCartao, BorderLayout.EAST);
		
		
		add(pnBarra, FlowLayout.LEFT);
		
	}

	private void definirEventos() {
		btnAbrirCartao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JConfigCartao config = new JConfigCartao();
				frame.getContentPane().add(config);
				frame.revalidate();
				frame.repaint();
			}
		});
		
	}
	
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int width = getWidth();
	        int height = getHeight();

	        // Crie um formato com bordas curvas
	        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, width - 3, height - 3, 20, 20);

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
		
		JCartaoQuadro bloco = new JCartaoQuadro(frame);
		
		frame.add(bloco, FlowLayout.LEFT);
		frame.validate();
		
	}
}

