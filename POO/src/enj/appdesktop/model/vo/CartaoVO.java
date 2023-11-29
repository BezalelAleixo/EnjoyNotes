package enj.appdesktop.model.vo;

public class CartaoVO {
	private int id;
	private String titulo;
	private String descricao;
	private String data_criac;
	private int id_list_cartao;
	
	public CartaoVO() {
		super();
	}

	public CartaoVO(String titulo, String descricao, int id_list_cartao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.id_list_cartao = id_list_cartao;
	}

	public CartaoVO(int id, String titulo, String descricao, int id_list_cartao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.id_list_cartao = id_list_cartao;
	}

	public CartaoVO(int id) {
		super();
		this.id = id;
	}
	
	

	public CartaoVO(int id, String titulo, String descricao, String data_criac, int id_list_cartao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data_criac = data_criac;
		this.id_list_cartao = id_list_cartao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData_criac() {
		return data_criac;
	}

	public void setData_criac(String data_criac) {
		this.data_criac = data_criac;
	}

	public int getId_list_cartao() {
		return id_list_cartao;
	}

	public void setId_list_cartao(int id_list_cartao) {
		this.id_list_cartao = id_list_cartao;
	}
	
}
