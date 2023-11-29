package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.Lista_CartaoBO;
import enj.appdesktop.model.vo.Lista_CartaoVO;

public class Lista_Cartao_Controller {
    private Lista_CartaoBO listaBO = new Lista_CartaoBO();

    public void salvarLista(String titulo, int id_quadro) {
        listaBO.salvarLista(titulo, id_quadro);
    }

    public void atualizarLista(int id, String titulo, int id_quadro) {
        listaBO.atualizarLista(id, titulo, id_quadro);
    }

    public void deletarLista(int id) {
        listaBO.deletarLista(id);
    }
    public List<Lista_CartaoVO> listarListas(String nome_perfil) {
        // Chame o método correspondente na classe BO para listar as notas
        return listaBO.listarLISTAS(nome_perfil);
    }
    public List<Lista_CartaoVO> ListasPreparadasdaCOnta() {
        return listaBO.ListasProntas();
    }
   
    // Outros métodos do controller relacionados a listas podem ser adicionados aqui.
}