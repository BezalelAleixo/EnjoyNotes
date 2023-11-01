package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;


import enj.appdesktop.model.vo.ContaVO;

/**
 * @author prfel
 * @see Classe de conexao para a tabela usuario 
 */
public class ContaDAO {
	 Connection conexao = null;
	 PreparedStatement PSTM;
	
	 public void cadastrar(ContaVO user) {
			String SQL = "INSERT INTO CONTA (nome_perfil, senha, foto) VALUES (?,?,?);";
			conexao = new ConexaoDAO().conexaoBD();
			try {
				PSTM = conexao.prepareStatement(SQL);
				PSTM.setString(1, user.getNome_perfil());
				PSTM.setString(2, user.getSenha());
				PSTM.setString(3, user.getFoto());
				PSTM.execute();
				PSTM.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	
}
