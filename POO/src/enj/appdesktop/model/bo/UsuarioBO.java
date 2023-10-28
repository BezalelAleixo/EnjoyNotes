package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.UsuarioDAO;
import enj.appdesktop.model.vo.UsuarioVO;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void cadastrarUsuario(String nome, String sexo, String datanasc) {
        UsuarioVO usuario = new UsuarioVO(nome, sexo, datanasc);

        try {
            usuarioDAO.cadastrar(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    // Outros métodos de lógica de negócios relacionados a usuários podem ser adicionados aqui.
}
