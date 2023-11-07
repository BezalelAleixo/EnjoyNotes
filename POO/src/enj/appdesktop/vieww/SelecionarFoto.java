package enj.appdesktop.vieww;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelecionarFoto {
	java.io.File arquivoSelecionado;
    public SelecionarFoto() {
        
        JFrame frame = new JFrame("Selecione uma foto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        JFileChooser fileChooser = new JFileChooser();

       
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
           
        	arquivoSelecionado = fileChooser.getSelectedFile();

        }
        
        frame.pack();
        frame.dispose();
}
    public String getLocaFoto() {
    	String foto = arquivoSelecionado.getAbsolutePath();
		return foto;
    }
	public static void main(String[] args) {
		SelecionarFoto foto = new SelecionarFoto();
		System.out.println(foto.getLocaFoto());
    }
}