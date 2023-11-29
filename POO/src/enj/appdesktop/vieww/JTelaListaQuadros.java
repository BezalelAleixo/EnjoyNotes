package enj.appdesktop.vieww;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;
import enj.appdesktop.model.vo.QuadroVO;

public class JTelaListaQuadros extends JPanel {
    private JLabel lblTitulo;
    private JTelaSessoes telaSessoes;
    private ContaVO conta;
    private QuadroVO quadro;
    private JTelaQuadros telaquadros;

    public JTelaListaQuadros(ContaVO conta, QuadroVO quadro, JTelaSessoes telaSessoes, JTelaQuadros telaquadros) {
        this.conta = conta;
        this.quadro = quadro;
        this.telaSessoes = telaSessoes;
        this.telaquadros = telaquadros;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }


	private void inicializarComponentes() {
        setLayout(null);
        setOpaque(false); 
        setPreferredSize(new Dimension(225, 50));
        setMaximumSize(new Dimension(225, 50));
        setBackground(Color.decode("0xFFFFFF"));
    }

    private void posicionandoComponentes() {
    	 Font fonte = new Font("Garet", Font.PLAIN, 20);
         lblTitulo = new JLabel(quadro.getNome_quad());
         lblTitulo.setFont(fonte);
         lblTitulo.setPreferredSize(new Dimension(150,20));
         lblTitulo.setBounds(5, 5, 150, 30);
         lblTitulo.setBackground(Color.decode("0x000000"));
         lblTitulo.setBorder(new LineBorder(Color.decode("0xFFFFFF")));
         
        
         
         add(lblTitulo);
      
    }

    private void definirEventos() {
    	addMouseListener(new MouseListener() {
			
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
				telaquadros.getPrincipal().removeAll();
				JTelaListaDeCartoes list_cartoes = new JTelaListaDeCartoes(telaquadros, telaSessoes, quadro);
				telaquadros.getPrincipal().add(list_cartoes);
				telaquadros.revalidate();
				telaquadros.repaint();
			}
		});
    	
        lblTitulo.addMouseListener(new MouseListener() {
			
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
				lblTitulo.setForeground(Color.BLACK);
			
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTitulo.setForeground(Color.WHITE);
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				telaquadros.getPrincipal().removeAll();
				JTelaListaDeCartoes list_cartoes = new JTelaListaDeCartoes(telaquadros, telaSessoes, quadro);
				telaquadros.getPrincipal().add(list_cartoes);
				telaquadros.revalidate();
				telaquadros.repaint();
			}
		});
    
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
    	 JFrame frame = new JFrame("Teste CurvedJTelaListaNotas");
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.setPreferredSize(new Dimension(300, 300));
    	    
    	    NotasVO nota = new NotasVO();
    	    nota.setTitulo("Bezalel");
    	    nota.setContent("One piece");
    	    JTelaSessoes sessoes = new JTelaSessoes(); // Substitua isso pelo construtor correto da sua classe JTelaSessoes
    	  //  JTelaListaNotas curvedListaNotas = new JTelaListaNotas(nota, sessoes);
    	    
    	    // Configura o layout do JFrame para FlowLayout
    	    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

    	    //frame.add(curvedListaNotas);
    	    frame.pack();
    	    frame.setVisible(true);
	}
}

