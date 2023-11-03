package enj.appdesktop.vieww;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class JTelaConta extends JPanel {
    private JPanel pn3Opcoes;
    private JPanel nomeContaPanel;
    private JLabel lblNome, lblNomeConta;
    private JLabel lblMockupConta, lblVoce;
    private JButton btnOpcional, btnUsarOutraConta, btnSairConta, btnPersonalize;

    public JTelaConta() {
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
    	
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
        setBackground(new Color(0x345389));
    }

    private void posicionandoComponentes() {
    	nomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeContaPanel.setLayout(new BoxLayout(nomeContaPanel, BoxLayout.X_AXIS));
        nomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 40));
        nomeContaPanel.setBackground(new Color(0x345389));
        nomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        Font fonte = new Font("Garet", Font.PLAIN, 24);
        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
        
        lblVoce = new JLabel("Você e EnjoyNotes");
        lblVoce.setFont(fonte);
        lblVoce.setBackground(new Color(0x345389));
        lblVoce.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblVoce.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblVoce.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblMockupConta = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\teste2.png"));
        lblMockupConta.setPreferredSize(new Dimension(193, 193));
        lblMockupConta.setBackground(new Color(0x2a4674));
        lblMockupConta.setBorder(new EmptyBorder(0, 40, 0, 0));
        lblMockupConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblNomeConta = new JLabel("@beza");
        lblNomeConta.setFont(fonte);
        lblNomeConta.setBackground(new Color(0x345389));
        lblNomeConta.setForeground(Color.WHITE);
        lblNomeConta.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblNome = new JLabel("Bezalel Aleixo");
        lblNome.setFont(fonte2);
        lblNome.setBackground(new Color(0x345389));
        lblNome.setForeground(Color.WHITE);
        lblNome.setBorder(new EmptyBorder(0, 40, 0, 0));
        lblNome.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        btnOpcional = new JButton(new ImageIcon("D:\\projetoENjoyNotes\\botaoOpcional.png"));
        btnOpcional.setPreferredSize(new Dimension(49,47));
        btnOpcional.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnOpcional.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pn3Opcoes = new JPanel();
        BoxLayout boxLayout = new BoxLayout(pn3Opcoes, BoxLayout.Y_AXIS); // Usando BoxLayout com orientação vertical
        pn3Opcoes.setLayout(boxLayout);
		pn3Opcoes.setBackground(new Color(0x2a4674));
		
		btnUsarOutraConta = new JButton("Usar outra Conta");
		btnUsarOutraConta.setPreferredSize(new Dimension(100,50));
		btnUsarOutraConta.setFont(fonte3);
		btnUsarOutraConta.setBorder(new EmptyBorder(10, 0, 0, 0));
		btnUsarOutraConta.setBackground(new Color(0x2a4674));
		btnUsarOutraConta.setForeground(Color.WHITE);
		
		btnSairConta = new JButton("Sair da Conta");
		btnSairConta.setPreferredSize(new Dimension(100,50));
		btnSairConta.setFont(fonte3);
		btnSairConta.setBorder(new EmptyBorder(0, 0, 10, 0));
		btnSairConta.setBackground(new Color(0x2a4674));
		btnSairConta.setForeground(Color.WHITE);
		
		btnPersonalize = new JButton("Personalize seu Perfil do EnjoyNotes");
		btnPersonalize.setPreferredSize(new Dimension(250,49));
		btnPersonalize.setFont(fonte);
        btnPersonalize.setBackground(new Color(0x345389));
        btnPersonalize.setForeground(Color.WHITE);
        MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
	    btnPersonalize.setBorder(compoundBorder);
        btnPersonalize.setAlignmentX(JComponent.LEFT_ALIGNMENT);
		
		pn3Opcoes.add(Box.createRigidArea(new Dimension(0, 0))); // Espaço rígido de 10 pixels
	    pn3Opcoes.add(btnUsarOutraConta);
	    pn3Opcoes.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço rígido de 5 pixels
	    pn3Opcoes.add(btnSairConta);
	    
	    add(lblVoce);
	    add(Box.createRigidArea(new Dimension(0, 18)));
        add(lblMockupConta);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeContaPanel); 
        add(Box.createRigidArea(new Dimension(0, 5))); // Espaço rígido de 20 pixels entre lblNomeConta e lblNome
        add(lblNome);
        add(Box.createRigidArea(new Dimension(0, 100))); // Espaço rígido de 20 pixels entre lblNomeConta e lblNome
        add(btnPersonalize);
        nomeContaPanel.add(lblNomeConta);
        nomeContaPanel.add(btnOpcional);
        
    }

    private void definirEventos() {
       btnOpcional.addMouseListener(new MouseListener() {
		
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
			btnOpcional.setIcon(new ImageIcon("D:\\projetoENjoyNotes\\botaoOpcional.png"));
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnOpcional.setIcon(new ImageIcon("D:\\projetoENjoyNotes\\botaoOpcional2.png"));
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			nomeContaPanel.add(pn3Opcoes);
			validate(); // Atualiza o layout para exibir a nova tela
			
		}
	});
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
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			nomeContaPanel.remove(pn3Opcoes);
			revalidate();
		}
	});
       btnPersonalize.addMouseListener(new MouseListener() {
		
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
			MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 40, 0, 0, new Color(0x345389));
			MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
		    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
		    btnPersonalize.setBorder(compoundBorder);
		    btnPersonalize.setForeground(Color.WHITE);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			MatteBorder emptyBorder = BorderFactory.createMatteBorder(0, 40, 0, 0, new Color(0x345389));
			MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0x84CAED));
		    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
		    btnPersonalize.setBorder(compoundBorder);
		    btnPersonalize.setForeground(new Color(0x84CAED));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JTelaUsuario.abrir();
		}
	});
       btnUsarOutraConta.addMouseListener(new MouseListener() {
		
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
			btnUsarOutraConta.setForeground(Color.WHITE);
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			btnUsarOutraConta.setForeground(new Color(0x84CAED));
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JTelaConfigurações.fechar();
			JTelaSessoes.abrir();
		}
	});
    
    }
}
