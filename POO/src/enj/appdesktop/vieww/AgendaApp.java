package enj.appdesktop.vieww;

import com.toedter.calendar.JCalendar;

import enj.appdesktop.model.vo.ContaVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AgendaApp extends JPanel {

	private Map<Date, String> events;
	private ContaVO conta;
    private JTelaSessoes telaSessoes;
    
	public AgendaApp(ContaVO conta, JTelaSessoes telaSessoes) {
		this.conta = conta;
        this.telaSessoes = telaSessoes;
		events = new HashMap<>();


		setLayout(null);
		setSize(1366,768);

		ImageIcon mockupImage = new ImageIcon("D:\\AleixoUNI\\BEZALEL\\convert-dpi.com\\10.jpg");
		JLabel mockupLabel = new JLabel(mockupImage);
		mockupLabel.setBounds(0, 0, 1366, 768);

		// Adicionar botão de fechar
		JButton closeButton = new JButton();
		closeButton.setBounds(1300, 10, 50, 50);
		add(closeButton);
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
		add(voltarButton);
		voltarButton.setContentAreaFilled(false);
		voltarButton.setBorderPainted(false);
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_perfil = conta.getNome_perfil();
				telaSessoes.getContentpane().removeAll();
                JTelaMenu telaMenu = new JTelaMenu(conta, nome_perfil, telaSessoes);
                telaSessoes.getContentpane().add(telaMenu, BorderLayout.CENTER);
                telaSessoes.revalidate();
                telaSessoes.repaint();
				
			}
		});

		// Adicionar botão de minimizar
		JButton minimizeButton = new JButton();
		minimizeButton.setBounds(1235, 10, 50, 50);
		add(minimizeButton);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setBorderPainted(false);
		minimizeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		// Calendário
		JCalendar calendar = new JCalendar();
		Dimension calendarDimension = new Dimension(682, 647);
		calendar.setPreferredSize(calendarDimension);
		calendar.setBounds(1, 65, calendarDimension.width, calendarDimension.height);
		add(calendar);

		Font fonte = new Font("Verdana", Font.PLAIN, 12);

		// Lista de eventos
		JTextArea eventList = new JTextArea();
		eventList.setEditable(false);
		eventList.setFont(fonte);

		// Adicionando a JTextArea em um JScrollPane
		JScrollPane scrollPane = new JScrollPane(eventList);
		scrollPane.setBounds(710, 80, 640, 620); // Ajuste o tamanho conforme necessário
		add(scrollPane);

		calendar.setOpaque(false);
		calendar.setBorder(BorderFactory.createEmptyBorder());
		calendar.setForeground(Color.BLACK);

		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setForeground(Color.BLACK);

		// Botão para adicionar evento
		JButton addButton = new JButton("Adicionar Evento");
		addButton.setBounds(1, 713, 1364, 400);
		add(addButton);
		addButton.setContentAreaFilled(false); // Tornar a área do botão transparente
		addButton.setBorderPainted(false); // Remover a borda do botão

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String eventDescription = JOptionPane.showInputDialog("Digite a descrição do evento:");
				if (eventDescription != null && !eventDescription.trim().isEmpty()) {
					Date eventDate = getDateFromCalendar(calendar);
					events.put(eventDate, eventDescription);
					updateEventList(eventList);
				}
			}
		});

		add(mockupLabel);
		
		// Ajusta o tamanho da janela com base na
																// imagem
		
	}

	private Date getDateFromCalendar(JCalendar calendar) {
		Date selectedDate = calendar.getDate();
		return selectedDate;
	}

	private void updateEventList(JTextArea eventList) {
		eventList.setText("");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		for (Map.Entry<Date, String> entry : events.entrySet()) {
			String eventDescription = entry.getValue();
			Date eventDate = entry.getKey();
			eventList.append(dateFormat.format(eventDate) + " - " + eventDescription + "\n");
		}
	}

}
