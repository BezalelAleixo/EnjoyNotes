package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import enj.appdesktop.controller.ContaController;
import enj.appdesktop.controller.SessaoController;
import enj.appdesktop.controller.UsuarioController;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.UsuarioVO;

public class JTelaSelecionarFoto extends JPanel{
	private JPanel pnPrincipal, pnBarra;
	private JLabel lblPergunta, lblMockupLogo, lblImagem;
	private JTextField tfLocalImage;
	private JButton btnConcluirCadastro, btnCancelar, btnProcurar;
	private JTelaSessoes telaSessoes;
	private UsuarioVO usuario;
	private String nome_perfil;
	private String senha;
	
	public JTelaSelecionarFoto (JTelaSessoes telaSessoes, UsuarioVO usuario, String nome_perfil, String senha) {
		this.telaSessoes = telaSessoes;
		this.usuario = usuario;
		this.nome_perfil = nome_perfil;
		this.senha = senha;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
		
	}

	private void inicializarComponentes() {
		
		setSize(1366,768);
		
		setLayout(new BorderLayout());
		
		pnBarra = new JPanel();
        pnBarra.setLayout(null);
        pnBarra.setBackground(new Color(0x2a4674));
        pnBarra.setPreferredSize(new Dimension(1366, 128));
        
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBackground(new Color(0x84CAED));
        
        add(pnBarra, BorderLayout.NORTH);
        add(pnPrincipal, BorderLayout.CENTER);
	}

	private void posicionandoComponentes() {
		Font fonte = new Font("Bernoru", Font.BOLD, 24);
		
		lblMockupLogo = new JLabel(new ImageIcon("D:\\projetoENjoyNotes\\logo01.png"));	
		lblMockupLogo.setBounds(51, 29, 139, 77);
		
		lblPergunta = new JLabel("Escolha a foto de perfil");
		lblPergunta.setFont(fonte);
		lblPergunta.setForeground(new Color(0x2a4674));
		lblPergunta.setBounds(503, 50, 600, 24);
		
		lblImagem = new JLabel();
		lblImagem.setBounds(608, 80, 150, 150);
		pnPrincipal.add(lblImagem);
		
		Font fonte2 = new Font("Bernoru", Font.BOLD, 24);
		
		tfLocalImage = new JTextField();
		tfLocalImage.setFont(fonte2);
		tfLocalImage.setBounds(368,300,400,42);
		tfLocalImage.setBackground(new Color(0x2a4674));
		tfLocalImage.setForeground(Color.WHITE);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setFont(fonte2);
		btnProcurar.setBounds(768, 300, 120, 42);
		btnProcurar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnProcurar.setBackground(new Color(0x2a4674));
		btnProcurar.setForeground(Color.WHITE);
		
		btnConcluirCadastro = new JButton("Concluir Cadastro");
		btnConcluirCadastro.setFont(fonte2);
		btnConcluirCadastro.setBounds(255, 400, 250, 42);
		btnConcluirCadastro.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnConcluirCadastro.setBackground(new Color(0x2a4674));
		btnConcluirCadastro.setForeground(Color.WHITE);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(fonte2);
		btnCancelar.setBounds(810, 400, 160, 42);
		btnCancelar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnCancelar.setBackground(new Color(0x2a4674));
		btnCancelar.setForeground(Color.WHITE);
		
		
		pnBarra.add(lblMockupLogo);
		pnPrincipal.add(btnConcluirCadastro);
		pnPrincipal.add(btnCancelar);
		pnPrincipal.add(lblPergunta);
		pnPrincipal.add(tfLocalImage);
		pnPrincipal.add(btnProcurar);
		
	}

	private void definirEventos() {
		btnProcurar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnProcurar.setForeground(Color.WHITE);				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnProcurar.setForeground(new Color(0x2b2760));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				SelecionarFoto foto = new SelecionarFoto();
			    String caminhoFoto = foto.getLocaFoto();
			    lblImagem.setIcon(new ImageIcon(caminhoFoto));
			    tfLocalImage.setText(caminhoFoto);
			}
		});
		btnConcluirCadastro.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnConcluirCadastro.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnConcluirCadastro.setForeground(new Color(0x2b2760));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String foto = tfLocalImage.getText().replace("\\", "\\\\");
				ContaController conta = new ContaController();
				conta.cadastrarConta(nome_perfil, senha, foto);
				UsuarioController user = new UsuarioController();
				user.BuscarID_conta(nome_perfil);
				String nome = usuario.getNome();
				String sexo = usuario.getSexo();
				String dataNasc = usuario.getDatanasc();
				int id_conta = user.getID_CONTA();
				UsuarioController usario = new UsuarioController();
				usario.cadastrarUsuario(nome, sexo, dataNasc, id_conta);
				SessaoController sessao = new SessaoController();
				sessao.cadastrarSessao("L", id_conta);
				
				ContaVO MinhaConta = new ContaVO();
				MinhaConta.setId_conta(id_conta);
				MinhaConta.setNome_perfil(nome_perfil);
				MinhaConta.setSenha(senha);
				MinhaConta.setFoto(foto);
				
				telaSessoes.getContentpane().removeAll();
                JTelaMenu telaMenu = new JTelaMenu(MinhaConta, nome_perfil, telaSessoes);
                telaSessoes.getContentpane().add(telaMenu, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
			}
		});
			btnCancelar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setForeground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				btnCancelar.setForeground(new Color(0x2b2760));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String nome = usuario.getNome();
				String sexo = usuario.getSexo();
				String dataNasc = usuario.getDatanasc();
				telaSessoes.getContentpane().removeAll();
	            JTelaCadastro2 cadastro = new JTelaCadastro2(telaSessoes, nome, sexo, dataNasc);
	            telaSessoes.getContentpane().add(cadastro, BorderLayout.CENTER);
	            telaSessoes.revalidate();
	            telaSessoes.repaint();
			}
		});
	}
}
