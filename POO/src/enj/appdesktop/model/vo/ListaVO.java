package enj.appdesktop.model.vo;

public class ListaVO {
    private String titulo;
    private String itens;
    private int id;

    public ListaVO(String titulo, String itens, int id) {
        this.titulo = titulo;
        this.itens = itens;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getItens() {
        return itens;
    }
   
    public int getId() {
    	return id;
    }
}
