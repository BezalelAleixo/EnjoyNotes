package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.CartaoBO;
import enj.appdesktop.model.bo.QuadroBO;
import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class CartaoController {
	private CartaoBO cartaoBO = new CartaoBO();

    public void salvarCartao(String titulo, String descricao, int id_list_quadro) {
    	cartaoBO.salvarCartao(titulo, descricao, id_list_quadro);
    }

    public void atualizarCartao(int id, String titulo, String descricao, int id_list_quadro) {
    	cartaoBO.atualizarCartao(id, titulo, descricao, id_list_quadro);
    }

    public void deletarCartao(int id) {
    	cartaoBO.deletarCartao(id);
    }
    public List<CartaoVO> listarListas(String nome_perfil) {
        // Chame o método correspondente na classe BO para listar as notas
        return cartaoBO.listarLISTAS(nome_perfil);
    }
    public List<CartaoVO> ListasPreparadasdaCOnta() {
        return cartaoBO.ListasProntas();
    }
    public int Direita(int id_list) {
    	return cartaoBO.Direita(id_list);
    }
    public int Esquerda(int id_list) {
    	return cartaoBO.Esquerda(id_list);
    }
}
