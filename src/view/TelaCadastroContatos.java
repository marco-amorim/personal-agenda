package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaCadastroContatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnInclusao;
	private JButton btnAlteracao;
	private JButton btnConsulta;
	private JButton btnExclusao;
	private JButton btnRetornar;

	public TelaCadastroContatos() {
		setResizable(false);
		setTitle("Cadastro de Contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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

		JLabel lblCadastroDeContatos = new JLabel("CADASTRO DE CONTATOS");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
		contentPane.add(lblCadastroDeContatos);

		btnInclusao = new JButton("INCLUS\u00C3O");
		btnInclusao.setBounds(110, 130, 250, 30);
		contentPane.add(btnInclusao);

		btnAlteracao = new JButton("ALTERA\u00C7\u00C3O");
		btnAlteracao.setBounds(110, 170, 250, 30);
		contentPane.add(btnAlteracao);

		btnConsulta = new JButton("CONSULTA");
		btnConsulta.setBounds(110, 210, 250, 30);
		contentPane.add(btnConsulta);

		btnExclusao = new JButton("EXCLUS\u00C3O");
		btnExclusao.setBounds(110, 250, 250, 30);
		contentPane.add(btnExclusao);

		btnRetornar = new JButton("RETORNAR");
		btnRetornar.setBounds(110, 290, 250, 30);
		contentPane.add(btnRetornar);
	}

	public JButton getBtnInclusao() {
		return btnInclusao;
	}

	public JButton getBtnAlteracao() {
		return btnAlteracao;
	}

	public JButton getBtnConsulta() {
		return btnConsulta;
	}

	public JButton getBtnExclusao() {
		return btnExclusao;
	}

	public JButton getBtnRetornar() {
		return btnRetornar;
	}

}
