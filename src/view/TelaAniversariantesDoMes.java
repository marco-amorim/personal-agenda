package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TelaAniversariantesDoMes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Object[] row = new Object[6];
	DefaultTableModel model;

	public TelaAniversariantesDoMes() {
		setTitle("Aniversariantes do M\u00EAs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(0, 0, 846, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(0, 40, 846, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblNewLabel_5 = new JLabel("ANIVERSARIANTES DO M\u00CAS");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 70, 846, 30);
		contentPane.add(lblNewLabel_5);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPrincipal tmp = new TelaMenuPrincipal();
				tmp.setVisible(true);
				tmp.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(730, 355, 87, 28);
		contentPane.add(btnVoltar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 112, 840, 231);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		Object[] columns = { "Nome", "Local de Trabalho", "Telefone", "Endereço", "Observação", "Data de Nascimento" };
		table.setModel(model);
		table.setRowHeight(30);
		model.setColumnIdentifiers(columns);

	}

	public DefaultTableModel getModel() {
		return model;
	}

}
