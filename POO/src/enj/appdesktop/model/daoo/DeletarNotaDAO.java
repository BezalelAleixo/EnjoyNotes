package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.NotasVO;

/**
 * @author prfel 
 * @see Classe de Delete para a entidade NOTAS
 */
public class DeletarNotaDAO {
	Connection conexao = null;
	PreparedStatement PSTM = null;
	//ResultSet RS = null;
	
	public void DeletarNotaDAO(NotasVO notas) {
		String comandoSQL = "DELETE FROM NOTA WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, notas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
