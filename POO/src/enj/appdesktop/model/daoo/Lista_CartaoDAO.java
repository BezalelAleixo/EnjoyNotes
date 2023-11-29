package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.Lista_CartaoVO;



/**
 * @author AleixoUNI
 * @see Classe de conexão de banco de dados entidade lista
 */
public class Lista_CartaoDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarListaDAO(Lista_CartaoVO listas) {
		String salvarListaDAO = "INSERT INTO LISTA_DE_CARTOES (titulo_list, data_criac, id_quadro) VALUES (?,now(),?)";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, listas.getTitulo_list());
			PSTM.setInt(2, listas.getId_quadro());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void AtualizarListaDAO(Lista_CartaoVO listas) {
		String comandoSQL = "UPDATE LISTA_DE_CARTOES SET titulo_list = ?, id_quadro = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, listas.getTitulo_list());
			PSTM.setInt(2, listas.getId_quadro());
			PSTM.setInt(3, listas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeletarListaDAO(Lista_CartaoVO listas) {
		String comandoSQL = "DELETE FROM LISTA_DE_CARTOES WHERE id = ?";
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
	private Lista_CartaoVO lista;
	List<Lista_CartaoVO> listasPreparadas = new ArrayList<>();
	public List<Lista_CartaoVO> todasListas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.* FROM LISTA_DE_CARTOES as L INNER JOIN QUADROS as Q ON L.id_quadro = Q.id WHERE Q.nome_quad = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				lista = new Lista_CartaoVO();
				int id_lista = RS.getInt("L.id");
				String titulo = RS.getString("L.titulo_list");
				String data_de_criacao = RS.getString("L.data_criac");
				int id_list_quadro = RS.getInt("L.id_quadro");
				lista.setId(id_lista);
				lista.setTitulo_list(titulo);
				lista.setData_de_criacao(data_de_criacao);
				lista.setId_quadro(id_list_quadro);
				listasPreparadas.add(lista);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return listasPreparadas;	
		}
	public List<Lista_CartaoVO> PreparadListas(){
		return listasPreparadas;
	}
	public static void main(String[] args) {
		
	}
}
