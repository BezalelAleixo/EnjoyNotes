package enj.appdesktop.vieww;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomFontExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Font Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel(new FlowLayout());

            try {
              
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("D:\\AleixoUNI\\BEZALEL\\Fontes\\font-awesome-4.7.0\\font-awesome-4.7.0\\fonts\\FontAwesome.otf")).deriveFont(25f);

                JLabel customFontLabel = new JLabel("\uf03e"); // Código Unicode para o símbolo de coração
                customFontLabel.setFont(customFont);
                customFontLabel.setForeground(Color.BLACK);

                panel.add(customFontLabel);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}

