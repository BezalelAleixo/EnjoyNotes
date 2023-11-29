package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.QuadroDAO;
import enj.appdesktop.model.vo.QuadroVO;

public class QuadroBO {
	private QuadroDAO quadroDAO = new QuadroDAO();

    public void salvarQuadro(String titulo, String descricao, int id_conta) {
        QuadroVO quadro = new QuadroVO(titulo, descricao, id_conta); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

        try {
            quadroDAO.SalvarQuadroDAO(quadro);
        } catch (Exception e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarQuadro(int id, String titulo, String descricao, int id_conta) {
        QuadroVO quadro = new QuadroVO(id, titulo, descricao, id_conta);

        try {
            quadroDAO.AtualizarQuadroDAO(quadro);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarQuadro(int id) {
        QuadroVO quadro = new QuadroVO(id);

        try {
            quadroDAO.DeletarQuadroDAO(quadro);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }
    public List<QuadroVO> listarLISTAS(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<QuadroVO> listas = quadroDAO.todasListas(nome_perfil);
        return listas;
    }
    public List<QuadroVO> ListasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return quadroDAO.PreparadListas();
    }
}
