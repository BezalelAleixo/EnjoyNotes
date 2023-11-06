package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.SessaoVO;

public class SessaoDAO {
	
	Connection conexao = null;
	PreparedStatement PSTM = null;
	
	public void Cadastrar(SessaoVO logs) {
		conexao = new ConexaoDAO().conexaoBD();
		
		String comando = "INSERT INTO SESSAO (acesso, id_conta_acesso) VALUES (?,?)";
		
		try {
			PSTM = conexao.prepareStatement(comando);
			PSTM.setString(1, logs.getAcesso());
			PSTM.setInt(2, logs.getId_conta());
			PSTM.executeUpdate();
			PSTM.close();
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	public void Atualizar(SessaoVO logs) {
		conexao = new ConexaoDAO().conexaoBD();
		
		String comando = "UPDATE SESSAO SET acesso = ? WHERE id_conta_acesso = ?";
		
		try {
			PSTM = conexao.prepareStatement(comando);
			PSTM.setString(1, logs.getAcesso());
			PSTM.setInt(2, logs.getId_conta());
			PSTM.executeUpdate();
			PSTM.close();
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public boolean verificar(SessaoVO logs) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM SESSAO WHERE id_conta_acesso = ? AND acesso = ?";
		boolean check = false;
		String acessado = "L";

		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setInt(1, logs.getId_conta());
			PSTM.setString(2, acessado);
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
	SessaoVO contaslogadas;
	List<SessaoVO> contaslogadasLISTA = new ArrayList<>();
	ContaVO contas;
	List<ContaVO> contasPreparadas = new ArrayList<>();
	public List<SessaoVO> Logadas() {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT S.id, S.acesso, S.id_conta_acesso, C.id_conta ,C.nome_perfil, C.foto FROM SESSAO as S INNER JOIN CONTA as C ON S.id_conta_acesso = C.id_conta WHERE acesso = ?";
		String sessoes = "L"; 
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, sessoes);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				contaslogadas = new SessaoVO();
				int id = RS.getInt("S.id");
				String acesso = RS.getString("S.acesso");
				int id_conta_acesso = RS.getInt("S.id_conta_acesso");
				contaslogadas.setId(id);
				contaslogadas.setAcesso(acesso);
				contaslogadas.setId_conta(id_conta_acesso);
				contaslogadasLISTA.add(contaslogadas);
				
				contas = new ContaVO();
				String nomeConta = RS.getString("C.nome_perfil");
				String foto = RS.getString("C.foto");
				int id_conta = RS.getInt("C.id_conta");
				contas.setId_conta(id_conta);
				contas.setNome_perfil(nomeConta);
				contas.setFoto(foto);
				contasPreparadas.add(contas);
				
				
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return null;	
		}
	public List<SessaoVO> Sessoes(){
		return contaslogadasLISTA;
		}
	public List<ContaVO> PreparadContas(){
		return contasPreparadas;
	}
	public static void main(String[] args) {
		SessaoDAO dao = new SessaoDAO();
		dao.Logadas();
		for (ContaVO contas : dao.PreparadContas()) {
			System.out.println(contas.getNome_perfil());
			System.out.println(contas.getFoto());
		}
	}
}
