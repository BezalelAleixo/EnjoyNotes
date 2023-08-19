package enj.appdesktop.vieww;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class testPrincipal extends JFrame{
	private Container contentpane;
	private JLabel lblPrincipal;
	public testPrincipal() {
		contentpane = getContentPane();
		setSize(1000,800);
		setLocationRelativeTo(contentpane);
		setLayout(null);
		
		lblPrincipal = new JLabel("Principal");
		
		lblPrincipal.setBounds(500,400,90,20);
		add(lblPrincipal);
	}
}
