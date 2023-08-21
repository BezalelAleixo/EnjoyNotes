package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

/**
 * @author prfel
 * @see Classe de conexão de banco de dados entidade lista
 */
public class ListaDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarNotaDAO(ListaVO listas) {
		String salvarListaDAO = "INSERT INTO LISTA (TITULO, CONTEUDO) VALUES (?,?)";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, listas.getTitulo());
			PSTM.setString(2, listas.getItens());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
