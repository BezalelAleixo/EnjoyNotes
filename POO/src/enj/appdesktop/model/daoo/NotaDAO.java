package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.NotasVO;

public class NotaDAO {
	
	public void SalvarNotaDAO(NotasVO notas) {
		Connection conexao = null;
		PreparedStatement PSTM;
		String comandoSQL = "INSERT INTO NOTA (titulo, conteudo, data_criac) VALUES (?,?, now())";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, notas.getTitulo());
			PSTM.setString(2, notas.getContent());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void AtualizarNotaDAO(NotasVO notas) {
		Connection conexao = null;
		PreparedStatement PSTM = null;
		//ResultSet RS = null;
		String comandoSQL = "UPDATE NOTA SET titulo = ?, conteudo = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, notas.getTitulo());
			PSTM.setString(2, notas.getContent());
			PSTM.setInt(3, notas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void DeletarNotaDAO(NotasVO notas) {
		Connection conexao = null;
		PreparedStatement PSTM = null;
		//ResultSet RS = null;
		String comandoSQL = "DELETE FROM NOTA WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, notas.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
