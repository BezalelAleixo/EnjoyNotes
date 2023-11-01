package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.model.vo.ContaVO;

public class JTelaSessoes extends JFrame{

	private Container contentpane;
	private JPanel pnPrincipal, pnBarra, pnBlocosContas;
	private JLabel lblPergunta, lblMockupLogo;
	
	public JTelaSessoes () {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setTitle("Entre na sua conta");
		contentpane = getContentPane();
		setSize(1366,768);
		
		setLayout(new BorderLayout());
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBackground(new Color(0x84CAED));
        
        contentpane.add(pnBarra, BorderLayout.NORTH);
        contentpane.add(pnPrincipal, BorderLayout.CENTER);
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Bernoru", Font.BOLD, 50);
		
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(51, 29, 139, 77);
		
		lblPergunta = new JLabel("Quem está acessando?");
		lblPergunta.setFont(fonte);
		lblPergunta.setForeground(new Color(0x2a4674));
		lblPergunta.setBounds(383, 50, 600, 100);
		
		pnBlocosContas = new JPanel();
		pnBlocosContas.setLayout(new FlowLayout());
		pnBlocosContas.setBounds(0,200, 1366,440);
		pnBlocosContas.setBackground(new Color(0x84CAED));
		
		
		pnBarra.add(lblMockupLogo);
		pnPrincipal.add(lblPergunta);
		pnPrincipal.add(pnBlocosContas);
	}

	private void definirEventos() {
		SessaoController controller = new SessaoController();
		controller.sessoesLogadas();
		List<JTelaSessoesContas> contasPreparadas;
		contasPreparadas = new ArrayList<>();
		List<ContaVO> contaLogadas = controller.ListaContasFeitas();
		
		for(ContaVO contas : contaLogadas) {
			JTelaSessoesContas blocos = new JTelaSessoesContas(contas);
			contasPreparadas.add(blocos);
		}
		for(JTelaSessoesContas blocosProntos : contasPreparadas) {
			blocosProntos.setPreferredSize(new Dimension(193,263));
			pnBlocosContas.add(blocosProntos, FlowLayout.LEFT);
		}
	}

	public static void abrir(){
		JTelaSessoes frame = new JTelaSessoes();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		JTelaSessoes.abrir();
	}
}
