package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.Lista_CartaoDAO;
import enj.appdesktop.model.vo.Lista_CartaoVO;
import enj.appdesktop.model.vo.NotasVO;

public class Lista_CartaoBO {
    private Lista_CartaoDAO listaDAO = new Lista_CartaoDAO();

    public void salvarLista(String titulo, int id_quadro) {
        Lista_CartaoVO lista = new Lista_CartaoVO(titulo, id_quadro); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

        try {
            listaDAO.SalvarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarLista(int id, String titulo, int id_quadro) {
        Lista_CartaoVO lista = new Lista_CartaoVO(id, titulo, id_quadro);

        try {
            listaDAO.AtualizarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarLista(int id) {
        Lista_CartaoVO lista = new Lista_CartaoVO(id);

        try {
            listaDAO.DeletarListaDAO(lista);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }
    public List<Lista_CartaoVO> listarLISTAS(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<Lista_CartaoVO> listas = listaDAO.todasListas(nome_perfil);
        return listas;
    }
    public List<Lista_CartaoVO> ListasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return listaDAO.PreparadListas();
    }
  
}
