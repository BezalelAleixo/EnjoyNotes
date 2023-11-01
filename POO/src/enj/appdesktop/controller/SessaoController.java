package enj.appdesktop.controller;

import enj.appdesktop.model.bo.SessaoBO;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.SessaoVO;

import java.util.List;

public class SessaoController {
    private SessaoBO sessaoBO = new SessaoBO();

    public void cadastrarSessao(String acesso, int id_conta_acesso) {
        sessaoBO.cadastrarSessao(acesso, id_conta_acesso);
    }

    public void atualizarSessao(String acesso, int id_conta_acesso) {
        sessaoBO.atualizarSessao(acesso, id_conta_acesso);
    }

    public boolean verificarSessao(int id_conta_acesso) {
        return sessaoBO.verificarSessao(id_conta_acesso);
    }

    public List<SessaoVO> sessoesLogadas() {
        return sessaoBO.sessoesLogadasDasContas();
    }

    public List<SessaoVO> ListaSessoesFeitas(){
		return sessaoBO.ListaSessoes();
    }
    public List<ContaVO> ListaContasFeitas(){
		return sessaoBO.ListaContas();
    	
    }
    
    public static void main(String[] args) {
		SessaoController controller = new SessaoController();
		controller.sessoesLogadas();
		
		for(ContaVO contas : controller.ListaContasFeitas()) {
			System.out.println("foto: "+ contas.getFoto());
			System.out.println("nome de perfil: "+ contas.getNome_perfil());
		}
	}
}