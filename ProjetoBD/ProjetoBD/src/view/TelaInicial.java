package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
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
import javax.swing.table.DefaultTableModel;

import model.TelaInicialM;

import javax.swing.ListSelectionModel;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;



public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTable table;
	 private CadastroUser cadastroUser;
	 

	 public static void main(String[] args) {
		    EventQueue.invokeLater(() -> {
		        try {
		            TelaInicial frame = new TelaInicial();
		            frame.setVisible(true);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    });
		}


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
		
		JMenuItem menuItemCadastro = new JMenuItem("Novo User");
		menuItemCadastro.setForeground(new Color(245, 255, 250));
		menuItemCadastro.setBackground(new Color(188, 143, 143));
		menuCadastro.add(menuItemCadastro);
		
		JMenuItem menuItemCadastroEmprestimo = new JMenuItem("Novo Emprestimo");
		menuItemCadastroEmprestimo.setForeground(new Color(245, 255, 250));
		menuItemCadastroEmprestimo.setBackground(new Color(188, 143, 143));
		menuCadastro.add(menuItemCadastroEmprestimo);
		
		
		
		
		menuItemCadastro.addActionListener(e -> new CadastroUser().setVisible(true));
		menuItemCadastroEmprestimo.addActionListener(e -> new CadastroEmprestimo().setVisible(true));

		
		JMenu menuConsulta = new JMenu("Consulta");
		menuConsulta.setForeground(new Color(245, 255, 250));
		menuBar.add(menuConsulta);
		
		JMenuItem menuItemConsulta = new JMenuItem("Consultar Emprestimo");
		menuItemConsulta.setForeground(new Color(245, 255, 250));
		menuItemConsulta.setBackground(new Color(188, 143, 143));
		menuConsulta.add(menuItemConsulta);
		
		menuItemConsulta.addActionListener(e -> new ConsultaEmprestimo().setVisible(true));

		contentPane = new JPanel();
		contentPane.setBackground(new Color(160, 82, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		table = new JTable();
		table.setToolTipText("");
		table.setBackground(new Color(255, 255, 255));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setForeground(new Color(0, 0, 0));
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Titulo", "Genero", "Autor"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(96);
		table.getColumnModel().getColumn(1).setPreferredWidth(94);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		
		TelaInicialM modelLivros = new TelaInicialM();
		String[][] livros = modelLivros.getLivros();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (String[] livro : livros) {
		    model.addRow(livro);
		}
		

		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(64, 88, 301, 129);
		contentPane.add(scrollPane);
		
		
		
		JLabel labelLivrosDisponiveis = new JLabel("Livros Disponíveis");
		labelLivrosDisponiveis.setIcon(new ImageIcon(TelaInicial.class.getResource("/img/livraria.png")));
		labelLivrosDisponiveis.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelLivrosDisponiveis.setForeground(new Color(245, 255, 250));
		labelLivrosDisponiveis.setHorizontalAlignment(SwingConstants.CENTER);
		labelLivrosDisponiveis.setBounds(107, 45, 204, 33);
		contentPane.add(labelLivrosDisponiveis);
		
		JLabel labelInicial = new JLabel("Seja bem-vindo(a) à Biblioteca CJ!");
		labelInicial.setHorizontalAlignment(SwingConstants.CENTER);
		labelInicial.setForeground(new Color(245, 255, 250));
		labelInicial.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelInicial.setBounds(52, 22, 301, 13);
		contentPane.add(labelInicial);
		
	}
	}
	

