package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("Sistema Bibliotecário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(188, 143, 143));
		setJMenuBar(menuBar);
		
		JMenu menuCadastro = new JMenu("Cadastro");
		menuCadastro.setForeground(new Color(245, 255, 250));
		menuBar.add(menuCadastro);
		
		JMenuItem menuItemCadastro = new JMenuItem("Novo Cadastro");
		menuItemCadastro.setForeground(new Color(245, 255, 250));
		menuItemCadastro.setBackground(new Color(188, 143, 143));
		menuCadastro.add(menuItemCadastro);
		
		JMenu menuConsulta = new JMenu("Consulta");
		menuConsulta.setForeground(new Color(245, 255, 250));
		menuBar.add(menuConsulta);
		
		JMenuItem menuItemConsulta = new JMenuItem("Nova Consulta");
		menuItemConsulta.setForeground(new Color(245, 255, 250));
		menuItemConsulta.setBackground(new Color(188, 143, 143));
		menuConsulta.add(menuItemConsulta);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(82, 102, 254, 120);
		contentPane.add(table);
		
		JLabel labelLivrosDisponiveis = new JLabel("Livros Disponíveis");
		labelLivrosDisponiveis.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/livraria.png")));
		labelLivrosDisponiveis.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelLivrosDisponiveis.setForeground(new Color(245, 255, 250));
		labelLivrosDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivrosDisponiveis.setBounds(107, 59, 204, 33);
		contentPane.add(labelLivrosDisponiveis);
		
		JLabel labelInicial = new JLabel("Seja bem-vindo(a) à Biblioteca CJ!");
		labelInicial.setHorizontalAlignment(SwingConstants.CENTER);
		labelInicial.setForeground(new Color(245, 255, 250));
		labelInicial.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelInicial.setBounds(53, 36, 301, 13);
		contentPane.add(labelInicial);
	}
}
