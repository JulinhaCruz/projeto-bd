package model;

import java.util.ArrayList;

public class CadastroUserM {

    private String matricula;
    private String senha;
    private static ArrayList<CadastroUserM> listaUsuarios = new ArrayList<>();

    public CadastroUserM(String matricula, String senha) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula obrigatória.");
        }
        if (senha == null || senha.length() < 4) {
            throw new IllegalArgumentException("A senha precisa ter pelo menos 4 dígitos.");
        }

        this.matricula = matricula;
        this.senha = senha;

        // Salva o usuário na lista da memória
        listaUsuarios.add(this);
    }

    // verifica existência da matrícula (apenas matrícula)
    public static boolean VerificMatricula(String matricula) {
        if (matricula == null) return false;
        for (CadastroUserM u : listaUsuarios) {
            if (u.getMatricula().equals(matricula)) return true;
        }
        return false;
    }

    // verifica se a senha informada bate com a matrícula
    public static boolean VerificSenha(String matricula, String senha) {
        if (matricula == null || senha == null) return false;
        for (CadastroUserM u : listaUsuarios) {
            if (u.getMatricula().equals(matricula) && u.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    // utilitário que combina as duas verificações (se precisar)
    public static boolean validarUsuario(String matricula, String senha) {
        return VerificSenha(matricula, senha);
    }

    public static ArrayList<CadastroUserM> getUsuarios() {
        return listaUsuarios;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }
}
