package enj.appdesktop.model.vo;

public class NotasVO {
	private int id;
    private String titulo;
    private String conteudo;
    private String foto;
    private String cor;
    private String data_criacao;
    private int id_conta;
    

    public NotasVO() {
		super();
	}
    
    
	
	public NotasVO(int id, String titulo, String conteudo, String foto, String cor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.foto = foto;
		this.cor = cor;
	}



	public NotasVO(int id, String titulo, String conteudo, String foto, String cor, String data_criacao, int id_conta) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.foto = foto;
		this.cor = cor;
		this.data_criacao = data_criacao;
		this.id_conta = id_conta;
	}

	public NotasVO(int id) {
		super();
		this.id = id;
	}

	public NotasVO(String titulo, String conteudo, String foto, String cor, int id_conta) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.foto = foto;
		this.cor = cor;
		this.id_conta = id_conta;
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

    public String getContent() {
        return conteudo;
    }
    public void setContent(String conteudo) {
    	this.conteudo = conteudo;
    }
    
    public String getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(String data_criacao) {
		this.data_criacao = data_criacao;
	}
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public int getId_conta() {
		return id_conta;
	}

	public void setId_conta(int id_conta) {
		this.id_conta = id_conta;
	}

	@Override
    public String toString() {
        return titulo;
    }
}