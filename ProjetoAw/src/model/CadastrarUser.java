package model;

public class CadastrarUser {
	private String nome;

	private String matrícula;
	private int senha; // 4 dígitos
	
	
  public CadastrarUser( String nome, String matrícula, int senha) {
	  this.nome= nome;
	  
	  this.matrícula = matrícula;
	  this.senha = senha;
	  
	  if (matrícula == null || nome == null) {
		  System.out.println("Campo obrigatório.");
	  }
	  if (senha < 4) {
		  System.out.println("A senha precisa ter no mínimo 4 caractéres");
	  }
	  
	  
  }
  


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}



public String getMatrícula() {
	return matrícula;
}


public void setMatrícula(String matrícula) {
	this.matrícula = matrícula;
}


public int getSenha() {
	return senha;
}


public void setSenha(int senha) {
	this.senha = senha;
}
}
