package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import enj.appdesktop.model.vo.ListaVO;

public class JTelaListas extends JFrame {
    private Container contentPane;
    private JPanel panel;
    private JLabel lblTitulo;
    private JTextField tfTitulo;
    private JTextArea taItens;
    private JButton /*btnCriar,*/ btnSalvarLista, btnDeletarLista, btnEditar;
    private List<ListaVO> listas; 
    private int id = 0;
    private int i;

    public JTelaListas() {
        setTitle("Lista Enumerada");
        contentPane = getContentPane();
        setLayout(null);
        setBounds(0, 0, 1000, 800);
        contentPane.setBackground(Color.PINK);

        panel = new JPanel();
        lblTitulo = new JLabel("Título da Lista:");
        tfTitulo = new JTextField();
        taItens = new JTextArea();
        //btnCriar = new JButton("Criar Lista");
        btnSalvarLista = new JButton("Salvar Lista");
        btnDeletarLista = new JButton("Deletar Lista");
        btnEditar = new JButton("Editar");

        panel.setLayout(null);
        panel.setBounds(250, 200, 500, 400);
        lblTitulo.setBounds(65, 30, 100, 20);
        tfTitulo.setBounds(155, 30, 260, 20);
        taItens.setBounds(125, 70, 240, 100);
        //btnCriar.setBounds(31, 200, 120, 30);
        btnSalvarLista.setBounds(31, 200, 120, 30);
        btnDeletarLista.setBounds(351, 200, 120, 30);
        btnEditar.setBounds(190, 200, 120, 30);

        listas = new ArrayList<>();

       /* btnCriar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = tfTitulo.getText();
                String[] itens = taItens.getText().split("\n");

                ListaVO lista = new ListaVO(titulo, itens);
                listas.add(lista);

            }
        });*/

        btnSalvarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = tfTitulo.getText();
                String conteudo = taItens.getText().concat("\n");
                id = id +1;
                ListaVO lista = new ListaVO(titulo, conteudo, id);
                listas.add(lista);
                tfTitulo.setText("");
                taItens.setText("");
                
                String mensagem;
                mensagem = "Lista com título: ".concat(titulo).concat("\n").concat("Itens:\n");
                
                for ( i = 0; i < taItens.getLineCount(); i++) {
                	i=i+1;
                	mensagem = mensagem+ i +(". ").concat(conteudo).concat("\n");
          
                }
                

                JOptionPane.showMessageDialog(null, mensagem, "Sua Lista", JOptionPane.INFORMATION_MESSAGE);
            }
            
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] titulos = new String[listas.size()];
                for (int i = 0; i < listas.size(); i++) {
                    titulos[i] = listas.get(i).getTitulo();
                }

                int selectedIndex = JOptionPane.showOptionDialog(
                        JTelaListas.this,
                        "Selecione a lista que deseja editar:",
                        "Editar Lista",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        titulos,
                        null
                );

                if (selectedIndex >= 0) {
                    ListaVO listaSelecionada = listas.get(selectedIndex);
                    tfTitulo.setText(listaSelecionada.getTitulo());
                    taItens.setText(String.join("\n", listaSelecionada.getItens()));
                }
            }
        });

        btnDeletarLista.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] titulos = new String[listas.size()];
                for (int i = 0; i < listas.size(); i++) {
                    titulos[i] = listas.get(i).getTitulo();
                }

                int selectedIndex = JOptionPane.showOptionDialog(
                        JTelaListas.this,
                        "Selecione a lista que deseja excluir:",
                        "Excluir Lista",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        titulos,
                        null
                );

                if (selectedIndex >= 0) {
                    listas.remove(selectedIndex);
                    JOptionPane.showMessageDialog(JTelaListas.this, "Lista Deletada!");
                }
            }
        });

        panel.add(lblTitulo);
        panel.add(tfTitulo);
        panel.add(taItens);
       // panel.add(btnCriar);
        panel.add(btnSalvarLista);
        panel.add(btnDeletarLista);
        panel.add(btnEditar);
        contentPane.add(panel);
    }

    public static void main(String[] args) {
        JTelaListas frame = new JTelaListas();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
