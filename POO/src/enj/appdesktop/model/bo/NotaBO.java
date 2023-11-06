package enj.appdesktop.model.bo;

import java.util.List;

import enj.appdesktop.model.daoo.NotaDAO;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;

public class NotaBO {
    private NotaDAO notaDAO = new NotaDAO();

    public void salvarNota(NotasVO nota) {
        try {
            notaDAO.SalvarNotaDAO(nota);
        } catch (Exception e) {
            System.out.println("Erro ao salvar nota: " + e.getMessage());
            // Você pode tratar o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void atualizarNota(NotasVO nota) {
        try {
            notaDAO.AtualizarNotaDAO(nota);
        } catch (Exception e) {
            System.out.println("Erro ao atualizar nota: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }

    public void deletarNota(NotasVO nota) {
        try {
            notaDAO.DeletarNotaDAO(nota);
        } catch (Exception e) {
            System.out.println("Erro ao deletar nota: " + e.getMessage());
            // Trate o erro de acordo com as necessidades do aplicativo.
        }
    }
    
    public List<NotasVO> listarNotas(String nome_perfil) {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        List<NotasVO> notas = notaDAO.todasNotas(nome_perfil);
        return notas;
    }
    public List<NotasVO> NotasProntas() {
        // Adicione a lógica para listar todas as notas associadas a uma conta específica
        return notaDAO.PreparadNotas();
    }
    public boolean verificarSeTemNota(String nome_perfil) {
        return notaDAO.verificarseTemNota(nome_perfil);
    }
    // Outras regras de negócios relacionadas a notas podem ser adicionadas aqui.
}