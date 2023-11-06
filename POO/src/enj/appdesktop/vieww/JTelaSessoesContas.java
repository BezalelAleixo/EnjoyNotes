package enj.appdesktop.vieww;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

// ... (outros imports)

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import enj.appdesktop.model.vo.ContaVO;

public class JTelaSessoesContas extends JPanel {
    private JLabel lblNomeConta;
    private JButton btnMockup;
    private ContaVO conta;
    private JTelaSessoes telaSessoes; // Deixe essa declaração

    public JTelaSessoesContas(ContaVO conta, JTelaSessoes telaSessoes) {
        this.conta = conta;
        this.telaSessoes = telaSessoes;
        inicializarComponentes();
        posicionandoComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setSize(193, 263);
        setLayout(new BorderLayout());
        setBackground(new Color(0x84CAED));
    }

    private void posicionandoComponentes() {
        btnMockup = new JButton(new ImageIcon(conta.getFoto()));
        btnMockup.setPreferredSize(new Dimension(193, 193));
        btnMockup.setBorder(new EmptyBorder(0, 0, 0, 0));
        btnMockup.setBackground(new Color(0x2a4674));

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
                // TODO: código para mouseReleased
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO: código para mousePressed
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
            	String nome_perfil = conta.getNome_perfil();
                telaSessoes.getContentpane().removeAll();
                JTelaMenu telaMenu = new JTelaMenu(nome_perfil, telaSessoes);
                telaSessoes.getContentpane().add(telaMenu, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
            }
        });
    }

    // Restante do código...
}