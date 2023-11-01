package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;

public class JTelaSessoesContas extends JPanel{
	private JPanel pnBlocoConta;
	private JLabel lblNomeConta;
	private JButton btnMockup;
	private ContaVO conta;
	
	public JTelaSessoesContas(ContaVO conta) {
		this.conta = conta;
		inicializarComponentes();
		posicionandoComponentes();
		definirEventos();
		
	}

	private void inicializarComponentes() {
		setSize(193,263);
		setLayout(new BorderLayout());
		setBackground(new Color(0x84CAED));
		
	}

	private void posicionandoComponentes() {
		
		btnMockup = new JButton(new ImageIcon(conta.getFoto()));
		btnMockup.setPreferredSize(new Dimension(193,193));
		btnMockup.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		Font fonte = new Font("Garet", Font.PLAIN, 24);
		lblNomeConta = new JLabel(conta.getNome_perfil());
		lblNomeConta.setFont(fonte);
		lblNomeConta.setHorizontalAlignment(SwingConstants.CENTER);

		
		add(btnMockup, BorderLayout.NORTH);
		add(lblNomeConta, BorderLayout.CENTER);
		
	}

	private void definirEventos() {
		btnMockup.addMouseListener(new MouseListener() {
			
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
			btnMockup.setBorder(new EmptyBorder(0, 0, 0, 0));
			lblNomeConta.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			btnMockup.setBorder(new LineBorder(Color.WHITE, 2));
			lblNomeConta.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
	}

	public void setNomeConta(String acesso) {
		lblNomeConta.setText(acesso);
	}
}
