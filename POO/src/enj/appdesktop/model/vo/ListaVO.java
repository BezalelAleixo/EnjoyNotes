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
    

    public ListaVO(int id) {
		super();
		this.id = id;
	}


	public ListaVO() {
		// TODO Auto-generated constructor stub
	}


	public String getTitulo() {
        return titulo;
    }
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

    public String getItens() {
        return itens;
    }
    
    public void setItens(String itens) {
		this.itens = itens;
	}
    
    public int getId() {
    	return id;
    }
}
