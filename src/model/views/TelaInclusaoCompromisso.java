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

public class TelaInclusaoCompromisso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textHoraInicio;
	private JTextField textHoraTermino;
	private JTextField textDescricao;
	private JTextField textLocal;
	private JTextField textObservacao;
	private JTextField textConfirmaInclusao;
	private JTextField textNovaInclusao;

	public TelaInclusaoCompromisso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("DATA INICIO :");
		lblCadastro.setBounds(60, 120, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("HORA INICIO :");
		lblNewLabel.setBounds(60, 150, 200, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("HORA T\u00C9RMINO :");
		lblNewLabel_1.setBounds(60, 180, 200, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("DESCRI\u00C7\u00C3O :");
		lblNewLabel_2.setBounds(60, 210, 200, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("LOCAL :");
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

		JLabel lblCadastroDeContatos = new JLabel("INCLUS\u00C3O DE COMPROMISSO");
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(120, 70, 260, 30);
		contentPane.add(lblCadastroDeContatos);

		JLabel lblDataInicio = new JLabel("OBSERVA\u00C7\u00C3O :");
		lblDataInicio.setBounds(60, 270, 200, 20);
		contentPane.add(lblDataInicio);

		textDataInicio = new JTextField();
		textDataInicio.setBounds(170, 120, 200, 25);
		contentPane.add(textDataInicio);
		textDataInicio.setColumns(10);

		textHoraInicio = new JTextField();
		textHoraInicio.setBounds(170, 150, 200, 25);
		contentPane.add(textHoraInicio);
		textHoraInicio.setColumns(10);

		textHoraTermino = new JTextField();
		textHoraTermino.setBounds(170, 180, 200, 25);
		contentPane.add(textHoraTermino);
		textHoraTermino.setColumns(10);

		textDescricao = new JTextField();
		textDescricao.setBounds(170, 210, 200, 25);
		contentPane.add(textDescricao);
		textDescricao.setColumns(10);

		textLocal = new JTextField();
		textLocal.setBounds(170, 240, 200, 25);
		contentPane.add(textLocal);
		textLocal.setColumns(10);

		textObservacao = new JTextField();
		textObservacao.setBounds(170, 270, 200, 25);
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

					TelaInclusaoCompromisso telaInclusaoCompromisso = new TelaInclusaoCompromisso();
					telaInclusaoCompromisso.setVisible(true);
					dispose();

				} else if (textNovaInclusao.getText().equalsIgnoreCase("n")) {
					TelaCadastroCompromissos telaCadastroCompromissos = new TelaCadastroCompromissos();
					telaCadastroCompromissos.setVisible(true);
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
