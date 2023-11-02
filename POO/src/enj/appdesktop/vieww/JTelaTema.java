package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JTelaTema extends JPanel{
	private JPanel pn3Opcoes;
    private JPanel nomeTemaPanel;
    private JLabel lblTema;
    private JLabel lblTemaAparencia;
    private JCheckBox ckTema;
    
    public JTelaTema() {
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
        setBackground(new Color(0x345389));
    }

    private void posicionandoComponentes() {
    	nomeTemaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeTemaPanel.setLayout(new BoxLayout(nomeTemaPanel, BoxLayout.X_AXIS));
        nomeTemaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeTemaPanel.setBackground(new Color(0x345389));
        nomeTemaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        Font fonte = new Font("Garet", Font.PLAIN, 24);
        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
        
        lblTema = new JLabel("Notificações");
        lblTema.setFont(fonte);
        lblTema.setBackground(new Color(0x345389));
        lblTema.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblTema.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblTema.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
       

        lblTemaAparencia = new JLabel("Tema Escuro:");
        lblTemaAparencia.setFont(fonte);
        lblTemaAparencia.setBackground(new Color(0x345389));
        lblTemaAparencia.setForeground(Color.WHITE);
        lblTemaAparencia.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblTemaAparencia.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        ckTema = new JCheckBox("desligado");
        ckTema.setFont(fonte);
        ckTema.setPreferredSize(new Dimension(50,50));
        ckTema.setBackground(new Color(0x345389));
        ckTema.setForeground(Color.WHITE);
        ckTema.setBorder(new EmptyBorder(0, 0, 0, 0));
        ckTema.setAlignmentX(JComponent.LEFT_ALIGNMENT);
	    
	    add(lblTema);
	    add(Box.createRigidArea(new Dimension(0, 20)));
        add(nomeTemaPanel); 
        nomeTemaPanel.add(lblTemaAparencia);
        nomeTemaPanel.add(ckTema);
        
    }

    private void definirEventos() {
       ckTema.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(ckTema.isSelected()) {
				ckTema.setText("ligado");
			}else {
				ckTema.setText("desligado");
			}
			
		}
	});
    }
}
