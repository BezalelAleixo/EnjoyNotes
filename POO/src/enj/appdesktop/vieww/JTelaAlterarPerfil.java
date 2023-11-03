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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JTelaAlterarPerfil extends JPanel{
    private JPanel nomeNovoNomeContaPanel,nomeSenhaContaPanel, nomeSenhaConfirmarNomeContaPanel, nomeBtnSalvarPanel;
    private JLabel lblNovoNomeConta, lblSenhaConta, lblSenhaConfirmarConta, lblbtnSalvar;
    private JLabel lblAlterarPefil;
    private JTextField tfNovoNomeConta;
    private JPasswordField pfSenha, pfConfirmarSenha;
    private JButton btnSalvar;


    public JTelaAlterarPerfil() {
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
        setBackground(new Color(0x345389));
    }

    private void posicionandoComponentes() {
    	
        Font fonte = new Font("Garet", Font.PLAIN, 24);
        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
        
        lblAlterarPefil = new JLabel("Alterar dados de perfil");
        lblAlterarPefil.setFont(fonte);
        lblAlterarPefil.setBackground(new Color(0x345389));
        lblAlterarPefil.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblAlterarPefil.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblAlterarPefil.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeNovoNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNovoNomeContaPanel.setLayout(new BoxLayout(nomeNovoNomeContaPanel, BoxLayout.X_AXIS));
        nomeNovoNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNovoNomeContaPanel.setBackground(new Color(0x345389));
        nomeNovoNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblNovoNomeConta = new JLabel("Nome de Usuário:");
        lblNovoNomeConta.setFont(fonte);
        lblNovoNomeConta.setBackground(new Color(0x345389));
        lblNovoNomeConta.setForeground(Color.WHITE);
        lblNovoNomeConta.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblNovoNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        tfNovoNomeConta = new JTextField(); // 100 is the initial width
        tfNovoNomeConta.setFont(fonte);
        tfNovoNomeConta.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        tfNovoNomeConta.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        tfNovoNomeConta.setBackground(new Color(0x2a4674));
        tfNovoNomeConta.setForeground(Color.WHITE);
        tfNovoNomeConta.setBorder(new LineBorder(tfNovoNomeConta.getBackground()));
        tfNovoNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeSenhaContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeSenhaContaPanel.setLayout(new BoxLayout(nomeSenhaContaPanel, BoxLayout.X_AXIS));
        nomeSenhaContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeSenhaContaPanel.setBackground(new Color(0x345389));
        nomeSenhaContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblSenhaConta = new JLabel("Senha:");
        lblSenhaConta.setFont(fonte);
        lblSenhaConta.setBackground(new Color(0x345389));
        lblSenhaConta.setForeground(Color.WHITE);
        lblSenhaConta.setBorder(new EmptyBorder(0, 0, 0, 165)); // Adiciona espaço de 40 pixels ao redor
        lblSenhaConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfSenha = new JPasswordField(); // 100 is the initial width
        pfSenha.setFont(fonte);
        pfSenha.setEchoChar('*');
        pfSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfSenha.setBackground(new Color(0x2a4674));
        pfSenha.setForeground(Color.WHITE);
        pfSenha.setBorder(new LineBorder(tfNovoNomeConta.getBackground()));
        pfSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeSenhaConfirmarNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeSenhaConfirmarNomeContaPanel.setLayout(new BoxLayout(nomeSenhaConfirmarNomeContaPanel, BoxLayout.X_AXIS));
        nomeSenhaConfirmarNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeSenhaConfirmarNomeContaPanel.setBackground(new Color(0x345389));
        nomeSenhaConfirmarNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblSenhaConfirmarConta = new JLabel("Confirmar Senha:");
        lblSenhaConfirmarConta.setFont(fonte);
        lblSenhaConfirmarConta.setBackground(new Color(0x345389));
        lblSenhaConfirmarConta.setForeground(Color.WHITE);
        lblSenhaConfirmarConta.setBorder(new EmptyBorder(0, 0, 0, 54)); // Adiciona espaço de 40 pixels ao redor
        lblSenhaConfirmarConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfConfirmarSenha = new JPasswordField(); // 100 is the initial width
        pfConfirmarSenha.setFont(fonte);
        pfConfirmarSenha.setEchoChar('*');
        pfConfirmarSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfConfirmarSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfConfirmarSenha.setBackground(new Color(0x2a4674));
        pfConfirmarSenha.setForeground(Color.WHITE);
        pfConfirmarSenha.setBorder(new LineBorder(tfNovoNomeConta.getBackground()));
        pfConfirmarSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeBtnSalvarPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeBtnSalvarPanel.setLayout(new BoxLayout(nomeBtnSalvarPanel, BoxLayout.X_AXIS));
        nomeBtnSalvarPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeBtnSalvarPanel.setBackground(new Color(0x345389));
        nomeBtnSalvarPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblbtnSalvar = new JLabel("bbb");
        lblbtnSalvar.setBackground(new Color(0x345389));
        lblbtnSalvar.setForeground(new Color(0x345389));
        lblbtnSalvar.setBorder(new EmptyBorder(0, 0, 0, 360)); // Adiciona espaço de 40 pixels ao redor
        lblbtnSalvar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        btnSalvar = new JButton("Salvar");
        btnSalvar.setMaximumSize(new Dimension(120, 45));
		btnSalvar.setPreferredSize(new Dimension(120,45));
		btnSalvar.setFont(fonte2);
        btnSalvar.setBackground(new Color(0x345389));
        btnSalvar.setForeground(new Color(0x2a4674));
        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, new Color(0x2a4674));
		MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(0x2a4674));
	    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
	    btnSalvar.setBorder(compoundBorder);
        btnSalvar.setAlignmentX(JComponent.LEFT_ALIGNMENT);
	    
	    add(lblAlterarPefil);
	    add(Box.createRigidArea(new Dimension(0, 20)));
        add(nomeNovoNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeSenhaContaPanel); 
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeSenhaConfirmarNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(nomeBtnSalvarPanel);
        nomeNovoNomeContaPanel.add(lblNovoNomeConta);
        nomeNovoNomeContaPanel.add(tfNovoNomeConta);
        nomeSenhaContaPanel.add(lblSenhaConta);
        nomeSenhaContaPanel.add(pfSenha);
        nomeSenhaConfirmarNomeContaPanel.add(lblSenhaConfirmarConta);
        nomeSenhaConfirmarNomeContaPanel.add(pfConfirmarSenha);
        nomeBtnSalvarPanel.add(lblbtnSalvar);
        nomeBtnSalvarPanel.add(btnSalvar);
    }

    private void definirEventos() {
    	pfConfirmarSenha.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String n1 = tfNovoNomeConta.getText();
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				if(!n1.isEmpty() && !n2.isEmpty()  && !n3.isEmpty() ) {
					btnSalvar.setBackground(new Color(0x345389));
			        btnSalvar.setForeground(Color.WHITE);
			        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE);
					MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE);
				    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
				    btnSalvar.setBorder(compoundBorder);	
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String n1 = tfNovoNomeConta.getText();
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				if(!n1.isEmpty() && !n2.isEmpty()  && !n3.isEmpty() ) {
					btnSalvar.setBackground(new Color(0x345389));
			        btnSalvar.setForeground(Color.WHITE);
			        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE);
					MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE);
				    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
				    btnSalvar.setBorder(compoundBorder);	
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				String n1 = tfNovoNomeConta.getText();
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				if(!n1.isEmpty() && !n2.isEmpty()  && !n3.isEmpty() ) {
					btnSalvar.setBackground(new Color(0x345389));
			        btnSalvar.setForeground(Color.WHITE);
			        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE);
					MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE);
				    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
				    btnSalvar.setBorder(compoundBorder);	
				}
				
			}
		});
    btnSalvar.addMouseListener(new MouseListener() {
		
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
			btnSalvar.setBackground(new Color(0x345389));
	        btnSalvar.setForeground(new Color(0x2a4674));
	        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, new Color(0x2a4674));
			MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(0x2a4674));
		    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
		    btnSalvar.setBorder(compoundBorder);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			btnSalvar.setBackground(new Color(0x345389));
	        btnSalvar.setForeground(Color.WHITE);
	        MatteBorder emptyBorder = BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE);
			MatteBorder redBottomBorder = BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE);
		    Border compoundBorder = BorderFactory.createCompoundBorder(emptyBorder, redBottomBorder);
		    btnSalvar.setBorder(compoundBorder);
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}
	});
    }
}

