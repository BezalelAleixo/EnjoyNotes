package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JTelaNotificacoes extends JPanel{
    private JPanel nomeNotificacoesPanel;
    private JLabel lblLembretes;
    private JLabel lblNotificacoes;
    private JCheckBox ckLembretes;


    public JTelaNotificacoes() {
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
        setBackground(new Color(0x345389));
    }

    private void posicionandoComponentes() {
    	nomeNotificacoesPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNotificacoesPanel.setLayout(new BoxLayout(nomeNotificacoesPanel, BoxLayout.X_AXIS));
        nomeNotificacoesPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNotificacoesPanel.setBackground(new Color(0x345389));
        nomeNotificacoesPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        Font fonte = new Font("Garet", Font.PLAIN, 24);
        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
        
        lblNotificacoes = new JLabel("Notificações");
        lblNotificacoes.setFont(fonte);
        lblNotificacoes.setBackground(new Color(0x345389));
        lblNotificacoes.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblNotificacoes.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblNotificacoes.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
       

        lblLembretes = new JLabel("Lembretes:");
        lblLembretes.setFont(fonte);
        lblLembretes.setBackground(new Color(0x345389));
        lblLembretes.setForeground(Color.WHITE);
        lblLembretes.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblLembretes.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        ckLembretes = new JCheckBox("desligado");
        ckLembretes.setFont(fonte);
        ckLembretes.setPreferredSize(new Dimension(50,50));
        ckLembretes.setBackground(new Color(0x345389));
        ckLembretes.setForeground(Color.WHITE);
        ckLembretes.setBorder(new EmptyBorder(0, 0, 0, 0));
        ckLembretes.setAlignmentX(JComponent.LEFT_ALIGNMENT);
	    
	    add(lblNotificacoes);
	    add(Box.createRigidArea(new Dimension(0, 20)));
        add(nomeNotificacoesPanel); 
        nomeNotificacoesPanel.add(lblLembretes);
        nomeNotificacoesPanel.add(ckLembretes);
        
    }

    private void definirEventos() {
       ckLembretes.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(ckLembretes.isSelected()) {
				ckLembretes.setText("ligado");
			}else {
				ckLembretes.setText("desligado");
			}
			
		}
	});
    }
}

