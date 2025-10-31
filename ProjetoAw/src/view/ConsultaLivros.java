package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ConsultaM;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConsultaLivros extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaLivros frame = new ConsultaLivros(null);
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
	public ConsultaLivros(List<ConsultaM> consulta) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 320);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Histórico de Consultas");

        contentPane = new JPanel();
        contentPane.setBackground(new Color(68, 68, 34));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Histórico de Consultas");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Century Gothic", Font.BOLD, 18));
        lblTitulo.setBounds(120, 25, 220, 25);
        contentPane.add(lblTitulo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 70, 320, 150);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        table.setRowHeight(25);
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Livro", "Usuário", "Data/Hora"}
        ));
        scrollPane.setViewportView(table);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // fecha a janela
            }
        });
        btnFechar.setFont(new Font("Century Gothic", Font.BOLD, 14));
        btnFechar.setBounds(180, 240, 100, 25);
        contentPane.add(btnFechar);

        // --- Preenche a tabela com os dados ---
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (consulta != null) {
            for (ConsultaM c : consulta) {
                model.addRow(new Object[]{
                    
                    
                });
            }
        }
    }

    
    }
