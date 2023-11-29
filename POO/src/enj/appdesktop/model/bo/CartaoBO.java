package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.CartaoDAO;
import enj.appdesktop.model.daoo.QuadroDAO;
import enj.appdesktop.model.vo.CartaoVO;
import enj.appdesktop.model.vo.QuadroVO;

public class CartaoBO {
	private CartaoDAO cartaoDAO = new CartaoDAO();

    public void salvarCartao(String titulo, String descricao, int id_list) {
        CartaoVO cartao = new CartaoVO(titulo, descricao, id_list); // O ID pode ser 0 porque será atribuído automaticamente no banco de dados.

        try {
            cartaoDAO.SalvarCartaoDAO(cartao);
        } catch (Exception e) {
            System.out.println("Erro ao salvar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarCartao(int id, String titulo, String descricao, int id_list) {
    	CartaoVO cartao = new CartaoVO(id, titulo, descricao, id_list);

        try {
            cartaoDAO.AtualizarCartaoDAO(cartao);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarCartao(int id) {
    	CartaoVO cartao = new CartaoVO(id);

        try {
            cartaoDAO.DeletarCartaoDAO(cartao);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }
    public List<CartaoVO> listarLISTAS(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<CartaoVO> listas = cartaoDAO.todasListas(nome_perfil);
        return listas;
    }
    public List<CartaoVO> ListasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return cartaoDAO.PreparadListas();
    }
    public int Direita(int id_list) {
    	CartaoVO cartao = new CartaoVO(id_list);
    	int id_list_cartao=0;
    	try {
    		id_list_cartao = cartaoDAO.Direita(cartao);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
        }
    	return id_list_cartao;
    }
    public int Esquerda(int id_list) {
    	CartaoVO cartao = new CartaoVO(id_list);
    	int id_list_cartao=0;
    	try {
            id_list_cartao = cartaoDAO.Esquerda(cartao);
        } catch (Exception e) {
            System.out.println("Erro ao deletar lista: " + e.getMessage());
        }
    	return id_list_cartao;
    }
}
