package enj.appdesktop.vieww;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ExemploJFrameComImagem {

    public static void main(String[] args) {
        // Suponha que você tenha recuperado esse caminho do banco de dados
        String caminhoDoBancoDeDados = "D:\\projetoENjoyNotes\\logo01.png";
        // Substituir barras invertidas simples por barras invertidas duplas
        String caminhoCorrigido = caminhoDoBancoDeDados.replace("\\", "\\\\");

        SwingUtilities.invokeLater(() -> exibirJFrameComImagem(caminhoCorrigido));
    }

    private static void exibirJFrameComImagem(String caminhoDaFoto) {
        JFrame frame = new JFrame("Exemplo JFrame com Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Criar um JLabel para exibir a imagem
        JLabel labelImagem = new JLabel();
        carregarImagem(labelImagem, caminhoDaFoto);

        // Adicionar o JLabel ao JFrame
        frame.getContentPane().add(labelImagem, BorderLayout.CENTER);

        // Tornar o JFrame visível
        frame.setVisible(true);
    }

    private static void carregarImagem(JLabel label, String caminhoDaFoto) {
        File arquivo = new File(caminhoDaFoto);

        // Verificar se o arquivo existe
        if (arquivo.exists()) {
            // Criar um ImageIcon e configurá-lo no JLabel
            ImageIcon imagem = new ImageIcon(arquivo.getPath());
            label.setIcon(imagem);
            System.out.println(arquivo.getPath());
        } else {
            // Exibir uma mensagem se o arquivo não existir
            label.setText("Arquivo não encontrado: " + caminhoDaFoto);
        }
    }
}


