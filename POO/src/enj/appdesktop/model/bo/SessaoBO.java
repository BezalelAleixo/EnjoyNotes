package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.SessaoDAO;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.SessaoVO;

import java.util.List;

public class SessaoBO {
    private SessaoDAO sessaoDAO = new SessaoDAO();

    public void cadastrarSessao(String acesso, int id_conta_acesso) {
        SessaoVO sessao = new SessaoVO();
        sessao.setAcesso(acesso);
        sessao.setId_conta(id_conta_acesso);

        try {
            sessaoDAO.Cadastrar(sessao);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar sessao: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarSessao(String acesso, int id_conta_acesso) {
        SessaoVO sessao = new SessaoVO();
        sessao.setAcesso(acesso);
        sessao.setId_conta(id_conta_acesso);

        try {
            sessaoDAO.Atualizar(sessao);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar sessao: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public boolean verificarSessao(int id_conta_acesso) {
        SessaoVO sessao = new SessaoVO();
        sessao.setId_conta(id_conta_acesso);

        return sessaoDAO.verificar(sessao);
    }

    public List<SessaoVO> sessoesLogadasDasContas() {
        return sessaoDAO.Logadas();
    }

    public List<SessaoVO> ListaSessoes(){
		return sessaoDAO.Sessoes();
    }
    public List<ContaVO> ListaContas(){
		return sessaoDAO.PreparadContas();
    	
    }
}
