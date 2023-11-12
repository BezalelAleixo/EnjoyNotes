package enj.appdesktop.vieww;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.*;
import java.awt.event.*;

import enj.appdesktop.controller.NotaController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;


public class JTelaAtualizaNotas extends JPanel {
    private JTextField tfTitulo;
    private JTextArea taConteudo;
    private ContaVO conta;
    private JTelaSessoes telaSessoes;
    private NotasVO nota;
    private JButton btnLembrar, btnCor, btnAddImagem, btnArquivar, btn3pontos, btnFechar, btnFixarNota;
    private Font customFont;
    private Font customFont2;
    int novaPosicao = 47;

    public JTelaAtualizaNotas(ContaVO conta, JTelaSessoes telaSessoes, NotasVO nota) {
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
       
        setBackground(new Color(0x84CAED));
    }

    private void posicionandoComponentes() {
    	 Font fonte = new Font("Garet", Font.PLAIN, 20);
    	 try {
             customFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\AleixoUNI\\BEZALEL\\Fontes\\font-awesome-4.7.0\\font-awesome-4.7.0\\fonts\\FontAwesome.otf")).deriveFont(30f);       
         } catch (IOException | FontFormatException e) {
             e.printStackTrace();
         }
    	 try {
             customFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\AleixoUNI\\BEZALEL\\Fontes\\font-awesome-4.7.0\\font-awesome-4.7.0\\fonts\\FontAwesome.otf")).deriveFont(20f);       
         } catch (IOException | FontFormatException e) {
             e.printStackTrace();
         }
    	 
         tfTitulo = new JTextField(nota.getTitulo());
         tfTitulo.setFont(fonte);
         tfTitulo.setBounds(15, 10, 515, 20);
         tfTitulo.setBackground(new Color(0x84CAED));
         tfTitulo.setBorder(new LineBorder(new Color(0x84CAED)));
         
         
         
         Font fonte2 = new Font("Garet", Font.PLAIN, 17);
         taConteudo = new JTextArea(nota.getContent());
         taConteudo.setFont(fonte2);
         int numeroDeLinhas = taConteudo.getLineCount();
         // Obtém a altura da fonte
         FontMetrics fontMetrics = taConteudo.getFontMetrics(taConteudo.getFont());
         int alturaDaLinha = fontMetrics.getHeight();
         // Calcula o total do tamanho das alturas das linhas
         int totalAltura = numeroDeLinhas * alturaDaLinha;
         // Faça o que quiser com o totalAltura
         System.out.println("Número de Linhas: " + numeroDeLinhas);
         System.out.println("Total do Tamanho das Alturas: " + totalAltura);
         taConteudo.setBounds(15, 45, 580, totalAltura);
         taConteudo.setBackground(new Color(0x84CAED));
      //   taConteudo.setBorder(new LineBorder(Color.WHITE));
         
         setPreferredSize(new Dimension(610, 77+totalAltura));
         setMaximumSize(new Dimension(610,77+totalAltura));
        
         btnFixarNota = new JButton("\uf08d");
         btnFixarNota.setFont(customFont);
         btnFixarNota.setBounds(535, 10, 60,30);
         btnFixarNota.setForeground(Color.BLACK);
         btnFixarNota.setBackground(new Color(0x84CAED));
         btnFixarNota.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btnLembrar = new JButton("\uf0a2");
         btnLembrar.setFont(customFont2);
         btnLembrar.setBounds(15, 47+totalAltura, 25, 25);
         btnLembrar.setBackground(new Color(0x84CAED));
         btnLembrar.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btnCor = new JButton("\uf1fc");
         btnCor.setFont(customFont2);
         btnCor.setBounds(50, 47+totalAltura, 25, 25);
         btnCor.setBackground(new Color(0x84CAED));
         btnCor.setBorder(new LineBorder(new Color(0x84CAED)));

         btnAddImagem = new JButton("\uf03e");
         btnAddImagem.setFont(customFont2);
         btnAddImagem.setBounds(85, 47+totalAltura, 25, 25);
         btnAddImagem.setBackground(new Color(0x84CAED));
         btnAddImagem.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btnArquivar = new JButton("\uf187");
         btnArquivar.setBounds(120, 47+totalAltura, 25, 25);
         btnArquivar.setFont(customFont2);
         btnArquivar.setBackground(new Color(0x84CAED));
         btnArquivar.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btn3pontos = new JButton("\uf142");
         btn3pontos.setFont(customFont2);
         btn3pontos.setBounds(155, 47+totalAltura, 25, 25);
         btn3pontos.setBackground(new Color(0x84CAED));
         btn3pontos.setBorder(new LineBorder(new Color(0x84CAED)));
         
         btnFechar = new JButton("Fechar");
         btnFechar.setFont(fonte2);
         btnFechar.setBounds(535, 47+totalAltura, 60, 17);
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
    	btnFechar.addMouseListener(new MouseListener() {
			
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
				btnFechar.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFechar.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				NotaController note = new NotaController();
				int id_nota = nota.getId();
				String titulo = tfTitulo.getText();
				String conteudo = taConteudo.getText();
				note.atualizarNota(id_nota, titulo, conteudo);
				
				String nome_perfil = conta.getNome_perfil();
				telaSessoes.getContentpane().removeAll();
				JTelaMenu menu = new JTelaMenu(conta, nome_perfil, telaSessoes);
				telaSessoes.getContentpane().add(menu, BorderLayout.CENTER);
				telaSessoes.revalidate(); // Atualiza o layout para exibir a nova tela
		        telaSessoes.repaint();
				
			}
		});
    	btn3pontos.addMouseListener(new MouseListener() {
			
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
				btn3pontos.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn3pontos.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	btnArquivar.addMouseListener(new MouseListener() {
			
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
				btnArquivar.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnArquivar.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	btnAddImagem.addMouseListener(new MouseListener() {
			
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
				btnAddImagem.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddImagem.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	btnCor.addMouseListener(new MouseListener() {
			
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
				btnCor.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCor.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
    	btnFixarNota.addMouseListener(new MouseListener() {
			
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
				Color clik = btnFixarNota.getForeground();
				if( clik == Color.BLACK) {
					btnFixarNota.setForeground(Color.WHITE);
				}else if(clik == Color.WHITE) {
					btnFixarNota.setForeground(Color.BLACK);
				}
				
			}
		});
    	btnLembrar.addMouseListener(new MouseListener() {
			
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
				String clik = btnLembrar.getText();
				if(clik == "\uf0a2") {
					btnLembrar.setText("\uf0f3");
				}else if(clik == "\uf0f3") {
					btnLembrar.setText("\uf0a2");
				}
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

                novaPosicao = btn3pontos.getY();
                novaPosicao = novaPosicao + 21;

                btnLembrar.setBounds(15, novaPosicao, 25, 25);
                btnCor.setBounds(50, novaPosicao, 25, 25);
                btnAddImagem.setBounds(85, novaPosicao, 25, 25);
                btnArquivar.setBounds(120, novaPosicao, 25, 25);
                btn3pontos.setBounds(155, novaPosicao, 25, 25);
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

    	            novaPosicao = btn3pontos.getY();
                    novaPosicao = novaPosicao - 21;

                    btnLembrar.setBounds(15, novaPosicao, 25, 25);
                    btnCor.setBounds(50, novaPosicao, 25, 25);
                    btnAddImagem.setBounds(85, novaPosicao, 25, 25);
                    btnArquivar.setBounds(120, novaPosicao, 25, 25);
                    btn3pontos.setBounds(155, novaPosicao, 25, 25);
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
    	    nn.setTitulo("testando");
    	    nn.setContent("como\nvai \n\n\n\n\n\nBezalel?");
    	    JTelaAtualizaNotas curvedListaNotas = new JTelaAtualizaNotas(nota, sessoes, nn);
    	    
    	    // Configura o layout do JFrame para FlowLayout
    	    frame.setLayout(new FlowLayout(FlowLayout.CENTER));

    	    frame.add(curvedListaNotas);
    	    frame.pack();
    	    frame.setVisible(true);
	}
}

