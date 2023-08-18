package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author prfel
 * @see Classe de conexao para a tabela usuario 
 */
public class ConexaoDAOCadastro02 {
	 Connection conexao = null;
	 PreparedStatement PSTM;
	
	public void ConexaoDAOCadastro(CadastroVO usuario) {
		String SQL = "INSERT INTO USUARIO (NOMEUSUARIO, SENHA) VALUES (?,?);";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(SQL);
			PSTM.setString(1, usuario.getNomeUsuario());
			PSTM.setString(2, usuario.getSenha());
			PSTM.execute();
			PSTM.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
