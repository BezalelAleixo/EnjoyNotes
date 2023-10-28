package enj.appdesktop.vieww;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;


import enj.appdesktop.model.daoo.ListaDAO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

public class JTelaListas extends JFrame {
	private Container contentPane;
	private JPanel panel;
	private JTextField tfTitulo;
	private JTextArea taItens;
	private JButton /* btnCriar, */ btnSalvarLista, btnDeletarLista, btnEditar, btnSalvar, btnVoltarMenu;
	private List<ListaVO> listas;
	private int id = 0;
	private int i;

	public JTelaListas() {
		setTitle("Lista Enumerada");
		contentPane = getContentPane();
		setLayout(null);
		setBounds(0, 0, 1000, 800);
		ImageIcon mockupImage = new ImageIcon("C:\\Users\\prfel\\Documents\\Bezalel\\menu\\convert-dpi.com\\8300.jpg");
		JLabel mockupLabel = new JLabel(mockupImage);
		mockupLabel.setBounds(0, 0, mockupImage.getIconWidth(), mockupImage.getIconHeight());
		
		Font fonte = new Font("Verdana", Font.PLAIN, 17);

		panel = new JPanel();
		tfTitulo = new JTextField();
		taItens = new JTextArea();
		// btnCriar = new JButton("");
		btnSalvarLista = new JButton("");
		btnDeletarLista = new JButton("");
		btnEditar = new JButton("");
		btnVoltarMenu = new JButton("");

		setUndecorated(true); // Remover a barra de título padrão
		getRootPane().setWindowDecorationStyle(JRootPane.NONE); // Remover a decoração padrão do sistema

		JButton closeButton = new JButton();
		closeButton.setBounds(1300, 10, 50, 50);
		panel.add(closeButton);
		closeButton.setContentAreaFilled(false);
		closeButton.setBorderPainted(false);
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JButton voltarButton = new JButton();
		voltarButton.setBounds(1160, 10, 50, 50);
		panel.add(voltarButton);
		voltarButton.setContentAreaFilled(false);
		voltarButton.setBorderPainted(false);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Voltando à tela anterior");
				setVisible(false); // Fecha a janela atual (tela de login)
				AgendaApp.abreMenu();
			}
		});

		// Adicionar botão de minimizar
		JButton minimizeButton = new JButton();
		minimizeButton.setBounds(1235, 10, 50, 50);
		panel.add(minimizeButton);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});

		panel.setLayout(null);
		panel.setBounds(250, 200, 500, 400);
		tfTitulo.setBounds(100, 135, 1150, 50);
		tfTitulo.setFont(fonte);
		tfTitulo.setOpaque(false);
		tfTitulo.setBorder(BorderFactory.createEmptyBorder());
		tfTitulo.setForeground(Color.BLACK);
		taItens.setBounds(100, 250, 1150, 350);
		taItens.setFont(fonte);;
		// btnCriar.setBounds(31, 200, 120, 30);
		btnSalvarLista.setBounds(90, 659, 230, 80);
		btnDeletarLista.setBounds(540, 659, 230, 80);
		btnEditar.setBounds(320, 659, 230, 80);
		btnVoltarMenu.setBounds(1000, 659, 230, 80);

		// Botôes Invisíveis
		btnSalvarLista.setOpaque(false);
		btnSalvarLista.setContentAreaFilled(false);
		btnSalvarLista.setBorderPainted(false);

		btnDeletarLista.setOpaque(false);
		btnDeletarLista.setContentAreaFilled(false);
		btnDeletarLista.setBorderPainted(false);

		btnEditar.setOpaque(false);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorderPainted(false);

		btnVoltarMenu.setOpaque(false);
		btnVoltarMenu.setContentAreaFilled(false);
		btnVoltarMenu.setBorderPainted(false);
		
		
		// rbtFeminino.setOpaque(false);
		// rbtFeminino.setContentAreaFilled(false);
		// rbtFeminino.setBorderPainted(false);

		// rbtMasculino.setOpaque(false);
		// rbtMasculino.setContentAreaFilled(false);
		// rbtMasculino.setBorderPainted(false);

		listas = new ArrayList<>();

		/*
		 * btnCriar.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String titulo = tfTitulo.getText(); String[]
		 * itens = taItens.getText().split("\n");
		 * 
		 * ListaVO lista = new ListaVO(titulo, itens); listas.add(lista);
		 * 
		 * } });
		 */

		btnSalvarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = tfTitulo.getText();
				String conteudo = taItens.getText().concat("\n");
				id = id + 1;
				ListaVO lista = new ListaVO(titulo, conteudo, id);
				listas.add(lista);
				tfTitulo.setText("");
				taItens.setText("");

				String mensagem;
				mensagem = "Lista com título: ".concat(titulo).concat("\n").concat("Itens:\n");

				mensagem = mensagem.concat(conteudo).concat("\n");

				JOptionPane.showMessageDialog(null, mensagem, "Sua Lista", JOptionPane.INFORMATION_MESSAGE);

				ListaDAO salvar = new ListaDAO();
				salvar.SalvarListaDAO(lista);
			}

		});

		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvarLista.setEnabled(false);
				btnDeletarLista.setEnabled(false);
				btnSalvar.setEnabled(true);
				String[] titulos = new String[listas.size()];
				for (int i = 0; i < listas.size(); i++) {
					titulos[i] = listas.get(i).getTitulo();
				}

				int selectedIndex = JOptionPane.showOptionDialog(JTelaListas.this,
						"Selecione a lista que deseja editar:", "Editar Lista", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, titulos, null);

				if (selectedIndex >= 0) {
					ListaVO listaSelecionada = listas.get(selectedIndex);
					tfTitulo.setText(listaSelecionada.getTitulo());
					taItens.setText(String.join("\n", listaSelecionada.getItens()));
				}
			}
		});
		btnSalvar = new JButton("");
		btnSalvar.setBounds(770, 659, 230, 80);
		btnSalvar.setEnabled(false);
		btnSalvar.setOpaque(false);
		btnSalvar.setContentAreaFilled(false);
		btnSalvar.setBorderPainted(false);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnSalvarLista.setEnabled(true);
				btnDeletarLista.setEnabled(true);
				String titulo = tfTitulo.getText();
				String conteudo = taItens.getText();

				ListaVO listas = new ListaVO(titulo, conteudo, id);
				ListaDAO atualizar = new ListaDAO();
				atualizar.AtualizarListaDAO(listas);
				tfTitulo.setText("");
				taItens.setText("");

			}
		});

		btnDeletarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] titulos = new String[listas.size()];
				for (int i = 0; i < listas.size(); i++) {
					titulos[i] = listas.get(i).getTitulo();
				}

				int selectedIndex = JOptionPane.showOptionDialog(JTelaListas.this,
						"Selecione a lista que deseja excluir:", "Excluir Lista", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, titulos, null);

				if (selectedIndex >= 0) {
					listas.remove(selectedIndex);
					JOptionPane.showMessageDialog(JTelaListas.this, "Lista Deletada!");

				}

				ListaVO cod = new ListaVO(selectedIndex + 1);
				ListaDAO delete = new ListaDAO();
				delete.DeletarListaDAO(cod);
			}
		});

		btnVoltarMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JTelaListas.AbreMenu();

			}
		});

		panel.add(tfTitulo);
		panel.add(taItens);
		// panel.add(btnCriar);
		panel.add(btnSalvarLista);
		panel.add(btnDeletarLista);
		panel.add(btnEditar);
		panel.add(btnSalvar);
		panel.add(btnVoltarMenu);
		contentPane.add(panel);
		panel.add(mockupLabel);
		setSize(mockupImage.getIconWidth(), mockupImage.getIconHeight()); // Ajusta o tamanho da janela com base na
																			// imagem
		setContentPane(panel);
	}

	public static void AbreMenu() {
		JTelaMenu menu = new JTelaMenu();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setLocationRelativeTo(menu);
		menu.setVisible(true);
	}

	public static void main(String[] args) {
		JTelaListas frame = new JTelaListas();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}