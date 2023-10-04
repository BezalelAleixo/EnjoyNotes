package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enj.appdesktop.model.vo.CadastroVO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;
import enj.appdesktop.vieww.JTelaMenu;

public class ConsultaDAO {
	static NotasVO dado = new NotasVO();
	static ListaVO doc = new ListaVO();
	static List<NotasVO> pegar;
	static CadastroVO dd;
	static CadastroVO pp;
	public void consultar(String titulo) {
	Connection conexao = new ConexaoDAO().conexaoBD();
	PreparedStatement PSTM = null;
	ResultSet RS = null;
	String select = "SELECT * FROM NOTA WHERE titulo LIKE ?";
	
	
	try {
		PSTM = conexao.prepareStatement(select);
		PSTM.setString(1, titulo+"%");
		RS = PSTM.executeQuery();
		
		while (RS.next()) {
			
			String titulo1 = RS.getString("titulo");	
			String nota = RS.getString("conteudo");
			dado.setTitulo(titulo1);
			dado.setContent(nota);	
			
			//pegar = new ArrayList<NotasVO>();
			//pegar.add(dado);
			//System.out.println(pegar);
		}
	}catch (SQLException e) {
		System.out.println("FALHA"+e);
 	}
	}
/*	public static List<NotasVO> getVos(String titulo){
		
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM NOTA WHERE titulo LIKE ?";
		
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, titulo+"%");
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				dado = new NotasVO();
				String titulo1 = RS.getString("titulo");	
				String nota = RS.getString("conteudo");
				dado.setTitulo(titulo1);
				dado.setContent(nota);	
				
				pegar = new ArrayList<NotasVO>();
				pegar.add(dado);
				System.out.println(pegar);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
	 	}
		return pegar;
		
	}*/
	
	public static String gettitulin() {
		String notin = dado.getTitulo();
		return notin;

	}
	public static String getcontin() {
		String contin = dado.getContent();
		return contin;

	}
	
	
	
	public void consultarLIS(String titulo) {
	Connection conexao = new ConexaoDAO().conexaoBD();
	PreparedStatement PSTM = null;
	ResultSet RS = null;
	String select = "SELECT * FROM LISTA WHERE titulo_list LIKE ?";
	
	
	try {
		PSTM = conexao.prepareStatement(select);
		PSTM.setString(1, titulo+"%");
		RS = PSTM.executeQuery();
		
		while (RS.next()) {
			String titulo1 = RS.getString("titulo_list");
			String itens = RS.getString("ordem_list");
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
	
	public void mandar(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM CONTA WHERE nome_perfil = ?";
		
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				
				String usuario = RS.getString("nome_perfil");	
				String senha = RS.getString("senha");
				int id = RS.getInt("id_conta");
				dd = new CadastroVO();
				dd.setId(id);
				dd.setNomeUsuario(usuario);
				dd.setSenha(senha);
				dd.setNome("bezalel");
				dd.setSexo("masculino");
				dd.setDatanasc("2006/07/28");
			
				
				//pegar = new ArrayList<NotasVO>();
				//pegar.add(dado);
				//System.out.println(pegar);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
	 	}
		}
	public static int getID() {
		int notin = dd.getId();
		return notin;

	}
	public static String getUsuario() {
		String notinho = dd.getNomeUsuario();
		return notinho;

	}
	public static String getSenha() {
		String notin = dd.getSenha();
		return notin;

	}
	public void mandarUser(String nome_pessoal) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM USUARIO WHERE nome_pessoal = ?";
		
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_pessoal);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				
				String nome = RS.getString("nome_pessoal");	
				String sexo = RS.getString("sexo");
				String data_nasc = RS.getString("data_nasc");
				int id = 1;
				pp = new CadastroVO();
				pp.setId(id);
				pp.setNomeUsuario("comoé");
				pp.setSenha("aiai");
				pp.setNome(nome);
				pp.setSexo(sexo);
				pp.setDatanasc(data_nasc);
			
				
				//pegar = new ArrayList<NotasVO>();
				//pegar.add(dado);
				//System.out.println(pegar);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
	 	}
		}
	public static String getNome() {
		String notin = dd.getNome();
		return notin;

	}
	public static String getSexo() {
		String notinho = dd.getSexo();
		return notinho;

	}
	public static String getData() {
		String notin = dd.getDatanasc();
		return notin;

	}
	public static void main(String[] args) {
		ConsultaDAO pesquisar = new ConsultaDAO();
				pesquisar.mandar("@beza");
		System.out.println(ConsultaDAO.getSenha());
		
	
	}
}