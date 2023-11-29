package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.QuadroBO;
import enj.appdesktop.model.vo.QuadroVO;

public class QuadroController {
    private QuadroBO quadroBO = new QuadroBO();

    public void salvarQuadro(String titulo, String descricao, int id_quadro) {
        quadroBO.salvarQuadro(titulo, descricao, id_quadro);
    }

    public void atualizarQuadro(int id, String titulo, String descricao, int id_quadro) {
        quadroBO.atualizarQuadro(id, titulo, descricao, id_quadro);
    }

    public void deletarQuadro(int id) {
        quadroBO.deletarQuadro(id);
    }
    public List<QuadroVO> listarListas(String nome_perfil) {
        // Chame o método correspondente na classe BO para listar as notas
        return quadroBO.listarLISTAS(nome_perfil);
    }
    public List<QuadroVO> ListasPreparadasdaCOnta() {
        return quadroBO.ListasProntas();
    }
}
