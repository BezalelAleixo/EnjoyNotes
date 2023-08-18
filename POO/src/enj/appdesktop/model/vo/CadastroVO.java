package enj.appdesktop.model.vo;

/**
 * @author prfel
 * @see Classe para getters e setters da dos atributos do usuario
 */
public class CadastroVO {
	private String nome, sexo, datanasc, nomeUsuario, senha;
	private int id;


	public CadastroVO(String nome, String sexo, String datanasc, String nomeUsuario, String senha) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public CadastroVO() {
		
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
