package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import enj.appdesktop.model.vo.QuadroVO;
import enj.appdesktop.model.vo.VideoVO;

public class VideoDAO {
	Connection conexao = null;
	PreparedStatement PSTM;
	
	public void SalvarVideoDAO(VideoVO video) {
		String salvarListaDAO = "INSERT INTO VIDEOS (nome_video, caminho_video, id_conta) VALUES (?,?,?)";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(salvarListaDAO);
			PSTM.setString(1, video.getNome_video());
			PSTM.setString(2, video.getCaminho_video());
			PSTM.setInt(3, video.getId_conta());
			PSTM.execute();
			PSTM.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void AtualizarVideoDAO(VideoVO video) {
		String comandoSQL = "UPDATE VIDEOS SET nome_video = ?, caminho_video = ?, id_conta = ? WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setString(1, video.getNome_video());
			PSTM.setString(2, video.getCaminho_video());
			PSTM.setInt(3, video.getId_conta());
			PSTM.setInt(4, video.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "Editado com sucesso!");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public void DeletarVideoDAO(VideoVO video) {
		String comandoSQL = "DELETE FROM VIDEOS WHERE id = ?";
		conexao = new ConexaoDAO().conexaoBD();
		try {
			PSTM = conexao.prepareStatement(comandoSQL);
			PSTM.setInt(1, video.getId());
			PSTM.executeUpdate();

			JOptionPane.showMessageDialog(null, "NICE");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	private VideoVO video;
	List<VideoVO> videosPreparadas = new ArrayList<>();
	public List<VideoVO> todasListas(String nome_perfil) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT L.* FROM VIDEOS as L INNER JOIN CONTA as C ON L.id_conta = C.id_conta WHERE C.nome_perfil = ?";
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, nome_perfil);
			RS = PSTM.executeQuery();
			
			while (RS.next()) {
				video = new VideoVO();
				int id = RS.getInt("L.id");
				String nome_video = RS.getString("L.nome_video");
				String caminho_video = RS.getString("L.caminho_video");
				int id_conta = RS.getInt("L.id_conta");
				video.setId(id);
				video.setNome_video(nome_video);
				video.setCaminho_video(caminho_video);
				video.setId_conta(id_conta);
				videosPreparadas.add(video);
			}
		}catch (SQLException e) {
			System.out.println("FALHA"+e);
		}
		return videosPreparadas;	
		}
	public List<VideoVO> PreparadListas(){
		return videosPreparadas;
	}
}
