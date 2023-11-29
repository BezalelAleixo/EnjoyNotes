package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import enj.appdesktop.controller.Lista_Cartao_Controller;
import enj.appdesktop.controller.QuadroController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class JTelaListaDeCartoes extends JPanel{

    private JTelaQuadros telaquadros;
    private JTelaSessoes telaSessoes;
    private QuadroVO quadro;
    private JButton btnCriarLista;


    public JTelaListaDeCartoes(JTelaQuadros telaquadros, JTelaSessoes telaSessoes, QuadroVO quadro) {
    	this.telaquadros = telaquadros;
    	this.telaSessoes = telaSessoes;
    	this.quadro = quadro;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {

        FlowLayout flowLayoutLEFT = new FlowLayout(FlowLayout.LEFT, 20, 10);
        setLayout(flowLayoutLEFT);
        setBackground(new Color(0x345389));
        setPreferredSize(new Dimension(1366, 640));
        setMaximumSize(new Dimension(1366, 640));
    }

    private void posicionandoComponentes() {
    	Font fonte = new Font("Bernoru", Font.BOLD, 17);
    	
    	btnCriarLista = new JButton("Criar Lista");
		btnCriarLista.setFont(fonte);
		btnCriarLista.setBackground(new Color(0x84CAED));
		btnCriarLista.setPreferredSize(new Dimension(225,40));
		btnCriarLista.setMaximumSize(new Dimension(225,40));
		btnCriarLista.setBorder(new LineBorder(Color.WHITE));
		btnCriarLista.setForeground(Color.WHITE);
        
        
       
    }

    private void definirEventos() {
    	
    	Lista_Cartao_Controller controller = new Lista_Cartao_Controller();
		controller.listarListas(quadro.getNome_quad());
		List<JBlocoListaQuadro> listPreparadas;
		listPreparadas = new ArrayList<>();
		List<Lista_CartaoVO> listProntas = controller.ListasPreparadasdaCOnta();
		
		for(Lista_CartaoVO list : listProntas) {
			JBlocoListaQuadro blocos = new JBlocoListaQuadro(list, telaSessoes, quadro);
			listPreparadas.add(blocos);
		}

		for (JBlocoListaQuadro blocosProntos : listPreparadas) {
		    add(blocosProntos);
		}
		add(btnCriarLista);
    	
    	btnCriarLista.addMouseListener(new MouseListener() {
			
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
				
				Lista_CartaoVO list = new Lista_CartaoVO("", quadro.getId());
				JBlocoListaQuadro lista_bloco = new JBlocoListaQuadro(list, telaSessoes, quadro);
				add(lista_bloco);
				add(btnCriarLista);
				revalidate();
				repaint();
			}
		});
    }
    public void AddBlocoLista(JBlocoListaQuadro bloco) {
    	Lista_Cartao_Controller controller = new Lista_Cartao_Controller();
		controller.listarListas(quadro.getNome_quad());
		List<JBlocoListaQuadro> listPreparadas;
		listPreparadas = new ArrayList<>();
		List<Lista_CartaoVO> listProntas = controller.ListasPreparadasdaCOnta();
		
		for(Lista_CartaoVO list : listProntas) {
			JBlocoListaQuadro blocos = new JBlocoListaQuadro(list, telaSessoes, quadro);
			listPreparadas.add(blocos);
		}

		for (JBlocoListaQuadro blocosProntos : listPreparadas) {
		    add(blocosProntos);
		}
		add(bloco);
		add(btnCriarLista);
    	
    }
}

