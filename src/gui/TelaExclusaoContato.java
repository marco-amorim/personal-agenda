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

public class TelaExclusaoContato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textDataNasc;
	private JTextField textConfirmaExclusao;
	private JTextField textNovaExclusao;

	public TelaExclusaoContato() {
		setResizable(false);
		setTitle("Exclus\u00E3o de Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("NOME :");
		lblCadastro.setBounds(60, 180, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel_3 = new JLabel("DATA DE NASCIMENTO :");
		lblNewLabel_3.setBounds(60, 220, 200, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(100, 0, 280, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(160, 40, 150, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("EXCLUS\u00C3O DE CONTATO");
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

		JLabel lblConfirmaIncluso = new JLabel("CONFIRMA EXCLUS\u00C3O ( S/N ) ?");
		lblConfirmaIncluso.setBounds(60, 320, 200, 20);
		contentPane.add(lblConfirmaIncluso);

		JLabel lblNewLabel_4 = new JLabel("NOVA EXCLUS\u00C3O ( S/N ) ?");
		lblNewLabel_4.setBounds(60, 350, 200, 20);
		contentPane.add(lblNewLabel_4);

		textConfirmaExclusao = new JTextField();
		textConfirmaExclusao.setBounds(258, 320, 112, 25);
		contentPane.add(textConfirmaExclusao);
		textConfirmaExclusao.setColumns(10);

		textNovaExclusao = new JTextField();
		textNovaExclusao.setBounds(258, 350, 112, 25);
		contentPane.add(textNovaExclusao);
		textNovaExclusao.setColumns(10);

		JButton btnIn = new JButton("OK");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textNovaExclusao.getText().equalsIgnoreCase("s")) {

					dispose();
					TelaExclusaoContato telaExclusaoContato = new TelaExclusaoContato();
					telaExclusaoContato.setVisible(true);

				} else if (textNovaExclusao.getText().equalsIgnoreCase("n")) {
					dispose();
					TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();
					telaCadastroContatos.setVisible(true);
				}

				if (textConfirmaExclusao.getText().equalsIgnoreCase("s")) {

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

					dao.excluiContato(cont);

				} else if (textConfirmaExclusao.getText().equalsIgnoreCase("n")) {

				}

			}
		});
		btnIn.setBounds(376, 346, 87, 28);
		contentPane.add(btnIn);
	}
}
