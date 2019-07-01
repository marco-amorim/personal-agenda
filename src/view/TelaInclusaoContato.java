package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JButton btnOk;
	private JButton btnVoltar;

	public TelaInclusaoContato() {
		setResizable(false);
		setTitle("Inclus\u00E3o de Contato");
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
		lblXyzComercioDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(0, 0, 479, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(0, 40, 479, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("INCLUS\u00C3O DE CONTATO");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
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

		btnOk = new JButton("OK");
		btnOk.setBounds(380, 320, 87, 28);
		contentPane.add(btnOk);

		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(380, 355, 87, 28);
		contentPane.add(btnVoltar);
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public String getTextNome() {
		return textNome.getText();
	}

	public String getTextLocalTrab() {
		return textLocalTrab.getText();
	}

	public String getTextTelefone() {
		return textTelefone.getText();
	}

	public String getTextEndereco() {
		return textEndereco.getText();
	}

	public String getTextDataNasc() {
		return textDataNasc.getText();
	}

	public String getTextObservacao() {
		return textObservacao.getText();
	}

}
