package enj.appdesktop.model.vo;

public class VideoVO {
	private int id;
	private String nome_video;
	private String caminho_video;
	private int id_conta;
	
	public VideoVO() {
		super();
	}

	public VideoVO(String nome_video, String caminho_video, int id_conta) {
		super();
		this.nome_video = nome_video;
		this.caminho_video = caminho_video;
		this.id_conta = id_conta;
	}

	public VideoVO(int id, String nome_video, String caminho_video, int id_conta) {
		super();
		this.id = id;
		this.nome_video = nome_video;
		this.caminho_video = caminho_video;
		this.id_conta = id_conta;
	}

	public VideoVO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_video() {
		return nome_video;
	}

	public void setNome_video(String nome_video) {
		this.nome_video = nome_video;
	}

	public String getCaminho_video() {
		return caminho_video;
	}

	public void setCaminho_video(String caminho_video) {
		this.caminho_video = caminho_video;
	}

	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}
	
	
}
