package enj.appdesktop.vieww;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.*;
import java.awt.event.*;


import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;


public class JTelaNotas extends JPanel {
    private JTextField tfTitulo;
    private JTextArea taConteudo;
    private ContaVO conta;
    private JTelaSessoes telaSessoes;
    private NotasVO nota;
    private JButton btnLembrar, btnCor, btnAddImagem, btnArquivar, btn3pontos, btnFechar, btnFixarNota;
    int novaPosicao = 70;

    public JTelaNotas(ContaVO conta, JTelaSessoes telaSessoes, NotasVO nota) {
        this.conta = conta;
        this.telaSessoes = telaSessoes;
        this.nota = nota;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setOpaque(false); // Tornar o painel transparente
        setPreferredSize(new Dimension(610, 100));
        setMaximumSize(new Dimension(610,100));
        setBackground(new Color(0x84CAED));
    }

    private void posicionandoComponentes() {
    	 Font fonte = new Font("Garet", Font.PLAIN, 20);
         tfTitulo = new JTextField(nota.getTitulo());
         tfTitulo.setFont(fonte);
         tfTitulo.setPreferredSize(new Dimension(515,20));
         tfTitulo.setBounds(15, 10, 515, 20);
         tfTitulo.setBackground(new Color(0x84CAED));
         tfTitulo.setBorder(new LineBorder(new Color(0x84CAED)));
         
         Font fonte2 = new Font("Garet", Font.PLAIN, 17);
         taConteudo = new JTextArea(nota.getContent());
         taConteudo.setFont(fonte2);
         taConteudo.setBounds(15, 45, 580, 21);
         taConteudo.setBackground(new Color(0x84CAED));
      //   taConteudo.setBorder(new LineBorder(Color.WHITE));
         
         btnFixarNota = new JButton("Fixar");
         btnFixarNota.setFont(fonte2);
         btnFixarNota.setPreferredSize(new Dimension(60, 17));
         btnFixarNota.setBounds(535, 10, 60,17);
         btnFixarNota.setBackground(new Color(0x84CAED));
         btnFixarNota.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btnLembrar = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\btnLembrar.png"));
         btnLembrar.setPreferredSize(new Dimension(21, 28));
         btnLembrar.setBounds(15, 70, 21, 28);
         btnLembrar.setBackground(new Color(0x84CAED));
         //btnLembrar.setBorder(new LineBorder(Color.WHITE));
         
         btnCor = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\btnLembrar.png"));
         btnCor.setPreferredSize(new Dimension(21, 28));
         btnCor.setBounds(46, 70, 21, 28);
         btnCor.setBackground(new Color(0x84CAED));
         //btnLembrar.setBorder(new LineBorder(Color.WHITE));

         btnAddImagem = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\btnLembrar.png"));
         btnAddImagem.setPreferredSize(new Dimension(21, 28));
         btnAddImagem.setBounds(77, 70, 21, 28);
         btnAddImagem.setBackground(new Color(0x84CAED));
         //btnLembrar.setBorder(new LineBorder(Color.WHITE));
         
         btnArquivar = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\btnLembrar.png"));
         btnArquivar.setPreferredSize(new Dimension(21, 28));
         btnArquivar.setBounds(108, 70, 21, 28);
         btnArquivar.setBackground(new Color(0x84CAED));
         //btnLembrar.setBorder(new LineBorder(Color.WHITE));
         
         btn3pontos = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\btnLembrar.png"));
         btn3pontos.setPreferredSize(new Dimension(21, 28));
         btn3pontos.setBounds(139, 70, 21, 28);
         btn3pontos.setBackground(new Color(0x84CAED));
         //btnLembrar.setBorder(new LineBorder(Color.WHITE));
         
         btnFechar = new JButton("fechar");
         btnFechar.setPreferredSize(new Dimension(60, 17));
         btnFechar.setFont(fonte2);
         btnFechar.setBounds(535, 70, 60, 17);
         btnFechar.setBackground(new Color(0x84CAED));
         btnFechar.setBorder(new LineBorder(new Color(0x84CAED)));
         
         Font fonte3 = new Font("Arial", Font.PLAIN, 17);
         taConteudo.setFont(fonte3);

         // Obtém a altura da fonte
         //FontMetrics fontMetrics = taConteudo.getFontMetrics(fonte3);
         //int alturaDaLinha = fontMetrics.getHeight();

         // Agora, alturaDaLinha conterá a altura aproximada de uma linha
        // System.out.println("Altura da Linha: " + alturaDaLinha);
         

         
         add(tfTitulo);
         add(taConteudo);
         add(btnFixarNota);
         add(btnLembrar);
         add(btnCor);
         add(btnAddImagem);
         add(btnArquivar);
         add(btn3pontos);
         add(btnFechar);
    }

    private void definirEventos() {
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
				//tfTitulo.setForeground(Color.BLACK);
			///	taConteudo.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				//tfTitulo.setForeground(Color.WHITE);
				//taConteudo.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
				///tfTitulo.setForeground(Color.BLACK);
				//taConteudo.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				//tfTitulo.setForeground(Color.WHITE);
				//taConteudo.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        taConteudo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    aumentarAltura();
                }
           
            }
        private void aumentarAltura() {
            int novaAltura = taConteudo.getPreferredSize().height;
                // Ajusta a altura do JTextArea
                novaAltura = novaAltura + 21;
                taConteudo.setBounds(15, 45, 580, novaAltura);

                // Ajusta a altura do painel JTelaNotas
                int novaAlturaPainel = getPreferredSize().height;
                novaAlturaPainel = novaAlturaPainel+21;
                setPreferredSize(new Dimension(getWidth(), novaAlturaPainel));
                setMaximumSize(new Dimension(getWidth(), novaAlturaPainel));

                novaPosicao = novaPosicao + 21;

                btnLembrar.setBounds(15, novaPosicao, 21, 28);
                btnCor.setBounds(46, novaPosicao, 21, 28);
                btnAddImagem.setBounds(77, novaPosicao, 21, 28);
                btnArquivar.setBounds(108, novaPosicao, 21, 28);
                btn3pontos.setBounds(139, novaPosicao, 21, 28);
                btnFechar.setBounds(535, novaPosicao, 60, 17);

                revalidate();
                repaint();
            }
        
        });
        taConteudo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    String text = taConteudo.getText();
                    int caretPosition = taConteudo.getCaretPosition();
                    
                    // Verifica se uma quebra de linha foi removida
                    if (text.contains("\n") && text.charAt(caretPosition - 1) == '\n') {
                        diminuirAltura();
                    } else {
                    }
                }
            }
        });
        
    }
    private void diminuirAltura() {
    	 try {
    	        int novaAltura = taConteudo.getPreferredSize().height;
    	            novaAltura = novaAltura - 21;
    	            taConteudo.setBounds(15, 45, 580, novaAltura);

    	            int novaAlturaPainel = getPreferredSize().height;
    	            novaAlturaPainel = novaAlturaPainel-21;
    	            setPreferredSize(new Dimension(getWidth(), novaAlturaPainel));
    	            setMaximumSize(new Dimension(getWidth(), novaAlturaPainel));

    	            novaPosicao = novaPosicao - 21;

    	            btnLembrar.setBounds(15, novaPosicao, 21, 28);
    	            btnCor.setBounds(46, novaPosicao, 21, 28);
    	            btnAddImagem.setBounds(77, novaPosicao, 21, 28);
    	            btnArquivar.setBounds(108, novaPosicao, 21, 28);
    	            btn3pontos.setBounds(139, novaPosicao, 21, 28);
    	            btnFechar.setBounds(535, novaPosicao, 60, 17);

    	            revalidate();
    	            repaint();
    	            
    	    }  catch (Exception ex) {
    	        ex.printStackTrace();
    	    }
    	
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
    	    frame.setPreferredSize(new Dimension(1366, 640));
    	    
    	    
    	    ContaVO nota = new ContaVO();
    	    nota.setId_conta(1);
    	    nota.setNome_perfil("One piece");
    	    nota.setSenha("oi");
    	    nota.setFoto("D:\\projetoENjoyNotes\\botaoCronometro.png");
    	    JTelaSessoes sessoes = new JTelaSessoes(); 
    	    NotasVO nn = new NotasVO();
    	    JTelaNotas curvedListaNotas = new JTelaNotas(nota, sessoes, nn);
    	    
    	    // Configura o layout do JFrame para FlowLayout
    	    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

    	    frame.add(curvedListaNotas);
    	    frame.pack();
    	    frame.setVisible(true);
	}
}

