package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dao.ContatoDAO;
import model.entities.Contato;

public class TelaConsultaContato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDataNasc;
	private JTextField textConfirmaConsulta;
	private JTextField textNovaConsulta;

	public TelaConsultaContato() {
		setResizable(false);
		setTitle("Consulta de Contato");
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
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(100, 0, 280, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(160, 40, 150, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("CONSULTA DE CONTATO");
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(120, 70, 260, 30);
		contentPane.add(lblCadastroDeContatos);

		textNome = new JTextField();
		textNome.setBounds(210, 180, 200, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(210, 220, 200, 25);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		JLabel lblConfirmaIncluso = new JLabel("CONFIRMA CONSULTA ( S/N ) ?");
		lblConfirmaIncluso.setBounds(60, 320, 200, 20);
		contentPane.add(lblConfirmaIncluso);

		JLabel lblNewLabel_4 = new JLabel("NOVA CONSULTA ( S/N ) ?");
		lblNewLabel_4.setBounds(60, 350, 200, 20);
		contentPane.add(lblNewLabel_4);

		textConfirmaConsulta = new JTextField();
		textConfirmaConsulta.setBounds(258, 320, 112, 25);
		contentPane.add(textConfirmaConsulta);
		textConfirmaConsulta.setColumns(10);

		textNovaConsulta = new JTextField();
		textNovaConsulta.setBounds(258, 350, 112, 25);
		contentPane.add(textNovaConsulta);
		textNovaConsulta.setColumns(10);

		JButton btnIn = new JButton("OK");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNovaConsulta.getText().equalsIgnoreCase("s")) {
					dispose();
					TelaConsultaContato telaConsultaContato = new TelaConsultaContato();
					telaConsultaContato.setVisible(true);

				} else if (textNovaConsulta.getText().equalsIgnoreCase("n")) {
					dispose();
					TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();
					telaCadastroContatos.setVisible(true);

				}

				if (textConfirmaConsulta.getText().equalsIgnoreCase("s")) {

					Contato cont = new Contato();
					ContatoDAO dao = new ContatoDAO();

					SimpleDateFormat sdfDataNasc = new SimpleDateFormat("dd/MM/yyyy");

					java.util.Date dataNasc;
					java.sql.Date sqlDataNasc = null;

					try {
						dataNasc = sdfDataNasc.parse(textDataNasc.getText());
						sqlDataNasc = new java.sql.Date(dataNasc.getTime());
					} catch (ParseException e1) {

						JOptionPane.showMessageDialog(null,
								"Por favor, preencha todos os campos corretamente!" + "\n \n"
										+ "Exclusão no banco de dados rejeitada!",
								"Campos incorretos", JOptionPane.WARNING_MESSAGE);
					}

					cont.setNome(textNome.getText());
					cont.setDataNasc(sqlDataNasc);

					dao.consultaContato(cont);

				} else if (textConfirmaConsulta.getText().equalsIgnoreCase("n")) {

				}

			}
		});
		btnIn.setBounds(376, 346, 87, 28);
		contentPane.add(btnIn);
	}
}
