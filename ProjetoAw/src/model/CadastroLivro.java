package model;

public class CadastroLivro {
	
	private String autor;
	private String titulo;
	private String genero;
	private String dataPublicacao; 
	
 public CadastroLivro(String autor, String título, String genero, String dataPublicacao) {
	 this.autor = autor;
	 this.dataPublicacao = dataPublicacao;
	 this.genero = genero;
	 this.titulo = titulo;
	 
	 if(autor == null ||dataPublicacao == null || genero == null || titulo == null) {
		 System.out.println("Campo obrigatório.");
	 }
 }

public String getAutor() {
	return autor;
}

public void setAutor(String autor) {
	this.autor = autor;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getGenero() {
	return genero;
}

public void setGenero(String genero) {
	this.genero = genero;
}

public String getDataPublicacao() {
	return dataPublicacao;
}

public void setDataPublicacao(String dataPublicacao) {
	this.dataPublicacao = dataPublicacao;
}
}
