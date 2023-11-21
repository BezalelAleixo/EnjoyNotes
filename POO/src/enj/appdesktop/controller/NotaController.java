package enj.appdesktop.controller;

import java.util.List;

import enj.appdesktop.model.bo.NotaBO;
import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.NotasVO;

public class NotaController {
    private NotaBO notaBO = new NotaBO();

    public void salvarNota(String titulo, String conteudo, String foto, String cor, int id_conta) {
        NotasVO nota = new NotasVO();
        nota.setTitulo(titulo);
        nota.setContent(conteudo);
        nota.setFoto(foto);
        nota.setCor(cor);
        nota.setId_conta(id_conta);

        notaBO.salvarNota(nota);
    }

    public void atualizarNota(int id, String titulo, String conteudo, String foto, String cor) {
        NotasVO nota = new NotasVO(id, titulo, conteudo, foto, cor);

        notaBO.atualizarNota(nota);
    }

    public void deletarNota(int id) {
        NotasVO nota = new NotasVO(id);

        notaBO.deletarNota(nota);
    }
    
    public List<NotasVO> listarNotas(String nome_perfil) {
        // Chame o método correspondente na classe BO para listar as notas
        return notaBO.listarNotas(nome_perfil);
    }
    public List<NotasVO> NotasPreparadasdaCOnta() {
        return notaBO.NotasProntas();
    }
    public boolean verificarSeTemNotas(String nome_perfil) {
        return notaBO.verificarSeTemNota(nome_perfil);
    }
}
