package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

import enj.appdesktop.model.vo.UsuarioVO;
import enj.appdesktop.vieww.JTelaMenu;

public class ConsultaDAO {
	
	static ContaVO dd;
	static UsuarioVO pp;
	
	NotasVO dado;
	ListaVO doc;
	List<NotasVO> notaslist = new ArrayList<>();
	List<ListaVO> listasList = new ArrayList<>();

	NotasVO Asnotas;
	ListaVO Aslistas;
	List<NotasVO> todasnotas = new ArrayList<>();
	List<ListaVO> todaslistas = new ArrayList<>();
	
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
			dado = new NotasVO();
			
			String titulo1 = RS.getString("titulo");	
			String nota = RS.getString("conteudo");
			dado.setTitulo(titulo1);
			dado.setContent(nota);	
			System.out.println(dado);
			notaslist.add(dado);
			
		}
	}catch (SQLException e) {
		System.out.println("FALHA"+e);
 	}
	}

	public List<NotasVO> getNotasList() {
	    return notaslist; // Retorna a lista de notas
	}
	
	public String gettitulin() {
		String notin = dado.getTitulo();
		return notin;

	}
	public String getcontin() {
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
			doc = new ListaVO();
			String titulo1 = RS.getString("titulo_list");
			String itens = RS.getString("ordem_list");
			doc.setTitulo_list(titulo1);
			doc.setItens(itens);			
			listasList.add(doc);
		}
	}catch (SQLException e) {
		System.out.println("FALHA"+e);
	}	
	}
	
	public List<ListaVO> getListResult(){
	return listasList;
	}
	
	public String gettitulista() {
		String notin = doc.getTitulo_list();
		return notin;

	}
	public String getintezin() {
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
				dd = new ContaVO();

				dd.setNome_perfil(usuario);
				dd.setSenha(senha);
				
			
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
	 	}
		}

	public static String getUsuario() {
		String notinho = dd.getNome_perfil();
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
				pp = new UsuarioVO();
				pp.setId(id);
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
		String notin = pp.getNome();
		return notin;

	}
	public static String getSexo() {
		String notinho = pp.getSexo();
		return notinho;

	}
	public static String getData() {
		String notin = pp.getDatanasc();
		return notin;

	}

	public boolean verificarPesquisa(String letra) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM NOTA WHERE titulo LIKE ?";
		boolean check = false;

		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, letra + "%");
			RS = PSTM.executeQuery();

			if (RS.next()) {
				check = true;
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(ConsultaDAO.class.getName()).log(java.util.logging.Level.SEVERE, null,
					e);
		}
		return check;
	}

	public boolean verificarPesquisaLIS(String letra) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM LISTA WHERE titulo_list LIKE ?";
		boolean check = false;

		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, letra + "%");
			RS = PSTM.executeQuery();

			if (RS.next()) {
				check = true;
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(ConsultaDAO.class.getName()).log(java.util.logging.Level.SEVERE, null,
					e);
		}
		return check;
	}
	public void filtro1() {
		Connection conexao = new ConexaoDAO().conexaoBD(); 
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String filtrar1 = "select * from nota order by titulo asc";
		try {
			PSTM = conexao.prepareStatement(filtrar1);
			RS = PSTM.executeQuery();
			while(RS.next()) {
				Asnotas = new NotasVO();
				

				String titulo1 = RS.getString("titulo");	
				String nota = RS.getString("conteudo");
				Asnotas.setTitulo(titulo1);
				Asnotas.setContent(nota);	
				todasnotas.add(Asnotas);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public List<NotasVO> getTodasNotas1() {
	    return todasnotas; // Retorna a lista de notas
	}
	public void filtro2() {
		Connection conexao = new ConexaoDAO().conexaoBD(); 
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String filtrar2 = "select * from nota order by titulo desc";
		try {
			PSTM = conexao.prepareStatement(filtrar2);
			RS = PSTM.executeQuery();
			while(RS.next()) {
				Asnotas = new NotasVO();
				

				String titulo1 = RS.getString("titulo");	
				String nota = RS.getString("conteudo");
				Asnotas.setTitulo(titulo1);
				Asnotas.setContent(nota);	
				todasnotas.add(Asnotas);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public List<NotasVO> getTodasNotas2() {
	    return todasnotas; // Retorna a lista de notas
	}
	
	public void filtro3() {
		Connection conexao = new ConexaoDAO().conexaoBD(); 
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String filtrar3 = "select * from nota order by data_criac desc;";
		try {
			PSTM = conexao.prepareStatement(filtrar3);
			RS = PSTM.executeQuery();
			while(RS.next()) {
				Asnotas = new NotasVO();
				

				String titulo1 = RS.getString("titulo");	
				String nota = RS.getString("conteudo");
				Asnotas.setTitulo(titulo1);
				Asnotas.setContent(nota);	
				todasnotas.add(Asnotas);
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public List<NotasVO> getTodasNotas3() {
	    return todasnotas; // Retorna a lista de notas
	}
	

	public static void main(String[] args) {
		ConsultaDAO consulta = new ConsultaDAO();
		/*consulta.consultar("A"); // Realize a consulta
		List<NotasVO> notasList = consulta.getNotasList(); // Obtenha a lista de notas

		// Agora, você pode trabalhar com a lista "notasList"
		for (NotasVO nota : notasList) {
		    System.out.println("Titulo: " + nota.getTitulo());
		    System.out.println("Conteudo: " + nota.getContent());
		}
		if(consulta.verificarPesquisaLIS("b")) {
		consulta.consultarLIS("b");
		List<ListaVO> ListaList = consulta.getListResult();
		
		for (ListaVO lista : ListaList) {
			 System.out.println("Titulo: " + lista.getTitulo());
			    System.out.println("Conteudo: " + lista.getItens());
		}
	} else {
		System.out.println("Nd encontrado");
	}*/
		consulta.filtro2();
		System.out.println(consulta.getTodasNotas2());
	}
	
}