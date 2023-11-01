package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enj.appdesktop.model.daoo.ConsultaDAO;


public class JTelaUsuario extends JFrame {
    private Container contentPane;
    private JPanel quadro, pnTela;
    private JTextField lblNome, lblSexo, lblDataNasc;
    private JTextField lblNomeConta, lblSenha;
    private JButton btnSair, btnVoltar;
   
   
    public JTelaUsuario() {
    	
        setTitle("Dados do Usuário");
        contentPane = getContentPane();
        setLayout(new BorderLayout());
       
        pnTela = new JPanel();
		pnTela.setLayout(null); // Layout nulo para posicionar elementos manualmente
        pnTela.setBackground(Color.WHITE);
        
        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\menu\\convert-dpi.com\\6300.jpg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());

        

        Font customFont = new Font("Arial", Font.BOLD | Font.BOLD, 15);
        Font customFont2 = new Font("Arial", Font.BOLD | Font.BOLD, 20);

        quadro = new JPanel();
        
        
       
        lblNome = new JTextField(ConsultaDAO.getNome());
        lblNome.setFont(customFont);
        lblSexo = new JTextField(ConsultaDAO.getSexo());
        lblSexo.setFont(customFont);
        lblDataNasc = new JTextField(ConsultaDAO.getData());
        lblDataNasc.setFont(customFont);

      

        lblNomeConta = new JTextField(ConsultaDAO.getUsuario());
        lblNomeConta.setFont(customFont);
        lblSenha = new JTextField(ConsultaDAO.getSenha());
        lblSenha.setFont(customFont);
       
        lblNome.setOpaque(false);
		lblNome.setBorder(BorderFactory.createEmptyBorder());
		lblNome.setForeground(Color.BLACK);
		
		lblSexo.setOpaque(false);
		lblSexo.setBorder(BorderFactory.createEmptyBorder());
		lblSexo.setForeground(Color.BLACK);
		
		lblDataNasc.setOpaque(false);
		lblDataNasc.setBorder(BorderFactory.createEmptyBorder());
		lblDataNasc.setForeground(Color.BLACK);
		
		lblNomeConta.setOpaque(false);
		lblNomeConta.setBorder(BorderFactory.createEmptyBorder());
		lblNomeConta.setForeground(Color.BLACK);
		
		lblSenha.setOpaque(false);
		lblSenha.setBorder(BorderFactory.createEmptyBorder());
		lblSenha.setForeground(Color.BLACK);
    

        
       
        lblNome.setBounds(290, 270, 250, 50);
        lblSexo.setBounds(290, 410, 250, 50);
        lblDataNasc.setBounds(290, 550, 250, 50);
        lblNomeConta.setBounds(750, 270, 250, 50);
        lblSenha.setBounds(750, 410, 250, 50);
        
        //Posicionando
        
        /*lblNome.setBackground(Color.BLACK);
		lblDataNasc.setBackground(Color.BLACK);
		lblSexo.setBackground(Color.BLACK);
		lblNomeConta.setBackground(Color.BLACK);
		lblSenha.setBackground(Color.BLACK);*/
		
		
		pnTela.add(lblNome);
        pnTela.add(lblSexo);
        pnTela.add(lblDataNasc);
        pnTela.add(lblSenha);
        pnTela.add(lblNomeConta);
       
        
        
      

        btnSair = new JButton("Sair");
        btnSair.setForeground(Color.WHITE);
        btnSair.setFont(customFont2);
        btnSair.setBounds(1130, 25, 120, 45);
        //btnSair.setBackground(Color.BLUE);
        pnTela.add(btnSair);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFont(customFont2);
        btnVoltar.setBounds(1030, 25, 120, 45);
      //  btnVoltar.setBackground(Color.BLACK);
        pnTela.add(btnVoltar);
        pnTela.add(mockupLabel);
        
       
        // Torna os botões transparentes
		
		 
		btnSair.setOpaque(false);
        btnSair.setContentAreaFilled(false);
        btnSair.setBorderPainted(false);

        btnVoltar.setOpaque(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setBorderPainted(false);

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int number = 1;
            
                JOptionPane.showMessageDialog(null, "Você saiu da conta.");
                dispose();
                JTelaUsuario.abreInicial();
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            JTelaUsuario.abreMENU();
                
            }
        });

        add(pnTela);

        setResizable(false);
        setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight()); // Ajusta o tamanho da janela com base na imagem

    };
    
    public static void abreInicial() {
		JTelaInicial frame = new JTelaInicial();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // cetraliza a tela
		frame.setVisible(true);
		frame.setResizable(false);// desativa botão maximizar e minimizar
		//frame.setExtendedState(MAXIMIZED_BOTH);
	}
    
    public static void abreMENU() {
		JTelaMenu frame = new JTelaMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null); // cetraliza a tela
		frame.setVisible(true);
		frame.setResizable(false);// desativa botão maximizar e minimizar
		//frame.setExtendedState(MAXIMIZED_BOTH);
	}

    public static void abrir() {
        JTelaUsuario frame = new JTelaUsuario();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
    }

   public static void main(String[] args) {

        JTelaUsuario.abrir();
    }
}
