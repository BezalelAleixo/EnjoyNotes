package enj.appdesktop.model.vo;

public class ContaVO {
	private String nome_perfil;
	private String senha;
	private String foto;
	private int id_conta;
	public ContaVO() {
		super();
	}
	public ContaVO(int id_conta,String nome_perfil, String senha, String foto) {
		super();
		this.id_conta = id_conta;
		this.nome_perfil = nome_perfil;
		this.senha = senha;
		this.foto = foto;
	}
	
	public ContaVO(String nome_perfil, String senha, String foto) {
		super();
		this.nome_perfil = nome_perfil;
		this.senha = senha;
		this.foto = foto;
	}
	public int getId_conta() {
		return id_conta;
	}
	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	public String getNome_perfil() {
		return nome_perfil;
	}
	public void setNome_perfil(String nome_perfil) {
		this.nome_perfil = nome_perfil;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
