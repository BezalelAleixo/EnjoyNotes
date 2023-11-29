package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.VideoVO;
import javafx.embed.swing.JFXPanel;
import javafx.util.Duration;

public class JVideoPlayer extends JPanel{
	private VideoPlayer videoPlayerFX;
	private JButton btnProximoDireita, btnProximoEsquerda, btnPlay_Pause, btnVoltar;;
	private JPanel pnBarra, pnPrincipal, pnBotoes;
	private VideoVO video;
	private JLabel lblMockupLogo;
	private JTelaSessoes telaSessoes;
	private ContaVO conta;
	
	public JVideoPlayer(VideoVO video, JTelaSessoes telaSessoes, ContaVO conta) {
		this.video = video;
		this.telaSessoes = telaSessoes;
		this.conta = conta;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setSize(1366,640);
		setLayout(new BorderLayout());
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(new BorderLayout());
        pnPrincipal.setBackground(Color.WHITE);
        
        pnBotoes = new JPanel();
        FlowLayout flowLayoutLEFT = new FlowLayout(FlowLayout.LEFT, 5, 0);
        pnBotoes.setLayout(flowLayoutLEFT);
        pnBotoes.setPreferredSize(new Dimension(1366, 150));
        pnBotoes.setBackground(Color.WHITE);
        MatteBorder emptyBorder9 = BorderFactory.createMatteBorder(0, 550, 0, 0, Color.WHITE);
		MatteBorder redBottomBorder9 = BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE);
	    Border compoundBorder9 = BorderFactory.createCompoundBorder(emptyBorder9, redBottomBorder9);
		pnBotoes.setBorder(compoundBorder9);
        
        add(pnBarra, BorderLayout.NORTH);
        add(pnPrincipal, BorderLayout.CENTER);
	}

	private void posicionandoComponentes() {
		
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(51, 29, 139, 77);
		
		
        videoPlayerFX = new VideoPlayer(video.getCaminho_video());
        
        btnProximoEsquerda = new JButton("<<");
        btnProximoEsquerda.setPreferredSize(new Dimension(30,30));
        btnProximoEsquerda.setBackground(Color.WHITE);
        btnProximoEsquerda.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        btnProximoDireita = new JButton(">>");
        btnProximoDireita.setPreferredSize(new Dimension(30,30));
        btnProximoDireita.setBackground(Color.WHITE);
        btnProximoDireita.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        btnPlay_Pause = new JButton("Pausar");
        btnPlay_Pause.setPreferredSize(new Dimension(130,30));
        btnPlay_Pause.setBackground(Color.WHITE);
        btnPlay_Pause.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        btnVoltar = new JButton(">>");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0x2a4674));
		btnVoltar.setBounds(1236, 51, 130, 26);
        btnVoltar.setBorder(new EmptyBorder(0,0,0,0));
        
        pnBotoes.add(btnProximoEsquerda);
        pnBotoes.add(btnPlay_Pause);
        pnBotoes.add(btnProximoDireita);
        
        pnBarra.add(btnVoltar);
        
        pnPrincipal.add(videoPlayerFX.getFxPanel(), BorderLayout.CENTER);
        pnPrincipal.add(pnBotoes, BorderLayout.SOUTH);
        
        
		
        pnBarra.add(lblMockupLogo);
	}

	private void definirEventos() {
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaSessoes.getContentpane().removeAll();
				JTelaVideos videos = new JTelaVideos(conta, telaSessoes);
                telaSessoes.getContentpane().add(videos, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
				
			}
		});
		btnPlay_Pause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnPlay_Pause.getText()=="Pausar") {
					videoPlayerFX.pause();
					btnPlay_Pause.setText("Reproduzir");
				}else if(btnPlay_Pause.getText()=="Reproduzir") {
					videoPlayerFX.reproduzir();
					btnPlay_Pause.setText("Pausar");
				}
				
			}
		});
		
	}
}
