package enj.appdesktop.controller;

import enj.appdesktop.model.bo.NotaBO;
import enj.appdesktop.model.vo.NotasVO;

public class NotaController {
    private NotaBO notaBO = new NotaBO();

    public void salvarNota(String titulo, String conteudo) {
        NotasVO nota = new NotasVO();
        nota.setTitulo(titulo);
        nota.setContent(conteudo);

        notaBO.salvarNota(nota);
    }

    public void atualizarNota(int id, String titulo, String conteudo) {
        NotasVO nota = new NotasVO(id, titulo, conteudo);

        notaBO.atualizarNota(nota);
    }

    public void deletarNota(int id) {
        NotasVO nota = new NotasVO(id);

        notaBO.deletarNota(nota);
    }

    // Outros métodos do controller relacionados a notas podem ser adicionados aqui.
}
