package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.ConsultaM;
import java.util.ArrayList;
import java.util.List;
import view.ConsultaLivros;

public class MenuPrinci extends JFrame {

    private JPanel contentPane;
    private JLabel lblTitulo;
    private JMenuBar menuBar;
    private JMenu menuCadastrar, menuConsultar, menuLogin;
    private JTable table;
    private List<ConsultaM> historicoConsultas = new ArrayList<>();
    private MenuPrinci menu;


    public MenuPrinci() {
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 438, 299);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(128, 64, 0));

        // --- Menu Cadastrar ---
        menuCadastrar = new JMenu("Cadastrar");
        menuCadastrar.setForeground(Color.WHITE);

        JMenuItem itemNovoUsuario = new JMenuItem("Novo Usuário");
        itemNovoUsuario.addActionListener(e -> new CadastrarUser().setVisible(true));
        menuCadastrar.add(itemNovoUsuario);

        JMenuItem itemNovoLivro = new JMenuItem("Novo Livro");
        itemNovoLivro.addActionListener(e -> new CadastroLivro().setVisible(true));
        menuCadastrar.add(itemNovoLivro);
        
        JMenuItem itemNovoEmprestimo = new JMenuItem("Novo Emprestimo");
        itemNovoEmprestimo.addActionListener(e -> new CadastrarEmprestimo().setVisible(true));
        menuCadastrar.add(itemNovoEmprestimo);

       
        menuBar.add(menuCadastrar);

        // --- Menu Consultar ---
        menuConsultar = new JMenu("Consultar");
        menuConsultar.setForeground(Color.WHITE);

        JMenuItem itemConsultarLivros = new JMenuItem("Livros");
        itemConsultarLivros.addActionListener(e -> new ConsultaLivros(historicoConsultas).setVisible(true));
        menuConsultar.add(itemConsultarLivros);

        
        JMenuItem itemConsultaEmprestimos = new JMenuItem("Empréstimos");
        itemConsultaEmprestimos.addActionListener(e -> new ConsultaEmprestimos(historicoConsultas).setVisible(true));
        menuConsultar.add(itemConsultaEmprestimos);
        
        menuBar.add(menuConsultar);

        // --- Menu Login ---
        menuLogin = new JMenu("Login");
        menuLogin.setForeground(Color.WHITE);
        menuLogin.add(new JMenuItem("Entrar"));
        menuLogin.add(new JMenuItem("Sair"));
        menuBar.add(menuLogin);

        setJMenuBar(menuBar);

       
        contentPane = new JPanel();
        contentPane.setBackground(new Color(104, 0, 0));
        contentPane.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblTitulo = new JLabel("Bem-vindo ao Sistema de Biblioteca");
        lblTitulo.setBounds(30, 30, 364, 27);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(85, 79, 249, 122);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Título", "Gênero", "Autor"}
        ));
        scrollPane.setViewportView(table);
    }
    
 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MenuPrinci frame = new MenuPrinci();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            JMenuItem itemNovoLivro = new JMenuItem("Novo Livro");
            itemNovoLivro.addActionListener(e -> new CadastroLivro().setVisible(true));
           
        });
    }
}

