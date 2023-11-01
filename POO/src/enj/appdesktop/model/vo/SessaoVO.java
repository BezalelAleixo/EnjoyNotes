package enj.appdesktop.model.vo;

public class SessaoVO {
	private int id;
	private String acesso;
	private int id_conta;
	
	public SessaoVO() {
		super();
	}

	public SessaoVO(int id, String acesso, int id_conta) {
		super();
		this.id = id;
		this.acesso = acesso;
		this.id_conta = id_conta;
	}

	public SessaoVO(String acesso, int id_conta) {
		super();
		this.acesso = acesso;
		this.id_conta = id_conta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	
}
