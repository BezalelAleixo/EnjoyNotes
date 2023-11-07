package enj.appdesktop.model.vo;

public class ListaVO {
	private int id;
    private String titulo_list;
    private String itens;
    private String data_de_criacao;
    
	public ListaVO() {
		super();
	}

	public ListaVO(String itens, String titulo_list, int id) {
		super();
		this.id = id;
		this.titulo_list = titulo_list;
		this.itens = itens;
	}

	public ListaVO(int id, String titulo_list, String itens, String data_de_criacao) {
		super();
		this.id = id;
		this.titulo_list = titulo_list;
		this.itens = itens;
		this.data_de_criacao = data_de_criacao;
	}

	public ListaVO(int id) {
		super();
		this.id = id;
	}

	public ListaVO(String titulo_list, String itens) {
		super();
		this.titulo_list = titulo_list;
		this.itens = itens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo_list() {
		return titulo_list;
	}

	public void setTitulo_list(String titulo_list) {
		this.titulo_list = titulo_list;
	}

	public String getItens() {
		return itens;
	}

	public void setItens(String itens) {
		this.itens = itens;
	}

	public String getData_de_criacao() {
		return data_de_criacao;
	}

	public void setData_de_criacao(String data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}
    

}
