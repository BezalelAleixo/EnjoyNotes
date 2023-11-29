package enj.appdesktop.model.vo;

public class Lista_CartaoVO{
	private int id;
    private String titulo_list;
    private String descricao;
    private String data_de_criacao;
    private int id_quadro;
    
	public Lista_CartaoVO() {
		super();
	}

	public Lista_CartaoVO(String titulo_list, int id_quadro) {
		super();
		this.titulo_list = titulo_list;
		this.id_quadro = id_quadro;
	}

	public Lista_CartaoVO(int id, String titulo_list, int id_quadro) {
		super();
		this.id = id;
		this.titulo_list = titulo_list;
		this.id_quadro = id_quadro;
	}

	public Lista_CartaoVO(int id) {
		super();
		this.id = id;
	}
	
	public Lista_CartaoVO(int id, String titulo_list, String data_de_criacao, int id_quadro) {
		super();
		this.id = id;
		this.titulo_list = titulo_list;
		this.data_de_criacao = data_de_criacao;
		this.id_quadro = id_quadro;
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

	public String getData_de_criacao() {
		return data_de_criacao;
	}

	public void setData_de_criacao(String data_de_criacao) {
		this.data_de_criacao = data_de_criacao;
	}

	public int getId_quadro() {
		return id_quadro;
	}

	public void setId_quadro(int id_quadro) {
		this.id_quadro = id_quadro;
	}

	
    

}
