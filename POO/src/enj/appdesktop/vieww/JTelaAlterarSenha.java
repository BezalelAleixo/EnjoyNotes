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

public class JTelaAlterarSenha extends JPanel{
    private JPanel nomeNomeContaPanel,nomeSenhaContaPanel, nomeSenhaConfirmarNomeContaPanel,nomeNovaSenhaContaPanel,nomeNovaSenhaConfirmarNomeContaPanel, nomeBtnSalvarPanel;
    private JLabel lblSeuNomeConta, lblSenhaConta, lblSenhaConfirmarConta,lblNovaSenhaConta,lblNovaSenhaConfirmarConta, lblbtnSalvar;
    private JLabel lblAlterarSenha;
    private JLabel lblNomeConta;
    private JPasswordField pfSenha, pfConfirmarSenha,pfNovaSenha,pfNovaConfirmarSenha;
    private JButton btnSalvar;


    public JTelaAlterarSenha() {
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
        
        lblAlterarSenha = new JLabel("Alterar dados de perfil");
        lblAlterarSenha.setFont(fonte);
        lblAlterarSenha.setBackground(new Color(0x345389));
        lblAlterarSenha.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblAlterarSenha.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblAlterarSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNomeContaPanel.setLayout(new BoxLayout(nomeNomeContaPanel, BoxLayout.X_AXIS));
        nomeNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNomeContaPanel.setBackground(new Color(0x345389));
        nomeNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblSeuNomeConta = new JLabel("Nome de Usuário:");
        lblSeuNomeConta.setFont(fonte);
        lblSeuNomeConta.setBackground(new Color(0x345389));
        lblSeuNomeConta.setForeground(Color.WHITE);
        lblSeuNomeConta.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblSeuNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblNomeConta = new JLabel("@beza"); // 100 is the initial width
        lblNomeConta.setFont(fonte);
        lblNomeConta.setMaximumSize(new Dimension(400, 28)); // Set the maximum size
        lblNomeConta.setPreferredSize(new Dimension(400, 28)); // Set the preferred size
        lblNomeConta.setBackground(new Color(0x2a4674));
        lblNomeConta.setForeground(Color.WHITE);
        lblNomeConta.setBorder(new EmptyBorder(0, 0, 0, 0));
        lblNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeSenhaContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeSenhaContaPanel.setLayout(new BoxLayout(nomeSenhaContaPanel, BoxLayout.X_AXIS));
        nomeSenhaContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeSenhaContaPanel.setBackground(new Color(0x345389));
        nomeSenhaContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblSenhaConta = new JLabel("Senha:");
        lblSenhaConta.setFont(fonte);
        lblSenhaConta.setBackground(new Color(0x345389));
        lblSenhaConta.setForeground(Color.WHITE);
        lblSenhaConta.setBorder(new EmptyBorder(0, 0, 0, 225)); // Adiciona espaço de 40 pixels ao redor
        lblSenhaConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfSenha = new JPasswordField(); // 100 is the initial width
        pfSenha.setFont(fonte);
        pfSenha.setEchoChar('*');
        pfSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfSenha.setBackground(new Color(0x2a4674));
        pfSenha.setForeground(Color.WHITE);
        pfSenha.setBorder(new LineBorder(new Color(0x2a4674)));
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
        lblSenhaConfirmarConta.setBorder(new EmptyBorder(0, 0, 0, 114)); // Adiciona espaço de 40 pixels ao redor
        lblSenhaConfirmarConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfConfirmarSenha = new JPasswordField(); // 100 is the initial width
        pfConfirmarSenha.setFont(fonte);
        pfConfirmarSenha.setEchoChar('*');
        pfConfirmarSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfConfirmarSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfConfirmarSenha.setBackground(new Color(0x2a4674));
        pfConfirmarSenha.setForeground(Color.WHITE);
        pfConfirmarSenha.setBorder(new LineBorder(new Color(0x2a4674)));
        pfConfirmarSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeNovaSenhaContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNovaSenhaContaPanel.setLayout(new BoxLayout(nomeNovaSenhaContaPanel, BoxLayout.X_AXIS));
        nomeNovaSenhaContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNovaSenhaContaPanel.setBackground(new Color(0x345389));
        nomeNovaSenhaContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblNovaSenhaConta = new JLabel("Nova Senha:");
        lblNovaSenhaConta.setFont(fonte);
        lblNovaSenhaConta.setBackground(new Color(0x345389));
        lblNovaSenhaConta.setForeground(Color.WHITE);
        lblNovaSenhaConta.setBorder(new EmptyBorder(0, 0, 0, 165)); // Adiciona espaço de 40 pixels ao redor
        lblNovaSenhaConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfNovaSenha = new JPasswordField(); // 100 is the initial width
        pfNovaSenha.setFont(fonte);
        pfNovaSenha.setEchoChar('*');
        pfNovaSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfNovaSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfNovaSenha.setBackground(new Color(0x2a4674));
        pfNovaSenha.setForeground(Color.WHITE);
        pfNovaSenha.setBorder(new LineBorder(new Color(0x2a4674)));
        pfNovaSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeNovaSenhaConfirmarNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNovaSenhaConfirmarNomeContaPanel.setLayout(new BoxLayout(nomeNovaSenhaConfirmarNomeContaPanel, BoxLayout.X_AXIS));
        nomeNovaSenhaConfirmarNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNovaSenhaConfirmarNomeContaPanel.setBackground(new Color(0x345389));
        nomeNovaSenhaConfirmarNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblNovaSenhaConfirmarConta = new JLabel("Confirmar Nova Senha:");
        lblNovaSenhaConfirmarConta.setFont(fonte);
        lblNovaSenhaConfirmarConta.setBackground(new Color(0x345389));
        lblNovaSenhaConfirmarConta.setForeground(Color.WHITE);
        lblNovaSenhaConfirmarConta.setBorder(new EmptyBorder(0, 0, 0, 54)); // Adiciona espaço de 40 pixels ao redor
        lblNovaSenhaConfirmarConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        pfNovaConfirmarSenha = new JPasswordField(); // 100 is the initial width
        pfNovaConfirmarSenha.setFont(fonte);
        pfNovaConfirmarSenha.setEchoChar('*');
        pfNovaConfirmarSenha.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        pfNovaConfirmarSenha.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        pfNovaConfirmarSenha.setBackground(new Color(0x2a4674));
        pfNovaConfirmarSenha.setForeground(Color.WHITE);
        pfNovaConfirmarSenha.setBorder(new LineBorder(new Color(0x2a4674)));
        pfNovaConfirmarSenha.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
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
	    
	    add(lblAlterarSenha);
	    add(Box.createRigidArea(new Dimension(0, 20)));
        add(nomeNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 30)));
        add(nomeSenhaContaPanel); 
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeSenhaConfirmarNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 40)));
        add(nomeNovaSenhaContaPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeNovaSenhaConfirmarNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(nomeBtnSalvarPanel);
        nomeNomeContaPanel.add(lblSeuNomeConta);
        nomeNomeContaPanel.add(lblNomeConta);
        nomeSenhaContaPanel.add(lblSenhaConta);
        nomeSenhaContaPanel.add(pfSenha);
        nomeSenhaConfirmarNomeContaPanel.add(lblSenhaConfirmarConta);
        nomeSenhaConfirmarNomeContaPanel.add(pfConfirmarSenha);
        nomeNovaSenhaContaPanel.add(lblNovaSenhaConta);
        nomeNovaSenhaContaPanel.add(pfNovaSenha);
        nomeNovaSenhaConfirmarNomeContaPanel.add(lblNovaSenhaConfirmarConta);
        nomeNovaSenhaConfirmarNomeContaPanel.add(pfNovaConfirmarSenha);
        nomeBtnSalvarPanel.add(lblbtnSalvar);
        nomeBtnSalvarPanel.add(btnSalvar);
    }

    private void definirEventos() {
    	pfConfirmarSenha.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				String n4 = pfNovaSenha.getText();
				String n5 = pfNovaConfirmarSenha.getText();
				if(!n2.isEmpty()  && !n3.isEmpty() && !n4.isEmpty()  && !n5.isEmpty()) {
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
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				String n4 = pfNovaSenha.getText();
				String n5 = pfNovaConfirmarSenha.getText();
				if(!n2.isEmpty()  && !n3.isEmpty() && !n4.isEmpty()  && !n5.isEmpty()) {
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
				String n2 = pfSenha.getText();
				String n3 = pfConfirmarSenha.getText();
				String n4 = pfNovaSenha.getText();
				String n5 = pfNovaConfirmarSenha.getText();
				if(!n2.isEmpty()  && !n3.isEmpty() && !n4.isEmpty()  && !n5.isEmpty()) {
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

