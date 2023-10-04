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

import enj.appdesktop.model.daoo.AtualizarNotaDAO;
import enj.appdesktop.model.daoo.DeletarNotaDAO;
import enj.appdesktop.model.daoo.SalvarNotaDAO;
import enj.appdesktop.model.vo.NotasVO;

public class JTelaNotas extends JFrame {

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

        setTitle("Enjoy Notes - Nova Nota");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // Usando null layout
        
        setUndecorated(true);  // Remover a barra de título padrão
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);  // Remover a decoração padrão do sistema

        fonte = new Font("Verdana", Font.PLAIN, 17);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

        ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\menu\\convert-dpi.com\\7300.jpg");
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
		        AgendaApp.abreMenu();
		    }
		});

        // Adicionar botão de minimizar
        JButton minimizeButton = new JButton();
        minimizeButton.setBounds(1235, 10, 50, 50);
        panel.add(minimizeButton);
        minimizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED);
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
        setContentPane(panel);

        // Adicionando ação para os botões
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloCamp.getText();
                String conteudo = caixaTexto.getText();
                id = id + 1;
                NotasVO note = new NotasVO(id, titulo, conteudo);
                nota.add(note);
                tituloCamp.setText("");
                caixaTexto.setText("");
                JOptionPane.showMessageDialog(JTelaNotas.this, "Nota Salva!");
                SalvarNotaDAO salvarnota = new SalvarNotaDAO();
                salvarnota.SalvarNotaDAO(note);
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(false);
                deletar.setEnabled(false);
                SalvarNota.setEnabled(true);
                int selectedIndex = JOptionPane.showOptionDialog(
                        JTelaNotas.this,
                        "Selecione a nota que deseja editar: ",
                        "Editar Nota",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nota.toArray(),
                        null
                );
                if (selectedIndex >= 0) {
                    NotasVO selectedNote = nota.get(selectedIndex);
                    tituloCamp.setText(selectedNote.getTitulo());
                    caixaTexto.setText(selectedNote.getContent());
                    nota.remove(selectedNote);
                }
            }
        });

        SalvarNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar.setEnabled(true);
                deletar.setEnabled(true);
                NotasVO notas = new NotasVO(id, tituloCamp.getText(), caixaTexto.getText());
                AtualizarNotaDAO atualizar = new AtualizarNotaDAO();
                atualizar.AtualizarNotaDAO(notas);
                tituloCamp.setText("");
                caixaTexto.setText("");
            }
        });

        deletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] notas = new String[nota.size()];
                for (int i = 0; i < nota.size(); i++) {
                    notas[i] = nota.get(i).getTitulo();
                }
                int selectedIndex = JOptionPane.showOptionDialog(
                        JTelaNotas.this,
                        "Selecione a nota que deseja excluir: ",
                        "Excluir Nota",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        notas,
                        null
                );

                if (selectedIndex >= 0) {
                    NotasVO selectedNote = nota.get(selectedIndex);
                    nota.remove(selectedNote);
                    JOptionPane.showMessageDialog(JTelaNotas.this, "Nota Deletada!");
                }
                NotasVO cod = new NotasVO(selectedIndex + 1);
                DeletarNotaDAO delete = new DeletarNotaDAO();
                delete.DeletarNotaDAO(cod);
            }
        });

        Voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                JTelaNotas.VoltarMenu();
            }
        });
    }

    public static void VoltarMenu() {
        JTelaMenu menu = new JTelaMenu();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(menu);
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JTelaNotas app = new JTelaNotas();
                app.setVisible(true);
            }
        });
    }
}