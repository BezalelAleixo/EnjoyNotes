package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// ... (outros imports)

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.VideoVO;
import javafx.util.Duration;

public class JBlocoVideo extends JPanel {
	private JVideoPlayerMini videoPlayerFX;
    private JLabel lblNome_Video;
    private JButton btnMockup;
    private ContaVO conta;
    private JTelaSessoes telaSessoes; // Deixe essa declaração
    Duration startTime = Duration.minutes(1).add(Duration.seconds(20));
    private VideoVO video;
    public JBlocoVideo(VideoVO video, JTelaSessoes telaSessoes, ContaVO conta) {
    	this.video = video;
    	this.telaSessoes = telaSessoes;
    	this.conta = conta;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setPreferredSize(new Dimension(110, 100));
        setOpaque(true);
        setLayout(new BorderLayout());
        setBackground(new Color(0xFFFFFF));
    }

    private void posicionandoComponentes() {
        
    	videoPlayerFX = new JVideoPlayerMini(video.getCaminho_video(), startTime);
    	
        Font fonte = new Font("Garet", Font.PLAIN, 17);
        lblNome_Video = new JLabel(video.getNome_video());
        lblNome_Video.setFont(fonte);
        lblNome_Video.setHorizontalAlignment(SwingConstants.CENTER);
        

        add(videoPlayerFX.getFxPanel(), BorderLayout.NORTH);
        add(lblNome_Video, BorderLayout.CENTER);
    }

    private void definirEventos() {
     lblNome_Video.addMouseListener(new MouseListener() {
		
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
			lblNome_Video.setForeground(Color.BLACK);
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			lblNome_Video.setForeground(Color.RED);
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			telaSessoes.getContentpane().removeAll();
			JVideoPlayer videoPlayer = new JVideoPlayer(video, telaSessoes, conta);
			telaSessoes.getContentpane().add(videoPlayer);
			telaSessoes.revalidate();
			telaSessoes.repaint();
		}
	});
     videoPlayerFX.getFxPanel().addMouseListener(new MouseListener() {
		
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
		/*	telaSessoes.removeAll();
			JVideoPlayer videoPlayer = new JVideoPlayer(video, telaSessoes, conta);
			telaSessoes.getContentpane().add(videoPlayer);
			telaSessoes.revalidate();
			telaSessoes.repaint();*/
			
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
}