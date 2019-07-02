package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaAlteracaoCompromisso2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDataInicio;
	private JTextField textHoraInicio;
	private JTextField textHoraTermino;
	private JTextField textDescricao;
	private JTextField textLocal;
	private JTextField textObservacao;
	private JButton btnOk;
	private JButton btnVoltar;

	public TelaAlteracaoCompromisso2() {
		setResizable(false);
		setTitle("Altera\u00E7\u00E3o de Compromisso");
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
		lblXyzComercioDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(0, 0, 479, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(0, 40, 479, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblCadastroDeContatos = new JLabel("INSIRA OS NOVOS DADOS PARA O COMPROMISSO");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
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

		btnOk = new JButton("OK");
		btnOk.setBounds(380, 320, 87, 28);
		contentPane.add(btnOk);

		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setBounds(380, 355, 87, 28);
		contentPane.add(btnVoltar);
	}

	public String getTextDataInicio() {
		return textDataInicio.getText();
	}

	public String getTextHoraInicio() {
		return textHoraInicio.getText();
	}

	public String getTextHoraTermino() {
		return textHoraTermino.getText();
	}

	public String getTextDescricao() {
		return textDescricao.getText();
	}

	public String getTextLocal() {
		return textLocal.getText();
	}

	public String getTextObservacao() {
		return textObservacao.getText();
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

}
