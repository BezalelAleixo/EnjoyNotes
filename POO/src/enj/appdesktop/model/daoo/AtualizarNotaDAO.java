package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.NotasVO;

/**
 * @author prfel
 * @see Classe de atualizar dados para a entidade NOTA 
 */
public class AtualizarNotaDAO {
	Connection conexao = null;
	PreparedStatement PSTM = null;
	//ResultSet RS = null;
	
	public void AtualizarNotaDAO(NotasVO notas) {
		String comandoSQL = "UPDATE NOTA SET titulo = ?, conteudo = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, notas.getTitulo());
			PSTM.setString(2, notas.getContent());
			PSTM.setInt(3, notas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
