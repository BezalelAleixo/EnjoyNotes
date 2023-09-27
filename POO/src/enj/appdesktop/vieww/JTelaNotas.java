package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private JButton Salvar;
    private JButton Voltar;
    Font fonte;
    int id=0;
    
    public JTelaNotas() {
        nota = new ArrayList<>();

        setTitle("Enjoy Notes - Nova Nota");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new BorderLayout());
        
        fonte = new Font("Verdana", Font.PLAIN, 17);

        tituloCamp = new JTextField();
        tituloCamp.setFont(fonte);
        tituloCamp.setBorder(BorderFactory.createTitledBorder("Título"));
        inputPanel.add(tituloCamp, BorderLayout.NORTH);
        
        caixaTexto = new JTextArea();
        caixaTexto.setFont(fonte);
        JScrollPane sp = new JScrollPane(caixaTexto);
        inputPanel.add(sp, BorderLayout.CENTER);

        add(inputPanel, BorderLayout.CENTER);

        salvar = new JButton("Salvar Nota");
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloCamp.getText();
                String conteudo = caixaTexto.getText();
                
                id=id+1;
                
                NotasVO note = new NotasVO(id, titulo, conteudo);
                nota.add(note);
                tituloCamp.setText("");
                caixaTexto.setText("");
                JOptionPane.showMessageDialog(JTelaNotas.this, "Nota Salva!");
                
                SalvarNotaDAO salvarnota = new SalvarNotaDAO();
                salvarnota.SalvarNotaDAO(note);
                   
            }
        });
        
        
        
        editar = new JButton("Editar Nota");
        
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
            	salvar.setEnabled(false);
            	deletar.setEnabled(false);
            	Salvar.setEnabled(true);
            	
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
            
             
            	
            }});
       
        	Salvar = new JButton("Salvar");
        	Salvar.setEnabled(false);
            Salvar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
			
					salvar.setEnabled(true);
					deletar.setEnabled(true);
			
					
					NotasVO notas = new NotasVO(id, tituloCamp.getText(),caixaTexto.getText() );
               	AtualizarNotaDAO atualizar = new AtualizarNotaDAO();
               	atualizar.AtualizarNotaDAO(notas);
               	tituloCamp.setText("");
                   caixaTexto.setText("");
           
					}
				
			});  
        

        deletar = new JButton("Deletar Nota"); 
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
                NotasVO cod = new NotasVO(selectedIndex+1);
                DeletarNotaDAO delete = new DeletarNotaDAO();
                delete.DeletarNotaDAO(cod);
            }
        });
        Voltar = new JButton("Voltar ao menu");
        Voltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JTelaNotas.VoltarMenu();
				
			}
		});
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(salvar);
        buttonPanel.add(editar);
        buttonPanel.add(deletar); 
        buttonPanel.add(Salvar);
        buttonPanel.add(Voltar);


        add(buttonPanel, BorderLayout.SOUTH);
        
        
    }

    public static void VoltarMenu(){
    JTelaMenu menu =  new JTelaMenu();
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
