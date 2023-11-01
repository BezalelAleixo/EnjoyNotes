package enj.appdesktop.controller;

import enj.appdesktop.model.bo.ContaBO;

public class ContaController {
    private ContaBO contaBO = new ContaBO();

    public void cadastrarConta(String nome_perfil, String senha, String foto) {
        contaBO.cadastrarConta(nome_perfil, senha, foto);
    }

    // Outros métodos do controller relacionados a contas podem ser adicionados aqui.
}