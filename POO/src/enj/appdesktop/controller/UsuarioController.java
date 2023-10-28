package enj.appdesktop.controller;


import enj.appdesktop.model.bo.UsuarioBO;

public class UsuarioController {
    private UsuarioBO usuarioBO = new UsuarioBO();

    public void cadastrarUsuario(String nome, String sexo, String datanasc) {
        usuarioBO.cadastrarUsuario(nome, sexo, datanasc);
    }

    // Outros métodos do controller relacionados a usuários podem ser adicionados aqui.
}
