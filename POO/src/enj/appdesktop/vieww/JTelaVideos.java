package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import enj.appdesktop.controller.Lista_Cartao_Controller;
import enj.appdesktop.controller.VideoController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.VideoVO;
import javafx.embed.swing.JFXPanel;
import javafx.util.Duration;
import jnafilechooser.api.JnaFileChooser;

public class JTelaVideos extends JPanel{
	private JPanel pnBarra, pnPrincipal;
	private JLabel lblMockupLogo;
	private JButton btnAdicionar;
	private JButton btnVoltar;
	private ContaVO conta;
	private JTelaSessoes telaSessoes;
	
	public JTelaVideos(ContaVO conta, JTelaSessoes telaSessoes) {
		this.conta = conta;
		this.telaSessoes = telaSessoes;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setSize(1366,768);
		setLayout(new BorderLayout());
		
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));

        
        pnPrincipal = new JPanel();
        FlowLayout flowLayoutLEFT = new FlowLayout(FlowLayout.LEFT, 20, 40);
        pnPrincipal.setLayout(flowLayoutLEFT);
        pnPrincipal.setBackground(Color.WHITE);
        
        add(pnBarra, BorderLayout.NORTH);
        add(pnPrincipal, BorderLayout.CENTER);
	}

	private void posicionandoComponentes() {
		Font fonte2 = new Font("Garet", Font.PLAIN, 24);
		
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(51, 29, 139, 77);
		
        
        btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(fonte2);
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setBackground(new Color(0x2a4674));
		btnAdicionar.setBounds(200, 51, 160, 26);
		btnAdicionar.setBorder(new EmptyBorder(0,0,0,0));
		
		btnVoltar = new JButton(">>");
		btnVoltar.setFont(fonte2);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(0x2a4674));
		btnVoltar.setBounds(1236, 51, 130, 26);
        btnVoltar.setBorder(new EmptyBorder(0,0,0,0));
		
        pnBarra.add(lblMockupLogo);
        pnBarra.add(btnAdicionar);
        pnBarra.add(btnVoltar);
	}

	private void definirEventos() {
		VideoController controller = new VideoController();
		controller.listarListas(conta.getNome_perfil());
		List<JBlocoVideo> videosPreparadas;
		videosPreparadas = new ArrayList<>();
		List<VideoVO> videosProntas = controller.ListasPreparadasdaCOnta();
		
		for(VideoVO video : videosProntas) {
			JBlocoVideo blocos = new JBlocoVideo(video, telaSessoes, conta);
			videosPreparadas.add(blocos);
			
		}
		
		for (JBlocoVideo blocosProntos : videosPreparadas) {
			pnPrincipal.removeAll();
		    pnPrincipal.add(blocosProntos);
		}
		pnPrincipal.revalidate();
		pnPrincipal.repaint();
		
		btnAdicionar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JnaFileChooser file = new JnaFileChooser();
				boolean action = file.showOpenDialog(telaSessoes);
				if(action) {
					File arquivo = file.getSelectedFile();
					String nome_video = arquivo.getName();
					String caminho = arquivo.getPath().replace("\\", "\\\\");
					
					VideoController controller = new VideoController();
					controller.salvarVideo(nome_video, caminho, conta.getId_conta());
					
					
					controller.listarListas(conta.getNome_perfil());
					List<JBlocoVideo> videosPreparadas;
					videosPreparadas = new ArrayList<>();
					List<VideoVO> videosProntas = controller.ListasPreparadasdaCOnta();
					
					for(VideoVO video : videosProntas) {
						JBlocoVideo blocos = new JBlocoVideo(video, telaSessoes, conta);
						videosPreparadas.add(blocos);
						pnPrincipal.removeAll();
					}

					for (JBlocoVideo blocosProntos : videosPreparadas) {
					    pnPrincipal.add(blocosProntos);
					}
					pnPrincipal.revalidate();
					pnPrincipal.repaint();
			     
				}
				
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				telaSessoes.getContentpane().removeAll();
				JTelaMenu menu = new JTelaMenu(conta, conta.getNome_perfil(), telaSessoes);
				telaSessoes.getContentpane().add(menu);
				telaSessoes.revalidate();
				telaSessoes.repaint();
				
			}
		});
	}
}
