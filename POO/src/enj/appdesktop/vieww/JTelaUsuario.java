package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JTelaUsuario extends JFrame {
    private Container contentPane;
    private JPanel quadro, pnTela;
    private JLabel lblDados, lblNome, lblSexo, lblDataNasc;
    private JLabel lblDadosConta, lblNomeConta, lblID;
    private JButton btnSair, btnVoltar;
   

    public JTelaUsuario() {

        setTitle("Dados do Usuário");
        contentPane = getContentPane();
        setLayout(new BorderLayout());
       
        pnTela = new JPanel();
		pnTela.setLayout(null); // Layout nulo para posicionar elementos manualmente
        pnTela.setBackground(Color.WHITE);
        
        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\conta.jpeg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());

        

        Font customFont = new Font("Arial", Font.BOLD | Font.BOLD, 15);

        quadro = new JPanel();
        lblDados = new JLabel("Dados Pessoais");
        lblDados.setFont(customFont);
        lblNome = new JLabel("Nome: ");
        lblNome.setFont(customFont);
        lblSexo = new JLabel("Sexo: ");
        lblSexo.setFont(customFont);
        lblDataNasc = new JLabel("Data de Nascimento: ");
        lblDataNasc.setFont(customFont);

        lblDadosConta = new JLabel("Dados da Conta");
        lblDadosConta.setFont(customFont);

        lblNomeConta = new JLabel("Nome da Conta");
        lblNomeConta.setFont(customFont);
        lblID = new JLabel("Senha:");
        lblID.setFont(customFont);
        
    

        
        lblDados.setBounds(350, 50, 140, 20);
        lblNome.setBounds(150, 150, 250, 20);
        lblSexo.setBounds(150, 180, 250, 20);
        lblDataNasc.setBounds(150, 210, 250, 20);

        lblDadosConta.setBounds(350, 300, 140, 20);
        lblNomeConta.setBounds(150, 400, 250, 20);
        lblID.setBounds(150, 430, 360, 20);
        
        //Posicionando
        lblID.setForeground(Color.PINK);
        lblNome.setBackground(Color.pink);
		lblDataNasc.setBackground(Color.BLACK);
		lblSexo.setBackground(Color.BLACK);
		lblNomeConta.setBackground(Color.BLACK);
		
		
        pnTela.add(mockupLabel);
        pnTela.add(lblDados);
        pnTela.add(lblNome);
        pnTela.add(lblSexo);
        pnTela.add(lblDataNasc);
        pnTela.add(lblDadosConta);
        pnTela.add(lblNomeConta);
        pnTela.add(lblID);

        btnSair = new JButton("Sair");
        btnSair.setFont(customFont);
        btnSair.setBounds(1130, 25, 120, 45);
        //btnSair.setBackground(Color.BLACK);
        pnTela.add(btnSair);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(customFont);
        btnVoltar.setBounds(995, 25, 120, 45);
      //  btnVoltar.setBackground(Color.BLACK);
        pnTela.add(btnVoltar);
        
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

    }
    
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

 /*   public static void main(String[] args) {

        JTelaUsuario.abrir();
    }*/
}
