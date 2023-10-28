package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.ContaDAO;
import enj.appdesktop.model.vo.ContaVO;

public class ContaBO {
    private ContaDAO contaDAO = new ContaDAO();

    public void cadastrarConta(String nome_perfil, String senha) {
        ContaVO conta = new ContaVO(nome_perfil, senha);

        try {
            contaDAO.cadastrar(conta);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar conta: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    // Outros métodos de lógica de negócios relacionados a contas podem ser adicionados aqui.
}
