package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.QuadroDAO;
import enj.appdesktop.model.daoo.VideoDAO;
import enj.appdesktop.model.vo.QuadroVO;
import enj.appdesktop.model.vo.VideoVO;

public class VideoBO {
	private VideoDAO videoDAO = new VideoDAO();

    public void salvarVideo(String nome_video, String caminho_video, int id_conta) {
        VideoVO video = new VideoVO(nome_video, caminho_video, id_conta); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

        try {
        	videoDAO.SalvarVideoDAO(video);
        } catch (Exception e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarVideo(int id, String nome_video, String caminho_video, int id_conta) {
    	VideoVO video = new VideoVO(id, nome_video, caminho_video, id_conta);

        try {
        	videoDAO.AtualizarVideoDAO(video);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarVideo(int id) {
    	VideoVO video = new VideoVO(id);

        try {
        	videoDAO.DeletarVideoDAO(video);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }
    public List<VideoVO> listarLISTAS(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<VideoVO> listas = videoDAO.todasListas(nome_perfil);
        return listas;
    }
    public List<VideoVO> ListasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return videoDAO.PreparadListas();
    }
}
