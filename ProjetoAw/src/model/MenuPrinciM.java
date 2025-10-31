package model;

import java.util.ArrayList;

public class MenuPrinciM {
  private ArrayList<CadastrarUser> cadastrarUser;
  private ArrayList<CadastroLivro> cadastroLivro;
  private ConsultaM consulta; 
  
  public MenuPrinciM() {
	  this.cadastrarUser = new ArrayList<>();
	  this.cadastroLivro = new ArrayList<>();
	  this.consulta = consulta;
  }

public ArrayList<CadastrarUser> getCadastrarUser() {
	return cadastrarUser;
}

public void setCadastrarUser(ArrayList<CadastrarUser> cadastrarUser) {
	this.cadastrarUser = cadastrarUser;
}

public ArrayList<CadastroLivro> getCadastroLivro() {
	return cadastroLivro;
}

public void setCadastroLivro(ArrayList<CadastroLivro> cadastroLivro) {
	this.cadastroLivro = cadastroLivro;
}

public ConsultaM getConsulta() {
	return consulta;
}

public void setConsulta(ConsultaM consulta) {
	this.consulta = consulta;
}
}
