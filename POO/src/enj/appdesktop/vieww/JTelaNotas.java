package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import enj.appdesktop.controller.NotaController;
import enj.appdesktop.model.daoo.NotaIdDAO;
import enj.appdesktop.model.vo.NotasVO;

public class JTelaNotas extends JPanel {

    private List<NotasVO> nota;
    private JTextArea caixaTexto;
    private JTextField tituloCamp;
    private JButton salvar;
    private JButton editar;
    private JButton deletar;
    private JButton SalvarNota;
    private JButton Voltar;
    Font fonte;
    int id = 0;

    public JTelaNotas() {
        nota = new ArrayList<>();

        setSize(1000, 750);
        setLayout(null);  // Usando null layout
        
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);  // Remover a decoração padrão do sistema

        fonte = new Font("Verdana", Font.PLAIN, 17);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\7300.jpg");
        JLabel mockupLabel = new JLabel(mockupImage);
        mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());


     // Adicionar botão de fechar
        JButton closeButton = new JButton();
        closeButton.setBounds(1300, 10, 50, 50);
        panel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        JButton voltarButton = new JButton();
        voltarButton.setBounds(1160, 10, 50, 50);
        panel.add(voltarButton);
        voltarButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	JOptionPane.showMessageDialog( null, "Voltando à tela anterior");
		    	setVisible(false); // Fecha a janela atual (tela de login)
		        
		    }
		});

        // Adicionar botão de minimizar
        JButton minimizeButton = new JButton();
        minimizeButton.setBounds(1235, 10, 50, 50);
        panel.add(minimizeButton);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        });
        
        // Título
        tituloCamp = new JTextField();
        tituloCamp.setFont(fonte);
        tituloCamp.setBounds(100, 170, 1150, 50);
        panel.add(tituloCamp);
        tituloCamp.setOpaque(false);
        tituloCamp.setBorder(BorderFactory.createEmptyBorder());
        tituloCamp.setForeground(Color.BLACK);

        // Caixa de texto
        caixaTexto = new JTextArea();
        caixaTexto.setFont(fonte);
        JScrollPane sp = new JScrollPane(caixaTexto);
        sp.setBounds(100, 250, 1150, 350);
        panel.add(sp);
        
        sp.setOpaque(false);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.setForeground(Color.BLACK);
      

        // Botões
        salvar = new JButton("           ");
        salvar.setBounds(235, 659, 150, 40);
        salvar.setContentAreaFilled(false);  // Tornar a área do botão transparente
        salvar.setBorderPainted(false);  // Remover a borda do botão
        panel.add(salvar);

        editar = new JButton("           ");
        editar.setBounds(415, 659, 150, 40);
        editar.setContentAreaFilled(false);  // Tornar a área do botão transparente
        editar.setBorderPainted(false);  // Remover a borda do botão
        panel.add(editar);

        deletar = new JButton("          ");
        deletar.setBounds(595, 659, 150, 40);
        deletar.setContentAreaFilled(false);  // Tornar a área do botão transparente
        deletar.setBorderPainted(false);  // Remover a borda do botão
        panel.add(deletar);

        SalvarNota = new JButton("          ");
        SalvarNota.setBounds(965, 659, 150, 40);
        panel.add(SalvarNota);
        SalvarNota.setContentAreaFilled(false);  // Tornar a área do botão transparente
        SalvarNota.setBorderPainted(false);  // Remover a borda do botão


        Voltar = new JButton("           ");
        Voltar.setBounds(785, 659, 150, 40);
        Voltar.setContentAreaFilled(false);  // Tornar a área do botão transparente
        Voltar.setBorderPainted(false);  // Remover a borda do botão

        panel.add(Voltar);
        
        panel.add(mockupLabel);
        setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight());
        add(panel);

        // Adicionando ação para os botões
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String titulo = tituloCamp.getText();
            	String conteudo = caixaTexto.getText();
                NotaController notacontroller = new NotaController();
                notacontroller.salvarNota(titulo, conteudo);
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(false);
                deletar.setEnabled(false);
                SalvarNota.setEnabled(true);
              
            }
        });

        SalvarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(true);
                deletar.setEnabled(true);
                String titulo = tituloCamp.getText();
            	String conteudo = caixaTexto.getText();
                NotaController notacontroller = new NotaController();
                notacontroller.atualizarNota(new NotaIdDAO().buscarIdPorTitulo(titulo), titulo, conteudo);
                tituloCamp.setText("");
                caixaTexto.setText("");
            }
        });

        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
             
            }
        });

        Voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}