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

import enj.appdesktop.model.daoo.ConsultaDAO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

public class FiltroPesquisa extends JFrame{
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
		setTitle("Pesquise");
		cnTela = getContentPane();
		setSize(1366,768);
		// Usando BorderLayout para posicionar pnBarraPes no topo
        setLayout(new BorderLayout());

        pnBarraPes = new JPanel();
        pnBarraPes.setLayout(null);
        pnBarraPes.setBackground(Color.GRAY);

        // Defina o tamanho preferido do pnBarraPes
        pnBarraPes.setPreferredSize(new Dimension(1366, 150));

        pnResultados = new JPanel();
        pnResultados.setBackground(Color.WHITE);

        // Adicione pnBarraPes ao topo e pnResultados abaixo
        cnTela.add(pnBarraPes, BorderLayout.NORTH);
        cnTela.add(pnResultados, BorderLayout.CENTER);
	}
	private void posicionandoComponentes() {
		Font fonte = new Font("Verdana", Font.PLAIN, 16);
				
		tfpesquisa = new JTextField(JTelaMenu.getPesquisa());
		tfpesquisa.setBounds(200, 50, 500, 40);
		tfpesquisa.setFont(fonte);
		
		btnPesquisa = new JButton(new ImageIcon("C:\\Users\\prfel\\Pictures\\ppes.png"));
		btnPesquisa.setBounds(700, 50, 46, 44);
		
		btnVoltar = new JButton(new ImageIcon("C:\\Users\\prfel\\Pictures\\voltin.png"));
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
			JTelaMenu.abreMenuPrincipal();
			dispose();
			}
		});
		
		btnPesquisa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String pesquisa = tfpesquisa.getText();
				ConsultaDAO buscar = new ConsultaDAO();
				if(!pesquisa.isEmpty() && buscar.verificarPesquisa(pesquisa)) {
					buscar.consultar(pesquisa);
					 modeloTabela.setRowCount(0); // Limpa a tabela
			            for (NotasVO nota : buscar.getNotasList()) {
			                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
				}
			            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			           
			} else if (!pesquisa.isEmpty() && buscar.verificarPesquisaLIS(pesquisa)) {
				buscar.consultarLIS(pesquisa);
				modeloTabela.setRowCount(0); // Limpa a tabela
	            for (ListaVO lista : buscar.getListResult()) {
	                modeloTabela.addRow(new Object[]{lista.getTitulo(), lista.getItens()});
		}
	            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			} else {
				JOptionPane.showMessageDialog(null, "Nada foi encontrado");
			}
				
			}
		});
		tfpesquisa.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String pesquisa = tfpesquisa.getText();
				ConsultaDAO buscar = new ConsultaDAO();
				if(pesquisa != null  && buscar.verificarPesquisa(pesquisa)) {
					buscar.consultar(pesquisa);
					 modeloTabela.setRowCount(0); // Limpa a tabela
			            for (NotasVO nota : buscar.getNotasList()) {
			                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
				}
			            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			           
			} else if (!pesquisa.isEmpty() && buscar.verificarPesquisaLIS(pesquisa)) {
				buscar.consultarLIS(pesquisa);
				modeloTabela.setRowCount(0); // Limpa a tabela
	            for (ListaVO lista : buscar.getListResult()) {
	                modeloTabela.addRow(new Object[]{lista.getTitulo(), lista.getItens()});
		}
	            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String pesquisa = tfpesquisa.getText();
				ConsultaDAO buscar = new ConsultaDAO();
				if(!pesquisa.isEmpty() && buscar.verificarPesquisa(pesquisa)) {
					buscar.consultar(pesquisa);
					 modeloTabela.setRowCount(0); // Limpa a tabela
			            for (NotasVO nota : buscar.getNotasList()) {
			                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
				}
			            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			           
			} else if (!pesquisa.isEmpty() && buscar.verificarPesquisaLIS(pesquisa)) {
				buscar.consultarLIS(pesquisa);
				modeloTabela.setRowCount(0); // Limpa a tabela
	            for (ListaVO lista : buscar.getListResult()) {
	                modeloTabela.addRow(new Object[]{lista.getTitulo(), lista.getItens()});
		}
	            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				String pesquisa = tfpesquisa.getText();
				ConsultaDAO buscar = new ConsultaDAO();
				if(!pesquisa.isEmpty() && buscar.verificarPesquisa(pesquisa)) {
					buscar.consultar(pesquisa);
					 modeloTabela.setRowCount(0); // Limpa a tabela
			            for (NotasVO nota : buscar.getNotasList()) {
			                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
				}
			            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			           
			} else if (!pesquisa.isEmpty() && buscar.verificarPesquisaLIS(pesquisa)) {
				buscar.consultarLIS(pesquisa);
				modeloTabela.setRowCount(0); // Limpa a tabela
	            for (ListaVO lista : buscar.getListResult()) {
	                modeloTabela.addRow(new Object[]{lista.getTitulo(), lista.getItens()});
		}
	            modeloTabela.fireTableDataChanged(); // Atualiza a tabela
			}
				
			}
		});
		cbFiltro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultaDAO buscar = new ConsultaDAO();
				if(cbFiltro.getSelectedIndex() == 0) {
					buscar.filtro1();
					modeloTabela.setRowCount(0); // Limpa a tabela
		            for (NotasVO nota : buscar.getTodasNotas1()) {
		                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
			}
		            modeloTabela.fireTableDataChanged();
				}
				else if(cbFiltro.getSelectedIndex() == 1) {
					buscar.filtro2();
					modeloTabela.setRowCount(0); // Limpa a tabela
		            for (NotasVO nota : buscar.getTodasNotas2()) {
		                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
			}
		            modeloTabela.fireTableDataChanged();
				}
				else if(cbFiltro.getSelectedIndex() == 2) {
					buscar.filtro3();
					modeloTabela.setRowCount(0); // Limpa a tabela
		            for (NotasVO nota : buscar.getTodasNotas3()) {
		                modeloTabela.addRow(new Object[]{nota.getTitulo(), nota.getContent()});
			}
		            modeloTabela.fireTableDataChanged();
				}
				
			}
		});
	}
	public static void abrir(){
		FiltroPesquisa frame = new FiltroPesquisa();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		FiltroPesquisa.abrir();
	}
}

