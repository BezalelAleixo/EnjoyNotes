package enj.appdesktop.vieww;

import java.awt.BorderLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import enj.appdesktop.controller.QuadroController;
import enj.appdesktop.model.vo.ContaVO;

public class JTelaCriarQuadro extends JPanel{
    private JPanel nomeNovoNomeContaPanel,nomeSenhaContaPanel, nomeSenhaConfirmarNomeContaPanel, nomeBtnSalvarPanel;
    private JLabel lbltitulo, lblDescricao, lblbtnSalvar;
    private JLabel lblNovoQuadro;
    private JTextField tfTitulo;
    private JTextArea taDescricao;
    private JButton btnSalvar;
    private ContaVO conta;
    private JTelaQuadros quadros;
    private JTelaSessoes telaSessoes;


    public JTelaCriarQuadro(ContaVO conta, JTelaSessoes telaSessoes) {
    	this.conta = conta;
    	this.telaSessoes = telaSessoes;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Usando BoxLayout com orientação vertical
        setBackground(new Color(0x345389));
        setPreferredSize(new Dimension(1366, 640));
        setMaximumSize(new Dimension(1366, 640));
    }

    private void posicionandoComponentes() {
    	
        Font fonte = new Font("Garet", Font.PLAIN, 24);
        Font fonte2 = new Font("Garet", Font.PLAIN, 18);
        Font fonte3 = new Font("Garet", Font.PLAIN, 12);
        
        lblNovoQuadro = new JLabel("Novo Quadro");
        lblNovoQuadro.setFont(fonte);
        lblNovoQuadro.setBackground(new Color(0x345389));
        lblNovoQuadro.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblNovoQuadro.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblNovoQuadro.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeNovoNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeNovoNomeContaPanel.setLayout(new BoxLayout(nomeNovoNomeContaPanel, BoxLayout.X_AXIS));
        nomeNovoNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeNovoNomeContaPanel.setBackground(new Color(0x345389));
        nomeNovoNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lbltitulo = new JLabel("Titulo:");
        lbltitulo.setFont(fonte);
        lbltitulo.setBackground(new Color(0x345389));
        lbltitulo.setForeground(Color.WHITE);
        lbltitulo.setBorder(new EmptyBorder(0, 0, 0, 95)); // Adiciona espaço de 40 pixels ao redor
        lbltitulo.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        tfTitulo = new JTextField(); // 100 is the initial width
        tfTitulo.setFont(fonte);
        tfTitulo.setMaximumSize(new Dimension(400, 24)); // Set the maximum size
        tfTitulo.setPreferredSize(new Dimension(400, 24)); // Set the preferred size
        tfTitulo.setBackground(new Color(0x2a4674));
        tfTitulo.setForeground(Color.WHITE);
        tfTitulo.setBorder(new LineBorder(tfTitulo.getBackground()));
        tfTitulo.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeSenhaContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeSenhaContaPanel.setLayout(new BoxLayout(nomeSenhaContaPanel, BoxLayout.X_AXIS));
        nomeSenhaContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeSenhaContaPanel.setBackground(new Color(0x345389));
        nomeSenhaContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblDescricao = new JLabel("Descrição:");
        lblDescricao.setFont(fonte);
        lblDescricao.setBackground(new Color(0x345389));
        lblDescricao.setForeground(Color.WHITE);
        lblDescricao.setBorder(new EmptyBorder(0, 0, 0, 50)); // Adiciona espaço de 40 pixels ao redor
        lblDescricao.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        taDescricao = new JTextArea(); // 100 is the initial width
        taDescricao.setFont(fonte);
        taDescricao.setMaximumSize(new Dimension(400, 190)); // Set the maximum size
        taDescricao.setPreferredSize(new Dimension(400, 190)); // Set the preferred size
        taDescricao.setBackground(new Color(0x2a4674));
        taDescricao.setForeground(Color.WHITE);
        taDescricao.setBorder(new LineBorder(taDescricao.getBackground()));
        taDescricao.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        nomeSenhaConfirmarNomeContaPanel = new JPanel(); // Crie um novo painel para lblNomeConta e btnOpcional
        nomeSenhaConfirmarNomeContaPanel.setLayout(new BoxLayout(nomeSenhaConfirmarNomeContaPanel, BoxLayout.X_AXIS));
        nomeSenhaConfirmarNomeContaPanel.setBorder(new EmptyBorder(0, 40, 0, 0));
        nomeSenhaConfirmarNomeContaPanel.setBackground(new Color(0x345389));
        nomeSenhaConfirmarNomeContaPanel.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
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
	    
	    add(lblNovoQuadro);
	    add(Box.createRigidArea(new Dimension(0, 20)));
        add(nomeNovoNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeSenhaContaPanel); 
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(nomeSenhaConfirmarNomeContaPanel);
        add(Box.createRigidArea(new Dimension(0, 25)));
        add(nomeBtnSalvarPanel);
        nomeNovoNomeContaPanel.add(lbltitulo);
        nomeNovoNomeContaPanel.add(tfTitulo);
        nomeSenhaContaPanel.add(lblDescricao);
        nomeSenhaContaPanel.add(taDescricao);
        nomeBtnSalvarPanel.add(lblbtnSalvar);
        nomeBtnSalvarPanel.add(btnSalvar);
    }

    private void definirEventos() {
    	
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
			QuadroController novoQuadro = new QuadroController();
			novoQuadro.salvarQuadro(tfTitulo.getText(), taDescricao.getText(), conta.getId_conta());
			telaSessoes.getContentPane().removeAll();
			JTelaQuadros quadro = new JTelaQuadros(conta, telaSessoes);
			telaSessoes.getContentPane().add(quadro, BorderLayout.CENTER);
			telaSessoes.revalidate();
			telaSessoes.repaint();
			
		}
	});
    }
}

