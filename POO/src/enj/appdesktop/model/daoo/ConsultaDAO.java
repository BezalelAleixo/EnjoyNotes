package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

public class ConsultaDAO {
	static NotasVO dado;
	public void consultar(String titulo) {
	Connection conexao = new ConexaoDAO().conexaoBD();
	PreparedStatement PSTM = null;
	ResultSet RS = null;
	String select = "SELECT * FROM NOTA WHERE TITULO LIKE ?";
	
	
	try {
		PSTM = conexao.prepareStatement(select);
		PSTM.setString(1, titulo+"%");
		RS = PSTM.executeQuery();
		
		while (RS.next()) {
			dado = new NotasVO();
			String titulo1 = RS.getString("TITULO");	
			String nota = RS.getString("CONTEUDO");
			dado.setTitulo(titulo1);
			dado.setContent(nota);	
			//System.out.println(titulo1+"\n"+nota);
		}
	}catch (SQLException e) {
		System.out.println("FALHA"+e);
	}

		
	}
	public static String gettitulin() {
		String notin = dado.getTitulo();
		return notin;

	}
	public static String getcontin() {
		String contin = dado.getContent();
		return contin;

	}
	
	static ListaVO doc;
	
	public void consultarLIS(String titulo) {
	Connection conexao = new ConexaoDAO().conexaoBD();
	PreparedStatement PSTM = null;
	ResultSet RS = null;
	String select = "SELECT * FROM LISTA WHERE TITULO LIKE ?";
	
	
	try {
		PSTM = conexao.prepareStatement(select);
		PSTM.setString(1, titulo+"%");
		RS = PSTM.executeQuery();
		
		while (RS.next()) {
			doc = new ListaVO();
			String titulo1 = RS.getString("TITULO");
			String itens = RS.getString("LISTA_ENUMERADA");
			doc.setTitulo(titulo1);
			doc.setItens(itens);			
		}
	}catch (SQLException e) {
		System.out.println("FALHA"+e);
	}

		
	}
	public static String gettitulista() {
		String notin = doc.getTitulo();
		return notin;

	}
	public static String getintezin() {
		String contin = doc.getItens();
		return contin;

	}
	

	
	/*public static void main(String[] args) {
		ConsultaDAO pesquisar = new ConsultaDAO();
		pesquisar.consultar("Amigo");
		System.out.println(pesquisar.getcontin());
	
	}*/
}