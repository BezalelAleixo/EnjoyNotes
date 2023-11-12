package enj.appdesktop.vieww;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;

public class JTelaListaNotas extends JPanel {
    private JTextField tfTitulo;
    private JTextArea taConteudo;
    private NotasVO nota;
    private JTelaSessoes telaSessoes;
    private ContaVO conta;
    private JTelaMenu menu;

    public JTelaListaNotas(NotasVO nota, JTelaSessoes telaSessoes, ContaVO conta, JTelaMenu menu) {
        this.nota = nota;
        this.telaSessoes = telaSessoes;
        this.conta = conta;
        this.menu = menu;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setOpaque(false); // Tornar o painel transparente
        setPreferredSize(new Dimension(150, 150));
        setMaximumSize(new Dimension(150,150));
        setBackground(new Color(0x84CAED));
    }

    private void posicionandoComponentes() {
    	 Font fonte = new Font("Garet", Font.PLAIN, 20);
         tfTitulo = new JTextField(nota.getTitulo());
         tfTitulo.setFont(fonte);
         tfTitulo.setPreferredSize(new Dimension(150,20));
         tfTitulo.setBounds(5, 5, 140, 20);
         tfTitulo.setBackground(new Color(0x84CAED));
         tfTitulo.setEditable(false);
         tfTitulo.setBorder(new LineBorder(new Color(0x84CAED)));
         
         Font fonte2 = new Font("Garet", Font.PLAIN, 17);
         taConteudo = new JTextArea(nota.getContent());
         taConteudo.setFont(fonte2);
         taConteudo.setPreferredSize(new Dimension(150,130));
         taConteudo.setBounds(5, 25, 140, 120);
         taConteudo.setBackground(new Color(0x84CAED));
         taConteudo.setEditable(false);
         taConteudo.setBorder(new LineBorder(new Color(0x84CAED)));
         
         add(tfTitulo);
         add(taConteudo);
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
				JTelaAtualizaNotas note = new JTelaAtualizaNotas(conta, telaSessoes, nota);
				menu.AddTela(note);
			}
		});
    	
        tfTitulo.addMouseListener(new MouseListener() {
			
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
				tfTitulo.setForeground(Color.BLACK);
				taConteudo.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tfTitulo.setForeground(Color.WHITE);
				taConteudo.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTelaAtualizaNotas note = new JTelaAtualizaNotas(conta, telaSessoes, nota);
				menu.AddTela(note);
				
			}
		});
        taConteudo.addMouseListener(new MouseListener() {
			
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
				tfTitulo.setForeground(Color.BLACK);
				taConteudo.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tfTitulo.setForeground(Color.WHITE);
				taConteudo.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JTelaAtualizaNotas note = new JTelaAtualizaNotas(conta, telaSessoes, nota);
				menu.AddTela(note);
				
			}
		});
    }
    public NotasVO getNotas() {
    	return nota;
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

