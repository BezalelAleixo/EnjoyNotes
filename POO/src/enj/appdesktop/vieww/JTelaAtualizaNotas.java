package enj.appdesktop.vieww;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.event.*;

import enj.appdesktop.controller.NotaController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;
import jnafilechooser.api.JnaFileChooser;


public class JTelaAtualizaNotas extends JPanel {
    private JTextField tfTitulo;
    private JTextArea taConteudo;
    private ContaVO conta;
    private JTelaSessoes telaSessoes;
    private NotasVO nota;
    private JPanel pnBotoesCor;
    private JButtonCircular btcAzul, btcBranco, btcVerde, btcLaranja;
    private JButton btnLembrar, btnCor, btnAddImagem, btnArquivar, btn3pontos, btnFechar, btnFixarNota;
    private Font customFont;
    private Font customFont2;
    private JLabel lblImagem;
    int novaPosicao = 47;
    String caminho;

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
       
        setBackground(Color.decode(nota.getCor()));
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
         tfTitulo.setBackground(Color.decode(nota.getCor()));
         tfTitulo.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         
         
         Font fonte2 = new Font("Garet", Font.PLAIN, 17);
         taConteudo = new JTextArea(nota.getContent());
         taConteudo.setFont(fonte2);
         int numeroDeLinhas = taConteudo.getLineCount();
         // Obtém a altura da fonte
         FontMetrics fontMetrics = taConteudo.getFontMetrics(taConteudo.getFont());
         int alturaDaLinha = fontMetrics.getHeight();
         // Calcula o total do tamanho das alturas das linhas
         int totalAltura = numeroDeLinhas * alturaDaLinha;
         taConteudo.setBounds(15, 45, 580, totalAltura);
         taConteudo.setBackground(Color.decode(nota.getCor()));
      //   taConteudo.setBorder(new LineBorder(Color.WHITE));
         lblImagem = new JLabel(new ImageIcon(nota.getFoto()));
         lblImagem.setBorder(new LineBorder(Color.WHITE));
         lblImagem.setBounds(15, 47+totalAltura, lblImagem.getIcon().getIconWidth(), lblImagem.getIcon().getIconHeight());
         
         
         
         setPreferredSize(new Dimension(610, 77+totalAltura+lblImagem.getIcon().getIconHeight()+20));
         setMaximumSize(new Dimension(610,77+totalAltura+lblImagem.getIcon().getIconHeight()+20));
        
         btnFixarNota = new JButton("\uf08d");
         btnFixarNota.setFont(customFont);
         btnFixarNota.setBounds(535, 10, 60,30);
         btnFixarNota.setForeground(Color.BLACK);
         btnFixarNota.setBackground(Color.decode(nota.getCor()));
         btnFixarNota.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         btnLembrar = new JButton("\uf0a2");
         btnLembrar.setFont(customFont2);
         btnLembrar.setBounds(15, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 25, 25);
         btnLembrar.setBackground(Color.decode(nota.getCor()));
         btnLembrar.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         btnCor = new JButton("\uf1fc");
         btnCor.setFont(customFont2);
         btnCor.setBounds(50, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 25, 25);
         btnCor.setBackground(Color.decode(nota.getCor()));
         btnCor.setBorder(new LineBorder(Color.decode(nota.getCor())));

         btnAddImagem = new JButton("\uf03e");
         btnAddImagem.setFont(customFont2);
         btnAddImagem.setBounds(85, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 25, 25);
         btnAddImagem.setBackground(Color.decode(nota.getCor()));
         btnAddImagem.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         btnArquivar = new JButton("\uf187");
         btnArquivar.setBounds(120, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 25, 25);
         btnArquivar.setFont(customFont2);
         btnArquivar.setBackground(Color.decode(nota.getCor()));
         btnArquivar.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         btn3pontos = new JButton("\uf142");
         btn3pontos.setFont(customFont2);
         btn3pontos.setBounds(155, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 25, 25);
         btn3pontos.setBackground(Color.decode(nota.getCor()));
         btn3pontos.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         btnFechar = new JButton("Fechar");
         btnFechar.setFont(fonte2);
         btnFechar.setBounds(535, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 60, 17);
         btnFechar.setBackground(Color.decode(nota.getCor()));
         btnFechar.setBorder(new LineBorder(Color.decode(nota.getCor())));
         
         pnBotoesCor = new JPanel();
         pnBotoesCor.setLayout(null);
         pnBotoesCor.setBounds(80, 47+totalAltura+lblImagem.getIcon().getIconHeight()+15, 100, 25);
         pnBotoesCor.setBackground(Color.decode(nota.getCor()));
         
         btcAzul = new JButtonCircular(new Color(0x84CAED));
         btcAzul.setBounds(2,2,20,20);
         
         btcBranco = new JButtonCircular(Color.WHITE);
         btcBranco.setBounds(24,2,20,20);

         btcLaranja = new JButtonCircular(Color.ORANGE);
         btcLaranja.setBounds(46,2,20,20);
         
         btcVerde = new JButtonCircular(new Color(0x278F5D));
         btcVerde.setBounds(68,2,20,20);
         
         
         pnBotoesCor.add(btcAzul);
         pnBotoesCor.add(btcBranco);
         pnBotoesCor.add(btcLaranja);
         pnBotoesCor.add(btcVerde);
         
         
         Font fonte3 = new Font("Arial", Font.PLAIN, 17);
         taConteudo.setFont(fonte3);
         

         
         
         add(tfTitulo);
         add(taConteudo);
         add(lblImagem);
         add(btnFixarNota);
         add(btnLembrar);
         add(btnCor);
         add(btnAddImagem);
         add(btnArquivar);
         add(btn3pontos);
         add(btnFechar);
    }

    private void definirEventos() {
    	btcAzul.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(new Color(0x84CAED));
				tfTitulo.setBackground(new Color(0x84CAED));
		        tfTitulo.setBorder(new LineBorder(new Color(0x84CAED)));
		        taConteudo.setBackground(new Color(0x84CAED));
		        btnFixarNota.setBackground(new Color(0x84CAED));
		        btnFixarNota.setBorder(new LineBorder(new Color(0x84CAED)));
		        btnLembrar.setBackground(new Color(0x84CAED));
		        btnLembrar.setBorder(new LineBorder(new Color(0x84CAED)));
		        btnCor.setBackground(new Color(0x84CAED));
		        btnCor.setBorder(new LineBorder(new Color(0x84CAED)));
		        btnAddImagem.setBackground(new Color(0x84CAED));
		        btnAddImagem.setBorder(new LineBorder(new Color(0x84CAED)));
		        btnArquivar.setBackground(new Color(0x84CAED));
		        btnArquivar.setBorder(new LineBorder(new Color(0x84CAED)));
		        btn3pontos.setBackground(new Color(0x84CAED));
		        btn3pontos.setBorder(new LineBorder(new Color(0x84CAED)));
		        btnFechar.setBackground(new Color(0x84CAED));
		        btnFechar.setBorder(new LineBorder(new Color(0x84CAED)));
		        pnBotoesCor.setBackground(new Color(0x84CAED));
		        
		        remove(pnBotoesCor);
		        btnAddImagem.setLocation(btnAddImagem.getBounds().x-100, btnAddImagem.getBounds().y);
				btnArquivar.setLocation(btnArquivar.getBounds().x-100, btnArquivar.getBounds().y);
				btn3pontos.setLocation(btn3pontos.getBounds().x-100, btn3pontos.getBounds().y);
				revalidate();
				repaint();
			}
		});
    	btcBranco.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.WHITE);
				tfTitulo.setBackground(Color.WHITE);
		        tfTitulo.setBorder(new LineBorder(Color.WHITE));
		        taConteudo.setBackground(Color.WHITE);
		        btnFixarNota.setBackground(Color.WHITE);
		        btnFixarNota.setBorder(new LineBorder(Color.WHITE));
		        btnLembrar.setBackground(Color.WHITE);
		        btnLembrar.setBorder(new LineBorder(Color.WHITE));
		        btnCor.setBackground(Color.WHITE);
		        btnCor.setBorder(new LineBorder(Color.WHITE));
		        btnAddImagem.setBackground(Color.WHITE);
		        btnAddImagem.setBorder(new LineBorder(Color.WHITE));
		        btnArquivar.setBackground(Color.WHITE);
		        btnArquivar.setBorder(new LineBorder(Color.WHITE));
		        btn3pontos.setBackground(Color.WHITE);
		        btn3pontos.setBorder(new LineBorder(Color.WHITE));
		        btnFechar.setBackground(Color.WHITE);
		        btnFechar.setBorder(new LineBorder(Color.WHITE));
		        pnBotoesCor.setBackground(Color.WHITE);
		        
		        remove(pnBotoesCor);
		        btnAddImagem.setLocation(btnAddImagem.getBounds().x-100, btnAddImagem.getBounds().y);
				btnArquivar.setLocation(btnArquivar.getBounds().x-100, btnArquivar.getBounds().y);
				btn3pontos.setLocation(btn3pontos.getBounds().x-100, btn3pontos.getBounds().y);
				revalidate();
				repaint();
			}
		});
    	btcLaranja.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.ORANGE);
				tfTitulo.setBackground(Color.ORANGE);
		        tfTitulo.setBorder(new LineBorder(Color.ORANGE));
		        taConteudo.setBackground(Color.ORANGE);
		        btnFixarNota.setBackground(Color.ORANGE);
		        btnFixarNota.setBorder(new LineBorder(Color.ORANGE));
		        btnLembrar.setBackground(Color.ORANGE);
		        btnLembrar.setBorder(new LineBorder(Color.ORANGE));
		        btnCor.setBackground(Color.ORANGE);
		        btnCor.setBorder(new LineBorder(Color.ORANGE));
		        btnAddImagem.setBackground(Color.ORANGE);
		        btnAddImagem.setBorder(new LineBorder(Color.ORANGE));
		        btnArquivar.setBackground(Color.ORANGE);
		        btnArquivar.setBorder(new LineBorder(Color.ORANGE));
		        btn3pontos.setBackground(Color.ORANGE);
		        btn3pontos.setBorder(new LineBorder(Color.ORANGE));
		        btnFechar.setBackground(Color.ORANGE);
		        btnFechar.setBorder(new LineBorder(Color.ORANGE));
		        pnBotoesCor.setBackground(Color.ORANGE);
		        
		        remove(pnBotoesCor);
		        btnAddImagem.setLocation(btnAddImagem.getBounds().x-100, btnAddImagem.getBounds().y);
				btnArquivar.setLocation(btnArquivar.getBounds().x-100, btnArquivar.getBounds().y);
				btn3pontos.setLocation(btn3pontos.getBounds().x-100, btn3pontos.getBounds().y);
				revalidate();
				repaint();
			}
		});
    	btcVerde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(new Color(0x278F5D));
				tfTitulo.setBackground(new Color(0x278F5D));
		        tfTitulo.setBorder(new LineBorder(new Color(0x278F5D)));
		        taConteudo.setBackground(new Color(0x278F5D));
		        btnFixarNota.setBackground(new Color(0x278F5D));
		        btnFixarNota.setBorder(new LineBorder(new Color(0x278F5D)));
		        btnLembrar.setBackground(new Color(0x278F5D));
		        btnLembrar.setBorder(new LineBorder(new Color(0x278F5D)));
		        btnCor.setBackground(new Color(0x278F5D));
		        btnCor.setBorder(new LineBorder(new Color(0x278F5D)));
		        btnAddImagem.setBackground(new Color(0x278F5D));
		        btnAddImagem.setBorder(new LineBorder(new Color(0x278F5D)));
		        btnArquivar.setBackground(new Color(0x278F5D));
		        btnArquivar.setBorder(new LineBorder(new Color(0x278F5D)));
		        btn3pontos.setBackground(new Color(0x278F5D));
		        btn3pontos.setBorder(new LineBorder(new Color(0x278F5D)));
		        btnFechar.setBackground(new Color(0x278F5D));
		        btnFechar.setBorder(new LineBorder(new Color(0x278F5D)));
		        pnBotoesCor.setBackground(new Color(0x278F5D));
		        
		        remove(pnBotoesCor);
		        btnAddImagem.setLocation(btnAddImagem.getBounds().x-100, btnAddImagem.getBounds().y);
				btnArquivar.setLocation(btnArquivar.getBounds().x-100, btnArquivar.getBounds().y);
				btn3pontos.setLocation(btn3pontos.getBounds().x-100, btn3pontos.getBounds().y);
				revalidate();
				repaint();
			}
		});
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
				String foto;
				if(caminho!=null) {
					foto = caminho;
					 
				}else {
					foto = nota.getFoto();
				}
				
				String cor = colorToString(getBackground());
				note.atualizarNota(id_nota, titulo, conteudo, foto, cor);
				
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
				JnaFileChooser file = new JnaFileChooser();
				boolean action = file.showOpenDialog(telaSessoes);
				if(action) {
					File arquivo = file.getSelectedFile();
					caminho = arquivo.getPath().replace("\\", "\\\\");
					lblImagem.setIcon(new ImageIcon(caminho));
					lblImagem.setBounds(15, taConteudo.getBounds().y+taConteudo.getHeight()+10, lblImagem.getIcon().getIconWidth(),lblImagem.getIcon().getIconHeight());
					
					setPreferredSize(new Dimension(610, getHeight()+20+lblImagem.getIcon().getIconHeight()));
					setMaximumSize(new Dimension(610, getHeight()+20+lblImagem.getIcon().getIconHeight()));
					
						btnLembrar.setBounds(15, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 25, 25);
		                btnCor.setBounds(50, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 25, 25);
		                btnAddImagem.setBounds(85, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 25, 25);
		                btnArquivar.setBounds(120, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 25, 25);
		                btn3pontos.setBounds(155, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 25, 25);
		                btnFechar.setBounds(535, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 60, 17);
		                pnBotoesCor.setBounds(80, lblImagem.getBounds().y+lblImagem.getIcon().getIconHeight()+10, 100,25);
					
					AddImagem(lblImagem);
					revalidate();
					repaint();
			     
				}
				
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
				btnAddImagem.setLocation(btnAddImagem.getBounds().x+100, btnAddImagem.getBounds().y);
				btnArquivar.setLocation(btnArquivar.getBounds().x+100, btnArquivar.getBounds().y);
				btn3pontos.setLocation(btn3pontos.getBounds().x+100, btn3pontos.getBounds().y);
				add(pnBotoesCor);
				revalidate();
				repaint();
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
               
            }}
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
                
                int posiImage = taConteudo.getBounds().y+taConteudo.getHeight()+10;
                posiImage = posiImage+7;

                btnLembrar.setBounds(15, novaPosicao, 25, 25);
                btnCor.setBounds(50, novaPosicao, 25, 25);
                btnAddImagem.setBounds(85, novaPosicao, 25, 25);
                btnArquivar.setBounds(120, novaPosicao, 25, 25);
                btn3pontos.setBounds(155, novaPosicao, 25, 25);
                btnFechar.setBounds(535, novaPosicao, 60, 17);
                pnBotoesCor.setBounds(80, novaPosicao, 100,25);
                lblImagem.setLocation(15, posiImage);

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
                    
                    int posiImage = taConteudo.getBounds().y+taConteudo.getHeight()+10;
                    posiImage = posiImage+7;

                    btnLembrar.setBounds(15, novaPosicao, 25, 25);
                    btnCor.setBounds(50, novaPosicao, 25, 25);
                    btnAddImagem.setBounds(85, novaPosicao, 25, 25);
                    btnArquivar.setBounds(120, novaPosicao, 25, 25);
                    btn3pontos.setBounds(155, novaPosicao, 25, 25);
                    btnFechar.setBounds(535, novaPosicao, 60, 17);
                    pnBotoesCor.setBounds(80, novaPosicao, 100, 25);
                    lblImagem.setLocation(15, novaPosicao);
                    lblImagem.setLocation(15, posiImage);

    	            revalidate();
    	            repaint();
    	            
    	    }  catch (Exception ex) {
    	        ex.printStackTrace();
    	    }
    	
        }
    
    public void AddImagem(JLabel image) {
    	add(tfTitulo);
        add(taConteudo);
        add(image);
        add(btnFixarNota);
        add(btnLembrar);
        add(btnCor);
        add(btnAddImagem);
        add(btnArquivar);
        add(btn3pontos);
        add(btnFechar);
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
    private String colorToString(Color color) {
        return String.format("0x%06X", (0xFFFFFF & color.getRGB()));
    }
}

