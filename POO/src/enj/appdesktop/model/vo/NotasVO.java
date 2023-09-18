package enj.appdesktop.model.vo;

public class NotasVO {
	private int id;
    private String titulo;
    private String conteudo;
    

    public NotasVO() {
		super();
	}

	public NotasVO(int id, String titulo, String content) {
		this.id = id;
        this.titulo = titulo;
        this.conteudo = content;
    }
	
    public NotasVO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
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

    @Override
    public String toString() {
        return titulo;
    }
}