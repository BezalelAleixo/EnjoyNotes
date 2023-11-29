package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class CartaoDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarCartaoDAO(CartaoVO cartao) {
		String salvarListaDAO = "INSERT INTO CARTOES (titulo_cart, descricao_cart, data_criac, id_list_cartao) VALUES (?,?,now(),?)";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, cartao.getTitulo());
			PSTM.setString(2, cartao.getDescricao());
			PSTM.setInt(3, cartao.getId_list_cartao());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void AtualizarCartaoDAO(CartaoVO cartao) {
		String comandoSQL = "UPDATE CARTOES SET titulo_cart = ?, descricao_cart = ?, id_list_cartao = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, cartao.getTitulo());
			PSTM.setString(2, cartao.getDescricao());
			PSTM.setInt(3, cartao.getId_list_cartao());
			PSTM.setInt(4, cartao.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeletarCartaoDAO(CartaoVO cartao) {
		String comandoSQL = "DELETE FROM CARTOES WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, cartao.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	private CartaoVO cartao;
	List<CartaoVO> cartaoPreparadas = new ArrayList<>();
	public List<CartaoVO> todasListas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.* FROM CARTOES as L INNER JOIN LISTA_DE_CARTOES as LC ON L.id_list_cartao = LC.id WHERE LC.titulo_list = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				cartao = new CartaoVO();
				int id_cartao = RS.getInt("L.id");
				String titulo = RS.getString("L.titulo_cart");
				String descricao = RS.getString("L.descricao_cart");
				String data_de_criacao = RS.getString("L.data_criac");
				int id_list_cartao = RS.getInt("L.id_list_cartao");
				cartao.setId(id_cartao);
				cartao.setTitulo(titulo);
				cartao.setDescricao(data_de_criacao);
				cartao.setData_criac(data_de_criacao);
				cartao.setId_list_cartao(id_list_cartao);
				cartaoPreparadas.add(cartao);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return cartaoPreparadas;	
		}
	public List<CartaoVO> PreparadListas(){
		return cartaoPreparadas;
	}
	int id_list_cartao;
	public int Direita(CartaoVO cartao) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT l.* FROM LISTA_DE_CARTOES as l inner join Quadros as q on l.id=q.id WHERE l.id > ? ORDER BY l.id ASC LIMIT 1";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setInt(1, cartao.getId());
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				cartao = new CartaoVO();
				 id_list_cartao = RS.getInt("L.id");
			
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}	
		return id_list_cartao;
		}
	public int Esquerda(CartaoVO cartao) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT l.* FROM LISTA_DE_CARTOES as l inner join Quadros as q on l.id=q.id WHERE l.id < ? ORDER BY l.id DESC LIMIT 1";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setInt(1, cartao.getId());
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				cartao = new CartaoVO();
				 id_list_cartao = RS.getInt("L.id");
			
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}	
		return id_list_cartao;
		}
	}

