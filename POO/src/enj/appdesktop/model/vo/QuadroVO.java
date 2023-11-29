package enj.appdesktop.model.vo;

public class QuadroVO {
	private int id;
	private String nome_quad;
	private String descricao;
	private String data_criac;
	private int id_conta_quadro;
	
	public QuadroVO() {
		super();
	}

	public QuadroVO(String nome_quad, String descricao, int id_conta_quadro) {
		super();
		this.nome_quad = nome_quad;
		this.descricao = descricao;
		this.id_conta_quadro = id_conta_quadro;
	}

	public QuadroVO(int id, String nome_quad, String descricao, int id_conta_quadro) {
		super();
		this.id = id;
		this.nome_quad = nome_quad;
		this.descricao = descricao;
		this.id_conta_quadro = id_conta_quadro;
	}

	public QuadroVO(int id) {
		super();
		this.id = id;
	}

	public QuadroVO(int id, String nome_quad, String descricao, String data_criac, int id_conta_quadro) {
		super();
		this.id = id;
		this.nome_quad = nome_quad;
		this.descricao = descricao;
		this.data_criac = data_criac;
		this.id_conta_quadro = id_conta_quadro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_quad() {
		return nome_quad;
	}

	public void setNome_quad(String nome_quad) {
		this.nome_quad = nome_quad;
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

	public int getId_conta_quadro() {
		return id_conta_quadro;
	}

	public void setId_conta_quadro(int id_conta_quadro) {
		this.id_conta_quadro = id_conta_quadro;
	}
	
}
