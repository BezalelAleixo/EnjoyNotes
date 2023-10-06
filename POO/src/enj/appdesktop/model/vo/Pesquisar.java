package enj.appdesktop.model.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enj.appdesktop.model.daoo.ConexaoDAO;
import enj.appdesktop.model.daoo.ConsultaDAO;
import enj.appdesktop.vieww.JTelaListas;

public class Pesquisar {
	private String letra;
	static NotasVO dado;
	
	static NotasVO assunto;
	static ListaVO contemais; 
	ConsultaDAO not = new ConsultaDAO();
	 private List<NotasVO> pegar = new ArrayList<>();

	

	public Pesquisar(String letra) {
		this.letra = letra;
	}

	public Pesquisar() {

	}

	 public void pesquisarNotasPorNomes() {
		 ConsultaDAO not = new ConsultaDAO();
			not.consultar(letra);
			assunto = new NotasVO();
			assunto.setTitulo(not.gettitulista());
			assunto.setContent(not.getintezin());
	    }

	public String resultadoNT1() {
		String mds =  assunto.getTitulo();
		return mds;
	}

	public String resultadoNT2() {
		String mds = assunto.getContent();
		return mds;
	}

    public List<NotasVO> getresultados() {
        return pegar;
    }

	
	
	
	public void pesquisarListasPorNome() {
		ConsultaDAO lit = new ConsultaDAO();
		lit.consultarLIS(letra);
		contemais = new ListaVO(); 
		contemais.setTitulo(lit.gettitulista());
		contemais.setItens(lit.getintezin());

	}

	public String resultadoLT1() {
		String mds = contemais.getTitulo();
		return mds;
	}

	public String resultadoLT2() {
		String mds = contemais.getItens();
		return mds;
	}

	public boolean verificarPesquisa() {
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

	public boolean verificarPesquisaLIS() {
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
	
	

	public static void main(String[] args) {
		Pesquisar nome = new Pesquisar("S");
		if (nome.verificarPesquisa()) {

			nome.pesquisarNotasPorNomes();
			System.out.println(nome.resultadoNT1());
		}
	}
}
