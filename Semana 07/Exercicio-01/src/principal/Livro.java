package principal;

public class Livro {
	private String titulo;
	private String autor;
	private String editora;
	private int anoDaPublicacao;
	private int edicao;
	private String isbn;
		
	public Livro(String titulo, String autor, String editora, int anoDaPublicacao, int edicao, String isbn) {
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setEditora(editora);
		this.setAnoDaPublicacao(anoDaPublicacao);
		this.setEdicao(edicao);
		this.setIsbn(isbn);
	}
	
	public Livro() {};
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoDaPublicacao() {
		return anoDaPublicacao;
	}
	public void setAnoDaPublicacao(int anoDaPublicacao) {
		this.anoDaPublicacao = anoDaPublicacao;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}
