package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.CadastroUserM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CadastroUser extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldMatricula;
    private JTextField textFieldSenha;

    private JLabel lblNewLabelMatricula;
    private JLabel lblNewLabelSenha;

    private JButton btnProximoMatricula;
    private JButton btnConcluir;
    private JButton btnVoltar;

    public CadastroUser() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(188, 143, 143));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Título
        JLabel lblCadastros = new JLabel("Cadastro de Usuário");
        lblCadastros.setBounds(90, 20, 250, 30);
        lblCadastros.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastros.setForeground(Color.WHITE);
        lblCadastros.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(lblCadastros);

        // Label Matrícula (AGORA ATRIBUTO)
        lblNewLabelMatricula = new JLabel("Matrícula:");
        lblNewLabelMatricula.setForeground(Color.WHITE);
        lblNewLabelMatricula.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabelMatricula.setBounds(177, 70, 110, 25);
        contentPane.add(lblNewLabelMatricula);

        // Campo Matrícula
        textFieldMatricula = new JTextField();
        textFieldMatricula.setBounds(155, 110, 121, 30);
        contentPane.add(textFieldMatricula);

        // Botão Próximo (Matrícula)
        btnProximoMatricula = new JButton("Próximo");
        btnProximoMatricula.setBounds(200, 169, 110, 31);
        contentPane.add(btnProximoMatricula);

        // Label Senha (AGORA ATRIBUTO)
        lblNewLabelSenha = new JLabel("Senha:");
        lblNewLabelSenha.setForeground(Color.WHITE);
        lblNewLabelSenha.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabelSenha.setBounds(184, 70, 200, 25);
        lblNewLabelSenha.setVisible(false);
        contentPane.add(lblNewLabelSenha);

        // Campo Senha
        textFieldSenha = new JTextField();
        textFieldSenha.setBounds(155, 110, 121, 30);
        textFieldSenha.setVisible(false);
        contentPane.add(textFieldSenha);

        // Botão Concluir
        btnConcluir = new JButton("Concluir");
        btnConcluir.setBounds(206, 169, 100, 30);
        btnConcluir.setVisible(false);
        contentPane.add(btnConcluir);

        // **BOTÃO VOLTAR (VISÍVEL SOMENTE NAS ETAPAS 2)**
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(85, 169, 100, 30);
        btnVoltar.setVisible(false);
        contentPane.add(btnVoltar);

        // ===== AÇÕES ===== //

        // PASSO 1 — Matrícula → Senha
        btnProximoMatricula.addActionListener(e -> {
            if (textFieldMatricula.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite a matrícula!");
            } else {

                lblNewLabelMatricula.setVisible(false);
                textFieldMatricula.setVisible(false);
                btnProximoMatricula.setVisible(false);

                lblNewLabelSenha.setVisible(true);
                textFieldSenha.setVisible(true);
                btnConcluir.setVisible(true);
                btnVoltar.setVisible(true);
            }
        });

        // BOTÃO VOLTAR — VOLTA PARA MATRÍCULA
        btnVoltar.addActionListener(e -> {

            lblNewLabelSenha.setVisible(false);
            textFieldSenha.setVisible(false);
            btnConcluir.setVisible(false);
            btnVoltar.setVisible(false);

            lblNewLabelMatricula.setVisible(true);
            textFieldMatricula.setVisible(true);
            btnProximoMatricula.setVisible(true);
        });

        // PASSO 2 — SALVAR
        btnConcluir.addActionListener(e -> {
            try {
                new CadastroUserM(textFieldMatricula.getText(), textFieldSenha.getText());
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
    }
    public static void main(String[] args) {
        new CadastroUser().setVisible(true);
    }
}
