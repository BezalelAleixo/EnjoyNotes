package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author AleixoUNI
 * @see Classe para conectar a tela de cadastro ao banco de dados
 */
public class ConexaoDAOCadastro {
	 Connection conexao = null;
	 PreparedStatement PSTM;
	
	public void ConexaoDAOCadastro(CadastroVO usuario) {
		String SQL = "INSERT INTO PESSOA (NOME, SEXO, DATANASC) VALUES (?,?,?);";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(SQL);
			PSTM.setString(1, usuario.getNome());
			PSTM.setString(2, usuario.getSexo());
			PSTM.setString(3, usuario.getDatanasc());
			PSTM.execute();
			PSTM.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
