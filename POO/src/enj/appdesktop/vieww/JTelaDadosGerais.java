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

import enj.appdesktop.controller.UsuarioController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.UsuarioVO;


public class JTelaDadosGerais extends JPanel {
    private JLabel lblNome, lblNomeConta, lblData_de_Nascimento, lblSexo, lblID;
    private JLabel lblMockupConta, lblDadosGerais;
    private ContaVO conta;
    private JTelaSessoes telaSessoes;
    private UsuarioVO usuario;

    public JTelaDadosGerais(ContaVO conta, JTelaSessoes telaSessoes) {
    	this.conta = conta;
        this.telaSessoes = telaSessoes;
        int id_conta_CE = conta.getId_conta();
        UsuarioController user = new UsuarioController();
        user.BuscarDadosUSER(id_conta_CE);
        usuario = user.MyUser();
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
        Font fonte3 = new Font("Garet", Font.PLAIN, 9);
        
        lblDadosGerais = new JLabel("Você e EnjoyNotes");
        lblDadosGerais.setFont(fonte);
        lblDadosGerais.setBackground(new Color(0x345389));
        lblDadosGerais.setForeground(Color.WHITE);
        MatteBorder emptyBorder1 = BorderFactory.createMatteBorder(20, 40, 0, 0, new Color(0x345389));
		MatteBorder redBottomBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
	    Border compoundBorder1 = BorderFactory.createCompoundBorder(emptyBorder1, redBottomBorder1);
	    lblDadosGerais.setBorder(compoundBorder1); // Adiciona espaço de 40 pixels ao redor
        lblDadosGerais.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblID = new JLabel("ID: "+conta.getId_conta());
        lblID.setFont(fonte3);
        lblID.setBackground(new Color(0x345389));
        lblID.setForeground(Color.WHITE);
        lblID.setBorder(new EmptyBorder(0, 1000, 0, 0)); // Adiciona espaço de 40 pixels ao redor
        lblID.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblMockupConta = new JLabel(new ImageIcon(conta.getFoto()));
        lblMockupConta.setPreferredSize(new Dimension(193, 193));
        lblMockupConta.setBackground(new Color(0x2a4674));
        lblMockupConta.setBorder(new EmptyBorder(0, 441, 0, 0));
        lblMockupConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        lblNomeConta = new JLabel("Usuário: "+conta.getNome_perfil());
        lblNomeConta.setFont(fonte);
        lblNomeConta.setBackground(new Color(0x345389));
        lblNomeConta.setForeground(Color.WHITE);
        lblNomeConta.setBorder(new EmptyBorder(0, 40, 0, 0)); // Adiciona espaço de 40 pixels ao redor
        lblNomeConta.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblNome = new JLabel("Nome Completo: "+usuario.getNome());
        lblNome.setFont(fonte2);
        lblNome.setBackground(new Color(0x345389));
        lblNome.setForeground(Color.WHITE);
        lblNome.setBorder(new EmptyBorder(0, 40, 0, 0));
        lblNome.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblData_de_Nascimento = new JLabel("Data de Nascimento: "+ usuario.getDatanasc());
        lblData_de_Nascimento.setFont(fonte2);
        lblData_de_Nascimento.setBackground(new Color(0x345389));
        lblData_de_Nascimento.setForeground(Color.WHITE);
        lblData_de_Nascimento.setBorder(new EmptyBorder(0, 40, 0, 0));
        lblData_de_Nascimento.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        lblSexo = new JLabel("Sexo: "+usuario.getSexo());
        lblSexo.setFont(fonte2);
        lblSexo.setBackground(new Color(0x345389));
        lblSexo.setForeground(Color.WHITE);
        lblSexo.setBorder(new EmptyBorder(0, 40, 0, 0));
        lblSexo.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        
        
	    add(lblDadosGerais);
	    add(Box.createRigidArea(new Dimension(0, 18)));
	    add(lblID);
        add(lblMockupConta);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lblNomeConta); 
        add(Box.createRigidArea(new Dimension(0, 5))); // Espaço rígido de 20 pixels entre lblNomeConta e lblNome
        add(lblNome);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(lblData_de_Nascimento);
        add(Box.createRigidArea(new Dimension(0, 10)));// Espaço rígido de 20 pixels entre lblNomeConta e lblNome
        add(lblSexo);
        
    }

    private void definirEventos() {
      
    }
}
