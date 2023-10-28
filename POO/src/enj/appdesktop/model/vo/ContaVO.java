package enj.appdesktop.model.vo;

public class ContaVO {
	private String nome_perfil;
	private String senha;
	
	public ContaVO() {
		super();
	}
	public ContaVO(String nome_perfil, String senha) {
		super();
		this.nome_perfil = nome_perfil;
		this.senha = senha;
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
}
