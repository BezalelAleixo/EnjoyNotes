package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.QuadroBO;
import enj.appdesktop.model.bo.VideoBO;
import enj.appdesktop.model.vo.QuadroVO;
import enj.appdesktop.model.vo.VideoVO;

public class VideoController {
	 private VideoBO videoBO = new VideoBO();

	    public void salvarVideo(String nome_video, String caminho_video, int id_conta) {
	    	videoBO.salvarVideo(nome_video, caminho_video, id_conta);
	    }

	    public void atualizarVideo(int id, String nome_video, String caminho_video, int id_conta) {
	    	videoBO.atualizarVideo(id, nome_video, caminho_video, id_conta);
	    }

	    public void deletarVideo(int id) {
	    	videoBO.deletarVideo(id);
	    }
	    public List<VideoVO> listarListas(String nome_perfil) {
	        // Chame o método correspondente na classe BO para listar as notas
	        return videoBO.listarLISTAS(nome_perfil);
	    }
	    public List<VideoVO> ListasPreparadasdaCOnta() {
	        return videoBO.ListasProntas();
	    }
}
