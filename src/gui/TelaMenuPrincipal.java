package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOpcao;

	public TelaMenuPrincipal() {
		setTitle("Menu Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("1 - CADASTRO DE CONTATOS");
		lblCadastro.setBounds(60, 140, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("2 - CADASTRO DE COMPROMISSOS");
		lblNewLabel.setBounds(60, 160, 229, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("3 - COMPROMISSOS DO DIA");
		lblNewLabel_1.setBounds(60, 180, 200, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("4 - LISTA DE CONTATOS");
		lblNewLabel_2.setBounds(60, 200, 200, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("5 - ANIVERSARIANTES DO M\u00CAS");
		lblNewLabel_3.setBounds(60, 220, 200, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("0 - FINALIZAR");
		lblNewLabel_4.setBounds(60, 240, 200, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblOpo = new JLabel("Op\u00E7\u00E3o:");
		lblOpo.setBounds(60, 300, 100, 30);
		contentPane.add(lblOpo);

		textOpcao = new JTextField();
		textOpcao.setBounds(100, 300, 100, 30);
		contentPane.add(textOpcao);
		textOpcao.setColumns(10);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(0, 0, 466, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(0, 40, 466, 30);
		contentPane.add(lblAgendaPessoal);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (textOpcao.getText()) {

				case "1":
					TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();
					telaCadastroContatos.setVisible(true);
					dispose();
					break;

				case "2":
					TelaCadastroCompromissos telaCadastroCompromissos = new TelaCadastroCompromissos();
					telaCadastroCompromissos.setVisible(true);
					dispose();
					break;

				case "0":
					dispose();
					break;

				default:
					JOptionPane.showMessageDialog(null, "Por favor, insira uma opção válida!");
					break;

				}

			}
		});
		btnNewButton.setBounds(205, 300, 100, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("MENU PRINCIPAL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 70, 466, 30);
		contentPane.add(lblNewLabel_5);

	}
}
