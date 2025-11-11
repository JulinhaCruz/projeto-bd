package model;



import java.util.ArrayList;

public class CadastroEmprestimoM {

    private String matricula;
    private String senha;
    private String titulo;
    private String genero;
    private static ArrayList<CadastroEmprestimoM> cadastroM = new ArrayList<>();

    public CadastroEmprestimoM(String matricula, String senha, String titulo) {
        if (matricula == null || matricula.trim().isEmpty() ||
            titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Campos obrigatórios não podem ser vazios.");
        }

        this.matricula = matricula;
        this.senha = senha;
        this.titulo = titulo;

        
        cadastroM.add(this);
    }
    

    public static ArrayList<CadastroEmprestimoM> getListaEmprestimo() {
        return cadastroM;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }
}

