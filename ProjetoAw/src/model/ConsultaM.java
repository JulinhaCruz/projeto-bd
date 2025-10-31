package model;

public class ConsultaM {
	private String titulo;
	private String genero;
	private CadastrarUser usuario;
	

public ConsultaM(CadastroLivro livro, CadastrarUser usuario) {
	 
	this.titulo = livro.getTitulo();
	 this.genero = livro.getGenero();
	 this.usuario = usuario;
	 
 }


public CadastrarUser getUsuario() {
	return usuario;
}


public void setUsuario(CadastrarUser usuario) {
	this.usuario = usuario;
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

}
