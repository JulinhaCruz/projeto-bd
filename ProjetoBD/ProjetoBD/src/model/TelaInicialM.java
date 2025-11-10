package model;

import java.util.ArrayList;
import java.util.Vector;
import java.util.ArrayList;

public class TelaInicialM {

    private ArrayList<CadastroUserM> cadastroUser;
    private ArrayList<CadastroEmprestimoM> cadastroEmprestimo;

    public TelaInicialM() {
        this.cadastroUser = new ArrayList<>();
        this.cadastroEmprestimo = new ArrayList<>();
    }

    public static String[][] getLivros() {
        return new String[][]{
                {"Crepúsculo", "Romance", "Stephenie Meyer"},
                {"Jogos Vorazes", "Ficção Científica", "Suzanne Collins"},
                {"Verity", "Suspense", "Colleen Hoover"},
                {"A Culpa é das Estrelas", "Romance", "John Green"},
                {"Táticas do Amor", "Romance", "Sarah Adams"},
                {"Eu e Esse Meu Coração", "Ficção Paranormal", "C. C. Hunter"}
        };
    }
    public static boolean livroDisponivel(String titulo) {
        String[][] livros = getLivros();

        for (String[] livro : livros) {
            if (livro[0].equalsIgnoreCase(titulo)) { // compara título
                return true;
            }
        }
        return false;
    }
}
