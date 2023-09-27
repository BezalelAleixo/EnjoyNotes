package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

/**
 * @author prfel
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
			PSTM.setString(1, listas.getTitulo());
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
			PSTM.setString(1, listas.getTitulo());
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
}
