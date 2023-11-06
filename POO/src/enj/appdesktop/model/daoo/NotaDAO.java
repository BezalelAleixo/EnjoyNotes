package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;
import enj.appdesktop.model.vo.SessaoVO;

public class NotaDAO {
	
	private NotasVO notas;
	List<NotasVO> notasPreparadas = new ArrayList<>();
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
	public List<NotasVO> todasNotas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT N.id, N.titulo, N.conteudo, N.data_criac FROM NOTA as N INNER JOIN CONTA as C WHERE C.nome_perfil = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				notas = new NotasVO();
				int id = RS.getInt("N.id");
				String titulo = RS.getString("N.titulo");
				String conteudo = RS.getString("N.conteudo");
				String data_criacao = RS.getString("n.data_criac");
				notas.setId(id);
				notas.setTitulo(titulo);
				notas.setContent(conteudo);
				notas.setData_criacao(data_criacao);
				notasPreparadas.add(notas);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return notasPreparadas;	
		}
	public List<NotasVO> PreparadNotas(){
		return notasPreparadas;
	}
	public boolean verificarseTemNota(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT N.id, N.titulo, N.conteudo, N.data_criac FROM NOTA as N INNER JOIN CONTA as C WHERE C.nome_perfil = ?";
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
	}

