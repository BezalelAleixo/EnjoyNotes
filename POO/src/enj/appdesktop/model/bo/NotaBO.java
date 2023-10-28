package enj.appdesktop.model.bo;

import enj.appdesktop.model.daoo.NotaDAO;
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

    // Outras regras de negócios relacionadas a notas podem ser adicionadas aqui.
}