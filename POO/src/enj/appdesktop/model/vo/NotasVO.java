package enj.appdesktop.model.vo;

public class NotasVO {
	private int id;
    private String titulo;
    private String conteudo;
    private String data_criacao;
    

    public NotasVO() {
		super();
	}
    
	public NotasVO(int id, String titulo, String conteudo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public NotasVO(int id, String titulo, String content, String data_criacao) {
		this.id = id;
        this.titulo = titulo;
        this.conteudo = content;
        this.data_criacao = data_criacao;
    }
	
	public NotasVO(int id) {
		super();
		this.id = id;
	}

	public NotasVO(String titulo, String conteudo) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
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

	@Override
    public String toString() {
        return titulo;
    }
}