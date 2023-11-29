package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import enj.appdesktop.model.vo.NotasVO;

public class FiltroPesquisa extends JPanel{
	private Container cnTela;
	private JPanel pnBarraPes, pnResultados;
	private JTextField tfpesquisa;
	private JButton btnPesquisa, btnVoltar;
	private JComboBox cbFiltro;
	private JTable tabelaResultados;
	private DefaultTableModel modeloTabela;
	
	public FiltroPesquisa() {
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
	}

	

	private void inicializarComponentes() {
		setSize(1366,768);
		
        setLayout(new BorderLayout());

        pnBarraPes = new JPanel();
        pnBarraPes.setLayout(null);
        pnBarraPes.setBackground(new Color(0x2a4674));

        
        pnBarraPes.setPreferredSize(new Dimension(1366, 150));

        pnResultados = new JPanel();
        pnResultados.setBackground(new Color(0x84CAED));

       
        add(pnBarraPes, BorderLayout.NORTH);
        add(pnResultados, BorderLayout.CENTER);
	}
	private void posicionandoComponentes() {
		Font fonte = new Font("Verdana", Font.PLAIN, 16);
				
		tfpesquisa = new JTextField(/*JTelaMenu.getPesquisa()*/);
		tfpesquisa.setBounds(200, 50, 500, 40);
		tfpesquisa.setFont(fonte);
		
		btnPesquisa = new JButton(/*new ImageIcon("C:\\Users\\prfel\\Pictures\\ppes.png")*/);
		btnPesquisa.setBounds(700, 50, 46, 44);
		
		btnVoltar = new JButton(/*new ImageIcon("C:\\Users\\prfel\\Pictures\\voltin.png")*/);
		btnVoltar.setBounds(30, 50, 46, 44);
		
		String []tipos = {"      A a Z", "      Z a A", "Data de Criação"};
		cbFiltro = new JComboBox(tipos);
		cbFiltro.setBounds(1150, 50, 135, 25);
		cbFiltro.setFont(fonte);
		
		
		pnBarraPes.add(tfpesquisa);
		pnBarraPes.add(btnPesquisa);
		pnBarraPes.add(btnVoltar);
		pnBarraPes.add(cbFiltro);
		
		modeloTabela = new DefaultTableModel();
		modeloTabela.addColumn("titulo");
		modeloTabela.addColumn("conteudo");
		
		 tabelaResultados = new JTable(modeloTabela);
         
         JScrollPane scrollPane = new JScrollPane(tabelaResultados);
   
         pnResultados.add(scrollPane);
        
	}

	private void definirEventos() {
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {


			}
		});
		
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						
			}
		});
		tfpesquisa.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
			
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
				
			}
		});
		cbFiltro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
}

