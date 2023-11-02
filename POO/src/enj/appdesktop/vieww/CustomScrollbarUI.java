package enj.appdesktop.vieww;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Color;

public class CustomScrollbarUI extends BasicScrollBarUI {
    @Override
    protected void configureScrollBarColors() {
        thumbColor = new Color(0x2a4674); // Substitua a cor pelo que desejar
        trackColor = new Color(0x345389); // Cor do track (fundo)
    }
}