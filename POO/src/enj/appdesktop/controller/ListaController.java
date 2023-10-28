package enj.appdesktop.controller;

import enj.appdesktop.model.bo.ListaBO;

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

    // Outros métodos do controller relacionados a listas podem ser adicionados aqui.
}