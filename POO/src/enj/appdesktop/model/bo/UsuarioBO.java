package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.UsuarioDAO;
import enj.appdesktop.model.vo.UsuarioVO;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void cadastrarUsuario(String nome, String sexo, String datanasc, int id_conta) {
        UsuarioVO usuario = new UsuarioVO(nome, sexo, datanasc, id_conta);

        try {
            usuarioDAO.cadastrar(usuario);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void buscarIdConta(String nomePerfil) {
    	try {
    		usuarioDAO.buscarId_conta(nomePerfil);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    
    }
    public int GET_id_conta() {
    	return usuarioDAO.getId_conta();
    }
    
    public void buscarUser(int id_conta_CE) {
    	try {
    		usuarioDAO.buscarDadosUsuario(id_conta_CE);;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    
    }
    public UsuarioVO MeuUser() {
        return usuarioDAO.MeuUsuario();
    }
}
