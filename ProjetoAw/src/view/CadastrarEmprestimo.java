package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textFieldLivro;
	private JTextField textFieldData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarEmprestimo frame = new CadastrarEmprestimo();
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
	public CadastrarEmprestimo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 424, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 64, 64));
		contentPane.setForeground(new Color(128, 64, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Empréstimo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD, 21));
		lblNewLabel.setBounds(102, 20, 230, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblLivro = new JLabel("Livro desejado:");
		lblLivro.setForeground(new Color(255, 255, 255));
		lblLivro.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLivro.setBounds(148, 65, 126, 20);
		contentPane.add(lblLivro);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(148, 103, 126, 35);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblData = new JLabel("Data de empréstimo: ");
		lblData.setForeground(new Color(255, 255, 255));
		lblData.setFont(new Font("Arial", Font.PLAIN, 18));
		lblData.setBounds(132, 66, 173, 18);
		lblData.setVisible(false);
		contentPane.add(lblData);

		textFieldLivro = new JTextField();
		textFieldLivro.setBackground(new Color(192, 192, 192));
		textFieldLivro.setBounds(148, 103, 126, 35);
		contentPane.add(textFieldLivro);
		textFieldLivro.setColumns(10);
		
		JButton btnNewButton = new JButton("Próximo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		btnNewButton.setBounds(174, 165, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Arial", Font.PLAIN, 13));
		btnProximo.setBounds(174, 165, 85, 21);
		contentPane.add(btnProximo);
		if (btnNewButton != null) {
			 JOptionPane.showMessageDialog(this,"Você tem 45 dias para devolver este livro!");
		}
		
	}
}
