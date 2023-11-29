package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.controller.CartaoController;
import enj.appdesktop.controller.Lista_Cartao_Controller;
import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.Lista_CartaoVO;

public class JCartaoQuadro extends JPanel {
    private JPanel pnBarra;
    private JTextField tfTitulo;
    private JButton btnAbrirCartao, btnEsquerda, btnDireita;
    private JFrame frame;
    
    private JBlocoListaQuadro parentBloco;
    private	CartaoVO cartao;
    private JTelaSessoes telaSessoes;
    private Lista_CartaoVO list;

    
    private boolean isBeingDragged = false;

    public JCartaoQuadro(CartaoVO cartao, JTelaSessoes telaSessoes, Lista_CartaoVO list) {
        this.cartao = cartao;
        this.telaSessoes = telaSessoes;
        this.list = list;
    	inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new FlowLayout());
        setOpaque(false);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(290, 60));
        setMaximumSize(new Dimension(290, 60));
    }

    private void posicionandoComponentes() {
        Font fonte = new Font("Garet", Font.PLAIN, 20);

        pnBarra = new JPanel();
        pnBarra.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnBarra.setPreferredSize(new Dimension(280, 50));
        pnBarra.setBackground(Color.WHITE);
        
        btnEsquerda = new JButton("<");
        btnEsquerda.setFont(fonte);
        btnEsquerda.setBackground(Color.WHITE);
        btnEsquerda.setPreferredSize(new Dimension(30, 50));
        btnEsquerda.setBorder(new EmptyBorder(0, 0, 0, 0));

        tfTitulo = new JTextField(cartao.getTitulo());
        tfTitulo.setFont(fonte);
        tfTitulo.setForeground(Color.BLACK);
        tfTitulo.setPreferredSize(new Dimension(190, 40));
        MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.RED);
        MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 10, 0, 0, Color.WHITE);
        Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
        tfTitulo.setBorder(compoundBorder);

        btnAbrirCartao = new JButton("A");
        btnAbrirCartao.setFont(fonte);
        btnAbrirCartao.setBackground(Color.WHITE);
        btnAbrirCartao.setPreferredSize(new Dimension(30, 30));
        btnAbrirCartao.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        btnDireita = new JButton(">");
        btnDireita.setFont(fonte);
        btnDireita.setBackground(Color.WHITE);
        btnDireita.setPreferredSize(new Dimension(30, 50));
        btnDireita.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        pnBarra.add(btnEsquerda);
        pnBarra.add(tfTitulo);
        pnBarra.add(btnAbrirCartao);
        pnBarra.add(btnDireita);

        add(pnBarra, FlowLayout.LEFT);


    }

    private void definirEventos() {
        btnAbrirCartao.addActionListener(e -> {
            JConfigCartao config = new JConfigCartao();
           
        });
        tfTitulo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                   CartaoController controller = new CartaoController();
                   controller.salvarCartao(tfTitulo.getText(), "", list.getId());
                   tfTitulo.setForeground(new Color(0x84CAED));
               
            }}
        });
        btnEsquerda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CartaoController controller = new CartaoController();
				int id_list = controller.Esquerda(list.getId());
				controller.atualizarCartao(cartao.getId(), tfTitulo.getText(), "", id_list);
				
			}
		});
        btnDireita.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CartaoController controller = new CartaoController();
				int id_list = controller.Direita(list.getId());
				controller.atualizarCartao(cartao.getId(), tfTitulo.getText(), "", id_list);
				
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

}
