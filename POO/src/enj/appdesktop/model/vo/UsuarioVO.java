package enj.appdesktop.model.vo;

/**
 * @author prfel
 * @see Classe para getters e setters da dos atributos do usuario
 */
public class UsuarioVO {
	private String nome, sexo, datanasc;
	private int id_usuario;
	private int id_conta;

	
	public UsuarioVO(String nome, String sexo, String datanasc, int id_usuario, int id_conta) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		this.id_usuario = id_usuario;
		this.id_conta = id_conta;
	}

	public UsuarioVO(String nome, String sexo, String datanasc, int id_conta) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		this.id_conta = id_conta;
	}

	public UsuarioVO(String nome, String sexo, String datanasc) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		
	}

	public UsuarioVO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public int getId() {
		return id_conta;
	}

	public void setId(int id) {
		this.id_conta = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
}
