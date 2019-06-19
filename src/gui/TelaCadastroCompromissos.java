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

public class TelaCadastroCompromissos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textOpcao;

	public TelaCadastroCompromissos() {
		setResizable(false);
		setTitle("Cadastro de Compromissos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("1 - INCLUS\u00C3O");
		lblCadastro.setBounds(60, 140, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("2 - ALTERA\u00C7\u00C3O");
		lblNewLabel.setBounds(60, 160, 200, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("3 - CONSULTA");
		lblNewLabel_1.setBounds(60, 180, 200, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("4 - EXCLUS\u00C3O");
		lblNewLabel_2.setBounds(60, 200, 200, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("0 - RETORNAR");
		lblNewLabel_3.setBounds(60, 220, 200, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblOpo = new JLabel("Op\u00E7\u00E3o:");
		lblOpo.setBounds(60, 300, 100, 30);
		contentPane.add(lblOpo);

		textOpcao = new JTextField();
		textOpcao.setBounds(100, 300, 100, 30);
		contentPane.add(textOpcao);
		textOpcao.setColumns(10);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(100, 0, 280, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(160, 40, 150, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("CADASTRO DE COMPROMISSOS");
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(120, 70, 260, 30);
		contentPane.add(lblCadastroDeContatos);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (textOpcao.getText()) {

				case "0":

					dispose();
					TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
					telaMenuPrincipal.setVisible(true);

					break;

				case "1":

					dispose();
					TelaInclusaoCompromisso telaInclusaoCompromisso = new TelaInclusaoCompromisso();
					telaInclusaoCompromisso.setVisible(true);

					break;

				case "2":

					dispose();
					TelaAlteracaoCompromisso1 tAC1 = new TelaAlteracaoCompromisso1();
					tAC1.setVisible(true);
					break;

				case "3":

					dispose();
					TelaConsultaCompromisso telaConsultaCompromisso = new TelaConsultaCompromisso();
					telaConsultaCompromisso.setVisible(true);

					break;
				case "4":

					dispose();
					TelaExclusaoCompromisso telaExclusaoCompromisso = new TelaExclusaoCompromisso();
					telaExclusaoCompromisso.setVisible(true);

					break;

				default:
					JOptionPane.showMessageDialog(null, "Por favor, insira uma opção válida!");
				}

			}
		});
		btnNewButton.setBounds(205, 300, 100, 30);
		contentPane.add(btnNewButton);
	}

}
