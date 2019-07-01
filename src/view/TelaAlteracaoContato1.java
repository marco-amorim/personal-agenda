package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaAlteracaoContato1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDataNasc;
	private JButton btnOk;
	private JButton btnVoltar;

	public TelaAlteracaoContato1() {
		setResizable(false);
		setTitle("Altera\u00E7\u00E3o de Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("NOME :");
		lblCadastro.setBounds(60, 180, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("DATA DE NASCIMENTO :");
		lblNewLabel.setBounds(60, 220, 200, 20);
		contentPane.add(lblNewLabel);

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

		JLabel lblCadastroDeContatos = new JLabel("INFORME OS DADOS DO CONTATO");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
		contentPane.add(lblCadastroDeContatos);

		textNome = new JTextField();
		textNome.setBounds(210, 180, 200, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(210, 220, 200, 25);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		btnOk = new JButton("OK");
		btnOk.setBounds(380, 320, 87, 28);
		contentPane.add(btnOk);

		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(380, 355, 87, 28);
		contentPane.add(btnVoltar);
	}

	public String getTextNome() {
		return textNome.getText();
	}

	public String getTextDataNasc() {
		return textDataNasc.getText();
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}
