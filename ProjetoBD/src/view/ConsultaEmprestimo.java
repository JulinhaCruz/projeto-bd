package view;

import java.awt.EventQueue;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.CadastroEmprestimoM;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class ConsultaEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTable tableConsulta;
	private DefaultTableModel tableModel;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEmprestimo frame = new ConsultaEmprestimo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConsultaEmprestimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 143, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaEmprestimo = new JLabel("Consulta de Empréstimo");
		lblConsultaEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaEmprestimo.setForeground(Color.WHITE);
		lblConsultaEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultaEmprestimo.setBounds(97, 30, 234, 28);
		contentPane.add(lblConsultaEmprestimo);
		
		String[] colunas = {"Matrícula", "Senha", "Título"};
		tableModel = new DefaultTableModel(colunas, 0);
		tableConsulta = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(tableConsulta);
		scrollPane.setBounds(57, 85, 314, 127);
		contentPane.add(scrollPane);
		
		carregarDados();
	}


	private void carregarDados() {
		tableModel.setRowCount(0);
		ArrayList<CadastroEmprestimoM> lista = CadastroEmprestimoM.getListaEmprestimo();
		
		if(lista.isEmpty()) {
			return;
		}
		
		for(CadastroEmprestimoM emp : lista) {
			Object[] linha = {
					emp.getMatricula(), emp.getSenha(), emp.getTitulo()
					};
			tableModel.addRow(linha);
			}
		
		}
}
