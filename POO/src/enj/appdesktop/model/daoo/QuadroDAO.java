package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class QuadroDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarQuadroDAO(QuadroVO quadros) {
		String salvarListaDAO = "INSERT INTO QUADROS (nome_quad, descricao, data_criac, id_conta) VALUES (?,?,now(),?)";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, quadros.getNome_quad());
			PSTM.setString(2, quadros.getDescricao());
			PSTM.setInt(3, quadros.getId_conta_quadro());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void AtualizarQuadroDAO(QuadroVO quadros) {
		String comandoSQL = "UPDATE QUADROS SET nome_quad = ?, descricao = ?, id_conta = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, quadros.getNome_quad());
			PSTM.setString(2, quadros.getDescricao());
			PSTM.setInt(3, quadros.getId_conta_quadro());
			PSTM.setInt(4, quadros.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeletarQuadroDAO(QuadroVO quadro) {
		String comandoSQL = "DELETE FROM QUADROS WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, quadro.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	private QuadroVO quadro;
	List<QuadroVO> quadrosPreparadas = new ArrayList<>();
	public List<QuadroVO> todasListas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.* FROM QUADROS as L INNER JOIN CONTA as C ON L.id_conta = C.id_conta WHERE C.nome_perfil = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				quadro = new QuadroVO();
				int id_lista = RS.getInt("L.id");
				String titulo = RS.getString("L.nome_quad");
				String data_de_criacao = RS.getString("L.data_criac");
				int id_conta = RS.getInt("L.id_conta");
				quadro.setId(id_lista);
				quadro.setNome_quad(titulo);
				quadro.setDescricao(data_de_criacao);
				quadro.setData_criac(data_de_criacao);
				quadro.setId_conta_quadro(id_conta);
				quadrosPreparadas.add(quadro);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return quadrosPreparadas;	
		}
	public List<QuadroVO> PreparadListas(){
		return quadrosPreparadas;
	}
}
