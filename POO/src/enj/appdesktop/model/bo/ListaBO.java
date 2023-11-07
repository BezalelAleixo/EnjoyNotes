package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.ListaDAO;
import enj.appdesktop.model.vo.ListaVO;
import enj.appdesktop.model.vo.NotasVO;

public class ListaBO {
    private ListaDAO listaDAO = new ListaDAO();

    public void salvarLista(String titulo, String itens) {
        ListaVO lista = new ListaVO(titulo, itens); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

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
    public List<ListaVO> listarLISTAS(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<ListaVO> listas = listaDAO.todasListas(nome_perfil);
        return listas;
    }
    public List<ListaVO> ListasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return listaDAO.PreparadListas();
    }
    public boolean verificarSeTemListas(String nome_perfil) {
        return listaDAO.verificarseTemNota(nome_perfil);
    }
  
}
