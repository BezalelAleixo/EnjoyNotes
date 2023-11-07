package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.ListaBO;
import enj.appdesktop.model.vo.ListaVO;

public class ListaController {
    private ListaBO listaBO = new ListaBO();

    public void salvarLista(String titulo, String itens) {
        listaBO.salvarLista(titulo, itens);
    }

    public void atualizarLista(int id, String titulo, String itens) {
        listaBO.atualizarLista(id, titulo, itens);
    }

    public void deletarLista(int id) {
        listaBO.deletarLista(id);
    }
    public List<ListaVO> listarListas(String nome_perfil) {
        // Chame o método correspondente na classe BO para listar as notas
        return listaBO.listarLISTAS(nome_perfil);
    }
    public List<ListaVO> ListasPreparadasdaCOnta() {
        return listaBO.ListasProntas();
    }
    public boolean verificarSeTemLista(String nome_perfil) {
        return listaBO.verificarSeTemListas(nome_perfil);
    }
    // Outros métodos do controller relacionados a listas podem ser adicionados aqui.
}