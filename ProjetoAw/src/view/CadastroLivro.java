package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CadastroLivro extends JFrame {

    private JPanel contentPane;
    private JTextField txtTitulo, txtAutor, txtGenero;
    private JButton btnProximo1, btnProximo2, btnSalvar;
    private MenuPrinci menu;

    public CadastroLivro() {
        setTitle("Cadastro de Livros");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setForeground(new Color(255, 255, 255));
        contentPane.setBackground(new Color(68, 68, 34));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblTituloTela = new JLabel("Cadastro de Livros", SwingConstants.CENTER);
        lblTituloTela.setForeground(new Color(255, 255, 255));
        lblTituloTela.setFont(new Font("Arial", Font.BOLD, 22));
        lblTituloTela.setBounds(41, 28, 300, 30);
        contentPane.add(lblTituloTela);

        // Campo 1 - Título
        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setForeground(new Color(255, 255, 255));
        lblTitulo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        lblTitulo.setBounds(154, 79, 60, 25);
        contentPane.add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(106, 114, 171, 35);
        contentPane.add(txtTitulo);

        btnProximo1 = new JButton("Próximo");
        btnProximo1.setBounds(130, 175, 120, 30); // centralizado
        contentPane.add(btnProximo1);

        // Campo 2 - Autor (invisível inicialmente)
        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblAutor.setBounds(148, 79, 66, 25);
        lblAutor.setVisible(false);
        contentPane.add(lblAutor);

        txtAutor = new JTextField();
        txtAutor.setBounds(106, 114, 171, 35);
        txtAutor.setVisible(false);
        contentPane.add(txtAutor);

        btnProximo2 = new JButton("Próximo");
        btnProximo2.setBounds(130, 175, 120, 30); // centralizado
        btnProximo2.setVisible(false);
        contentPane.add(btnProximo2);

        // Campo 3 - Gênero (invisível inicialmente)
        JLabel lblGenero = new JLabel("Gênero:");
        lblGenero.setForeground(new Color(255, 255, 255));
        lblGenero.setFont(new Font("Century Gothic", Font.PLAIN, 19));
        lblGenero.setBounds(130, 79, 100, 25);
        lblGenero.setVisible(false);
        contentPane.add(lblGenero);

        txtGenero = new JTextField();
        txtGenero.setBounds(106, 114, 173, 35);
        txtGenero.setVisible(false);
        contentPane.add(txtGenero);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(130, 175, 120, 30); // centralizado
        btnSalvar.setVisible(false);
        contentPane.add(btnSalvar);

        // Ações dos botões
        btnProximo1.addActionListener(e -> {
            if (!txtTitulo.getText().isEmpty()) {
                txtTitulo.setVisible(false);
                lblTitulo.setVisible(false);
                btnProximo1.setVisible(false);

                lblAutor.setVisible(true);
                txtAutor.setVisible(true);
                btnProximo2.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Digite o título!");
            }
        });

        btnProximo2.addActionListener(e -> {
            if (!txtAutor.getText().isEmpty()) {
                txtAutor.setVisible(false);
                lblAutor.setVisible(false);
                btnProximo2.setVisible(false);

                lblGenero.setVisible(true);
                txtGenero.setVisible(true);
                btnSalvar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Digite o autor!");
            }
        });

        btnSalvar.addActionListener(e -> {
            if (!txtGenero.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Livro salvo!\nTítulo: " + txtTitulo.getText() +
                        "\nAutor: " + txtAutor.getText() +
                        "\nGênero: " + txtGenero.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Digite o gênero!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CadastroLivro().setVisible(true));
        JMenuItem itemNovoLivro = new JMenuItem("Novo Livro");
        itemNovoLivro.addActionListener(e -> new CadastroLivro().setVisible(true));
        
    }
}
