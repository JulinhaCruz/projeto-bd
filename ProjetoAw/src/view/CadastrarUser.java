package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;


public class CadastrarUser extends JFrame {

	    private JPanel contentPane;
	    private JTextField txtNome, txtMatricula;
	    private JPasswordField txtSenha;
	    private JButton btnProximo1, btnProximo2, btnSalvar;

	    public CadastrarUser() {
	        setTitle("Cadastro de Usuário");
	        setSize(400, 300);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(68, 68, 34));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        JLabel lblTituloTela = new JLabel("Cadastro de Usuário", SwingConstants.CENTER);
	        lblTituloTela.setForeground(Color.WHITE);
	        lblTituloTela.setFont(new Font("Arial", Font.BOLD, 22));
	        lblTituloTela.setBounds(41, 28, 300, 30);
	        contentPane.add(lblTituloTela);

	        // ===== CAMPO 1: Nome =====
	        JLabel lblNome = new JLabel("Nome:");
	        lblNome.setForeground(Color.WHITE);
	        lblNome.setFont(new Font("Century Gothic", Font.PLAIN, 18));
	        lblNome.setBounds(150, 79, 100, 25);
	        contentPane.add(lblNome);

	        txtNome = new JTextField();
	        txtNome.setBounds(100, 114, 190, 35);
	        contentPane.add(txtNome);

	        btnProximo1 = new JButton("Próximo");
	        btnProximo1.setBounds(130, 175, 120, 30);
	        contentPane.add(btnProximo1);

	        // ===== CAMPO 2: Matrícula =====
	        JLabel lblMatricula = new JLabel("Matrícula:");
	        lblMatricula.setForeground(Color.WHITE);
	        lblMatricula.setFont(new Font("Century Gothic", Font.PLAIN, 18));
	        lblMatricula.setBounds(135, 79, 120, 25);
	        lblMatricula.setVisible(false);
	        contentPane.add(lblMatricula);

	        txtMatricula = new JTextField();
	        txtMatricula.setBounds(100, 114, 190, 35);
	        txtMatricula.setVisible(false);
	        contentPane.add(txtMatricula);

	        btnProximo2 = new JButton("Próximo");
	        btnProximo2.setBounds(130, 175, 120, 30);
	        btnProximo2.setVisible(false);
	        contentPane.add(btnProximo2);

	        // ===== CAMPO 3: Senha =====
	        JLabel lblSenha = new JLabel("Senha (4 dígitos):");
	        lblSenha.setForeground(Color.WHITE);
	        lblSenha.setFont(new Font("Century Gothic", Font.PLAIN, 17));
	        lblSenha.setBounds(100, 80, 200, 25);
	        lblSenha.setVisible(false);
	        contentPane.add(lblSenha);

	        txtSenha = new JPasswordField();
	        txtSenha.setBounds(100, 114, 190, 35);
	        txtSenha.setVisible(false);
	        contentPane.add(txtSenha);

	        btnSalvar = new JButton("Salvar");
	        btnSalvar.setBounds(130, 175, 120, 30);
	        btnSalvar.setVisible(false);
	        contentPane.add(btnSalvar);

	        // ===== AÇÕES DOS BOTÕES =====

	        // Botão 1 → Próximo: Matrícula
	        btnProximo1.addActionListener(e -> {
	            if (!txtNome.getText().isEmpty()) {
	                txtNome.setVisible(false);
	                lblNome.setVisible(false);
	                btnProximo1.setVisible(false);

	                lblMatricula.setVisible(true);
	                txtMatricula.setVisible(true);
	                btnProximo2.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(this, "Digite o nome!");
	            }
	        });

	        // Botão 2 → Próximo: Senha
	        btnProximo2.addActionListener(e -> {
	            if (!txtMatricula.getText().isEmpty()) {
	                txtMatricula.setVisible(false);
	                lblMatricula.setVisible(false);
	                btnProximo2.setVisible(false);

	                lblSenha.setVisible(true);
	                txtSenha.setVisible(true);
	                btnSalvar.setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(this, "Digite a matrícula!");
	            }
	        });

	        // Botão Salvar → Validação final
	        btnSalvar.addActionListener(e -> {
	            String senha = new String(txtSenha.getPassword());
	            if (senha.length() == 4) {
	                JOptionPane.showMessageDialog(this,
	                        "Usuário salvo!\nNome: " + txtNome.getText() +
	                        "\nMatrícula: " + txtMatricula.getText() +
	                        "\nSenha: " + senha);
	            } else {
	                JOptionPane.showMessageDialog(this, "A senha precisa ter 4 dígitos!");
	            }
	        });
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new CadastrarUser().setVisible(true));
	    }
	}