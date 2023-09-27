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
	
	public void ConexaoDAOCadastro(CadastroVO user) {
		String SQL = "INSERT INTO USUARIO (nome_pessoal, sexo, data_nasc) VALUES (?,?,?);";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(SQL);
			PSTM.setString(1, user.getNome());
			PSTM.setString(2, user.getSexo());
			PSTM.setString(3, user.getDatanasc());
			PSTM.execute();
			PSTM.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void ConexaoDAOCadastro2(CadastroVO user) {
		String SQL = "INSERT INTO CONTA (nome_perfil, senha) VALUES (?,?);";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(SQL);
			PSTM.setString(1, user.getNomeUsuario());
			PSTM.setString(2, user.getSenha());
			PSTM.execute();
			PSTM.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
