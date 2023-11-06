package enj.appdesktop.vieww;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SobreporJPanelComLayoutEBotaoNoTopo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Sobreposição com Layout e Botão no Topo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setPreferredSize(new Dimension(200, 200));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setPreferredSize(new Dimension(200, 200));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 400));

        JButton button = new JButton("Botão Rosa");
        button.setBounds(150, 150, 100, 50); // Define a posição e o tamanho do botão
        button.setBackground(Color.PINK); // Cor de fundo rosa

        // Use um layout personalizado para o JLayeredPane
        layeredPane.setLayout(new BorderLayout());
        layeredPane.add(panel1, BorderLayout.CENTER);
        layeredPane.add(panel2, BorderLayout.CENTER);
        layeredPane.add(button, BorderLayout.CENTER);

        frame.add(layeredPane);
        frame.setVisible(true);
    }
}