package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.CadastroEmprestimoM;
import model.CadastroUserM;
import model.TelaInicialM;

public class CadastroEmprestimo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldMatricula;
    private JPasswordField textFieldSenha;
    private JTextField textFieldTitulo;

    private JButton btnProximo;
    private JButton btnProximo2;
    private JButton btnConcluir;
    private JButton btnVoltar;
    private TelaInicialM tela;

    private JLabel lblMatricula, lblSenha, lblTitulo;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CadastroEmprestimo frame = new CadastroEmprestimo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CadastroEmprestimo() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(188, 143, 143));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTituloJanela = new JLabel("Cadastro de Empréstimo");
        lblTituloJanela.setBounds(70, 20, 300, 30);
        lblTituloJanela.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloJanela.setForeground(Color.WHITE);
        lblTituloJanela.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(lblTituloJanela);

        // ===== ETAPA 1 – MATRÍCULA =====
        lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setForeground(Color.WHITE);
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 15));
        lblMatricula.setBounds(164, 70, 100, 25);
        contentPane.add(lblMatricula);

        textFieldMatricula = new JTextField();
        textFieldMatricula.setBounds(145, 100, 130, 30);
        contentPane.add(textFieldMatricula);

        btnProximo = new JButton("Próximo");
        btnProximo.setBounds(219, 150, 110, 30);
        contentPane.add(btnProximo);

        // ===== ETAPA 2 – SENHA =====
        lblSenha = new JLabel("Senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setFont(new Font("Arial", Font.BOLD, 15));
        lblSenha.setBounds(185, 70, 100, 25);
        lblSenha.setVisible(false);
        contentPane.add(lblSenha);

        textFieldSenha = new JPasswordField();
        textFieldSenha.setBounds(155, 100, 130, 30);
        textFieldSenha.setVisible(false);
        contentPane.add(textFieldSenha);

        btnProximo2 = new JButton("Próximo");
        btnProximo2.setBounds(219, 150, 110, 30);
        btnProximo2.setVisible(false);
        contentPane.add(btnProximo2);

        // ===== ETAPA 3 – TÍTULO DO LIVRO =====
        lblTitulo = new JLabel("Título do Livro:");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 15));
        lblTitulo.setBounds(155, 70, 150, 25);
        lblTitulo.setVisible(false);
        contentPane.add(lblTitulo);

        textFieldTitulo = new JTextField();
        textFieldTitulo.setBounds(155, 100, 130, 30);
        textFieldTitulo.setVisible(false);
        contentPane.add(textFieldTitulo);

        btnConcluir = new JButton("Concluir");
        btnConcluir.setBounds(219, 150, 110, 30);
        btnConcluir.setVisible(false);
        contentPane.add(btnConcluir);

        // Voltar (invisível no início)
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(85, 149, 100, 33);
        btnVoltar.setVisible(false);
        contentPane.add(btnVoltar);

        // ===== AÇÕES =====

        // ETAPA 1 → ETAPA 2 (apenas avança para pedir senha; aqui já podemos checar se matrícula existe)
        btnProximo.addActionListener(e -> {
            String matricula = textFieldMatricula.getText().trim();
            if (matricula.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite a matrícula!");
                return;
            }
            // verificar se matrícula existe
            if (!CadastroUserM.VerificMatricula(matricula)) {
                JOptionPane.showMessageDialog(this, "Matrícula não encontrada.");
                return;
            }

            lblMatricula.setVisible(false);
            textFieldMatricula.setVisible(false);
            btnProximo.setVisible(false);

            lblSenha.setVisible(true);
            textFieldSenha.setVisible(true);
            btnProximo2.setVisible(true);
            btnVoltar.setVisible(true);
        });

        // ETAPA 2 → ETAPA 3 (verifica senha para a matrícula já informada)
        btnProximo2.addActionListener(e -> {
            String matricula = textFieldMatricula.getText().trim();
            String senha = new String(textFieldSenha.getPassword()).trim();
            if (senha.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite a senha!");
                return;
            }
            if (!CadastroUserM.VerificSenha(matricula, senha)) {
                JOptionPane.showMessageDialog(this, "Senha incorreta para essa matrícula.");
                return;
            }

            // avança para título
            lblSenha.setVisible(false);
            textFieldSenha.setVisible(false);
            btnProximo2.setVisible(false);

            lblTitulo.setVisible(true);
            textFieldTitulo.setVisible(true);
            btnConcluir.setVisible(true);
        });

        // Voltar: se estiver em título volta para senha; se estiver em senha volta para matrícula
        btnVoltar.addActionListener(e -> {
            if (lblTitulo.isVisible()) {
                // volta de título para senha
                lblTitulo.setVisible(false);
                textFieldTitulo.setVisible(false);
                btnConcluir.setVisible(false);

                lblSenha.setVisible(true);
                textFieldSenha.setVisible(true);
                btnProximo2.setVisible(true);
            } else if (lblSenha.isVisible()) {
                // volta de senha para matrícula
                lblSenha.setVisible(false);
                textFieldSenha.setVisible(false);
                btnProximo2.setVisible(false);

                lblMatricula.setVisible(true);
                textFieldMatricula.setVisible(true);
                btnProximo.setVisible(true);
                btnVoltar.setVisible(false); // na etapa 1 não mostra Voltar
            }
        });

        // FINALIZAR
        btnConcluir.addActionListener(e -> {
        	    String matricula = textFieldMatricula.getText().trim();
        	    String senha = new String(textFieldSenha.getPassword()).trim();
        	    String titulo = textFieldTitulo.getText().trim();

        	    // Verificar se livro existe
        	    if (!TelaInicialM.livroDisponivel(titulo)) {
        	        JOptionPane.showMessageDialog(this, "Livro não está disponível.");
        	        return;
        	    }

        	    // Verificar se matrícula existe
        	    if (!CadastroUserM.VerificMatricula(matricula)) {
        	        JOptionPane.showMessageDialog(this, "Matrícula não existe.");
        	        return;
        	    }

        	    // Verificar senha
        	    if (!CadastroUserM.VerificSenha(matricula, senha)) {
        	        JOptionPane.showMessageDialog(this, "Senha incorreta.");
        	        return;
        	    }

        	    // Registrar o empréstimo
        	    new CadastroEmprestimoM(matricula, senha, titulo);

        	    JOptionPane.showMessageDialog(this, "Empréstimo realizado com sucesso!");
        	    dispose();
        	});


    }
}
