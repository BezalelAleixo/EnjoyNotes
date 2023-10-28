package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.ListaDAO;
import enj.appdesktop.model.vo.ListaVO;

public class ListaBO {
    private ListaDAO listaDAO = new ListaDAO();

    public void salvarLista(String titulo, String itens) {
        ListaVO lista = new ListaVO(titulo, itens, 0); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

        try {
            listaDAO.SalvarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarLista(int id, String titulo, String itens) {
        ListaVO lista = new ListaVO(titulo, itens, id);

        try {
            listaDAO.AtualizarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarLista(int id) {
        ListaVO lista = new ListaVO(id);

        try {
            listaDAO.DeletarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    // Outros métodos de lógica de negócios relacionados a listas podem ser adicionados aqui.
}
