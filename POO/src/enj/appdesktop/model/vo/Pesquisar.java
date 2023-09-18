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
    NotasVO assunto = new NotasVO();
    ListaVO contemais = new ListaVO();
    public Pesquisar(String letra) {
        this.letra = letra;
    }
    public Pesquisar() {
      
    }

    public void pesquisarNotasPorNome() {
        
        
            	ConsultaDAO not = new  ConsultaDAO();
            	not.consultar(letra);
            	
 
            	assunto.setTitulo(not.gettitulin());
            	assunto.setContent(not.getcontin());
               
            }  
    public String resultadoNT1() {
    	String mds = assunto.getTitulo();
    	return mds;
    }
    public String resultadoNT2() {
    	String mds = assunto.getContent();
    	return mds;
    }
    

    public void pesquisarListasPorNome() {
        
        

                ConsultaDAO lit = new ConsultaDAO();
                lit.consultarLIS(letra);
                
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
		String select = "SELECT * FROM NOTA WHERE TITULO LIKE ?";
		boolean check = false;
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, letra+"%");
			RS = PSTM.executeQuery();
			
			if (RS.next()) {
				check = true;
			}
		}catch (SQLException e) {
			java.util.logging.Logger.getLogger(ConsultaDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
		return check;
	}
	public boolean verificarPesquisaLIS() {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM LISTA WHERE TITULO LIKE ?";
		boolean check = false;
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, letra+"%");
			RS = PSTM.executeQuery();
			
			if (RS.next()) {
				check = true;
			}
		}catch (SQLException e) {
			java.util.logging.Logger.getLogger(ConsultaDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
		return check;
	}
    public static void main(String[] args) {
		Pesquisar nome = new Pesquisar("a");
		if (nome.verificarPesquisaLIS()) {
			
			nome.pesquisarListasPorNome();
			System.out.println(nome.resultadoLT1());
		}
	}
}
