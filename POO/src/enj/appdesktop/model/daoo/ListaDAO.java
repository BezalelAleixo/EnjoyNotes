package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.ListaVO;

/**
 * @author AleixoUNI
 * @see Classe de conexão de banco de dados entidade lista
 */
public class ListaDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarListaDAO(ListaVO listas) {
		String salvarListaDAO = "INSERT INTO LISTA (titulo_list, ordem_list, data_criac) VALUES (?,?,now())";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, listas.getTitulo_list());
			PSTM.setString(2, listas.getItens());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void AtualizarListaDAO(ListaVO listas) {
		String comandoSQL = "UPDATE LISTA SET titulo_list = ?, ordem_list = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, listas.getTitulo_list());
			PSTM.setString(2, listas.getItens());
			PSTM.setInt(3, listas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeletarListaDAO(ListaVO listas) {
		String comandoSQL = "DELETE FROM LISTA WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, listas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	private ListaVO lista;
	List<ListaVO> listasPreparadas = new ArrayList<>();
	public List<ListaVO> todasListas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.id, L.titulo_list, L.ordem_list, L.data_criac FROM LISTA as L INNER JOIN CONTA as C WHERE C.nome_perfil = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				lista = new ListaVO();
				int id_lista = RS.getInt("L.id");
				String titulo = RS.getString("L.titulo_list");
				String ordem_list = RS.getString("L.ordem_list");
				String data_de_criacao = RS.getString("L.data_criac");
				lista.setId(id_lista);
				lista.setTitulo_list(titulo);
				lista.setItens(ordem_list);
				lista.setData_de_criacao(data_de_criacao);
				listasPreparadas.add(lista);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return listasPreparadas;	
		}
	public List<ListaVO> PreparadListas(){
		return listasPreparadas;
	}
	public boolean verificarseTemNota(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.id, L.titulo_list, L.ordem_list, L.data_criac FROM LISTA as L INNER JOIN CONTA as C WHERE C.nome_perfil = ?";
		boolean check = false;
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			if (RS.next()) {
				check = true;
			}
		}catch (SQLException e) {
			java.util.logging.Logger.getLogger(LoginDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
		return check;
	}
	public static void main(String[] args) {
		ListaDAO dao = new ListaDAO();
		dao.todasListas("@beza");
		
		for(ListaVO lista : dao.PreparadListas()) {
			System.out.println(lista.getId());
			System.out.println(lista.getTitulo_list());
			System.out.println(lista.getItens());
			System.out.println(lista.getData_de_criacao());
		}
	}
}
