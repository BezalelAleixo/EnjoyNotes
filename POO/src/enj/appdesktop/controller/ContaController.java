package enj.appdesktop.controller;

import enj.appdesktop.model.bo.ContaBO;
import enj.appdesktop.model.vo.ContaVO;

public class ContaController {
    private ContaBO contaBO = new ContaBO();

    public void cadastrarConta(String nome_perfil, String senha, String foto) {
        contaBO.cadastrarConta(nome_perfil, senha, foto);
    }
    public void ContaBuscada(int id) {
        contaBO.BuscarConta(id);
    }
    public ContaVO ContaMMinha() {
    	return contaBO.ContaMinha();
    }
    // Outros métodos do controller relacionados a contas podem ser adicionados aqui.
}