package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import enj.appdesktop.model.vo.NotasVO;

/**
 * @author prfel
 * @see classe para conexão do banco de dados para entidade NOTAS 
 */
public class SalvarNotaDAO {
		Connection conexao = null;
		PreparedStatement PSTM;
		
		public void SalvarNotaDAO(NotasVO notas) {
			String comandoSQL = "INSERT INTO NOTA (TITULO, CONTEUDO) VALUES (?,?)";
			conexao = new ConexaoDAO().conexaoBD();
			try {
				PSTM = conexao.prepareStatement(comandoSQL);
				PSTM.setString(1, notas.getTitulo());
				PSTM.setString(2, notas.getContent());
				PSTM.execute();
				PSTM.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
}
