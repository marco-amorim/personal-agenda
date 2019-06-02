package model.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaInclusaoContato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textLocalTrab;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private JTextField textDataNasc;
	private JTextField textObservacao;
	private JTextField textConfirmaInclusao;
	private JTextField textNovaInclusao;

	public TelaInclusaoContato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("NOME :");
		lblCadastro.setBounds(60, 120, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("LOCAL DE TRABALHO :");
		lblNewLabel.setBounds(60, 150, 200, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TELEFONE :");
		lblNewLabel_1.setBounds(60, 180, 200, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O :");
		lblNewLabel_2.setBounds(60, 210, 200, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DATA DE NASCIMENTO :");
		lblNewLabel_3.setBounds(60, 240, 200, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(100, 0, 280, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(160, 40, 150, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("INCLUS\u00C3O DE CONTATO");
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(120, 70, 260, 30);
		contentPane.add(lblCadastroDeContatos);

		JLabel lblDataInicio = new JLabel("OBSERVA\u00C7\u00C3O :");
		lblDataInicio.setBounds(60, 270, 200, 20);
		contentPane.add(lblDataInicio);

		textNome = new JTextField();
		textNome.setBounds(210, 120, 200, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textLocalTrab = new JTextField();
		textLocalTrab.setBounds(210, 150, 200, 25);
		contentPane.add(textLocalTrab);
		textLocalTrab.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setBounds(210, 180, 200, 25);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(210, 210, 200, 25);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(210, 240, 200, 25);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		textObservacao = new JTextField();
		textObservacao.setBounds(210, 270, 200, 25);
		contentPane.add(textObservacao);
		textObservacao.setColumns(10);

		JLabel lblConfirmaIncluso = new JLabel("CONFIRMA INCLUS\u00C3O ( S/N ) ?");
		lblConfirmaIncluso.setBounds(60, 320, 200, 20);
		contentPane.add(lblConfirmaIncluso);

		JLabel lblNewLabel_4 = new JLabel("NOVA INCLUS\u00C3O ( S/N ) ?");
		lblNewLabel_4.setBounds(60, 350, 200, 20);
		contentPane.add(lblNewLabel_4);

		textConfirmaInclusao = new JTextField();
		textConfirmaInclusao.setBounds(258, 320, 112, 25);
		contentPane.add(textConfirmaInclusao);
		textConfirmaInclusao.setColumns(10);

		textNovaInclusao = new JTextField();
		textNovaInclusao.setBounds(258, 350, 112, 25);
		contentPane.add(textNovaInclusao);
		textNovaInclusao.setColumns(10);

		JButton btnIn = new JButton("OK");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNovaInclusao.getText().equalsIgnoreCase("s")) {

					TelaInclusaoContato telaInclusaoContato = new TelaInclusaoContato();
					telaInclusaoContato.setVisible(true);
					dispose();

				} else if (textNovaInclusao.getText().equalsIgnoreCase("n")) {
					TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();
					telaCadastroContatos.setVisible(true);
					dispose();
				}

				if (textConfirmaInclusao.getText().equalsIgnoreCase("s")) {

					System.out.println("Implementação para o banco!");

				} else if (textConfirmaInclusao.getText().equalsIgnoreCase("n")) {

				}

			}
		});
		btnIn.setBounds(376, 346, 87, 28);
		contentPane.add(btnIn);
	}
}
