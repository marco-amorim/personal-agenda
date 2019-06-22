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

import dao.CompromissoDAO;
import entities.Compromisso;
import javax.swing.SwingConstants;

public class TelaExclusaoCompromisso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textHoraInicio;
	private JTextField textHoraTermino;

	public TelaExclusaoCompromisso() {
		setResizable(false);
		setTitle("Exclus\u00E3o de Compromisso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("DATA INICIO :");
		lblCadastro.setBounds(60, 160, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("HORA INICIO :");
		lblNewLabel.setBounds(60, 200, 200, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("HORA T\u00C9RMINO :");
		lblNewLabel_1.setBounds(60, 240, 200, 20);
		contentPane.add(lblNewLabel_1);

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

		JLabel lblCadastroDeContatos = new JLabel("EXCLUS\u00C3O DE COMPROMISSO");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
		contentPane.add(lblCadastroDeContatos);

		textDataInicio = new JTextField();
		textDataInicio.setBounds(170, 160, 200, 25);
		contentPane.add(textDataInicio);
		textDataInicio.setColumns(10);

		textHoraInicio = new JTextField();
		textHoraInicio.setBounds(170, 200, 200, 25);
		contentPane.add(textHoraInicio);
		textHoraInicio.setColumns(10);

		textHoraTermino = new JTextField();
		textHoraTermino.setBounds(170, 240, 200, 25);
		contentPane.add(textHoraTermino);
		textHoraTermino.setColumns(10);

		JButton btnIn = new JButton("OK");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Compromisso comp = new Compromisso();
				CompromissoDAO dao = new CompromissoDAO();

				SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

				java.util.Date dataInicio;
				java.util.Date horaInicio;
				java.util.Date horaTermino;
				java.sql.Date sqlDataInicio = null;
				java.sql.Time sqlHoraInicio = null;
				java.sql.Time sqlHoraTermino = null;

				try {
					dataInicio = sdfData.parse(textDataInicio.getText());
					horaInicio = sdfHora.parse(textHoraInicio.getText());
					horaTermino = sdfHora.parse(textHoraTermino.getText());
					sqlDataInicio = new java.sql.Date(dataInicio.getTime());
					sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
					sqlHoraTermino = new java.sql.Time(horaTermino.getTime());

				} catch (ParseException dateException) {

					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
							"Campos incorretos", JOptionPane.WARNING_MESSAGE);

				}

				comp.setDataInicio(sqlDataInicio);
				comp.setHoraInicio(sqlHoraInicio);
				comp.setHoraTermino(sqlHoraTermino);

				dao.excluiCompromisso(comp);

				dispose();
				TelaExclusaoCompromisso telaExclusaoCompromisso = new TelaExclusaoCompromisso();
				telaExclusaoCompromisso.setVisible(true);
				telaExclusaoCompromisso.setLocationRelativeTo(null);
			}
		});
		btnIn.setBounds(380, 320, 87, 28);
		contentPane.add(btnIn);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroCompromissos telaCadastroCompromissos = new TelaCadastroCompromissos();
				telaCadastroCompromissos.setVisible(true);
				telaCadastroCompromissos.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(380, 355, 87, 28);
		contentPane.add(btnVoltar);
	}
}
