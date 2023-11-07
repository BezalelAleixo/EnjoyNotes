package enj.appdesktop.controller;


import enj.appdesktop.model.bo.UsuarioBO;
import enj.appdesktop.model.vo.UsuarioVO;

public class UsuarioController {
    private UsuarioBO usuarioBO = new UsuarioBO();

    public void cadastrarUsuario(String nome, String sexo, String datanasc, int id_conta) {
        usuarioBO.cadastrarUsuario(nome, sexo, datanasc, id_conta);
    }
    public void BuscarID_conta(String nome_perfil) {
        usuarioBO.buscarIdConta(nome_perfil);
    }
    public int getID_CONTA() {
    	return usuarioBO.GET_id_conta();
    }
    public void BuscarDadosUSER(int id_conta_CE) {
        usuarioBO.buscarUser(id_conta_CE);
    }
    public UsuarioVO MyUser() {
        return usuarioBO.MeuUser();
    }
    // Outros métodos do controller relacionados a usuários podem ser adicionados aqui.
    public static void main(String[] args) {
		UsuarioController usuario = new UsuarioController();
		usuario.BuscarID_conta("Sidlene");
		System.out.println(usuario.getID_CONTA());
	}
}
