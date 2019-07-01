package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCadastroContatos;
	private JButton btnCadastroCompromissos;
	private JButton btnCompromissosDoDia;
	private JButton btnListaContatos;
	private JButton btnFinalizar;
	private JButton btnAniversariantesDoMes;

	public TelaMenuPrincipal() {
		setTitle("Menu Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblXyzComercioDe = new JLabel("XYZ COMERCIO DE PRODUTOS LTDA.");
		lblXyzComercioDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblXyzComercioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXyzComercioDe.setBounds(0, 0, 466, 40);
		contentPane.add(lblXyzComercioDe);

		JLabel lblAgendaPessoal = new JLabel("AGENDA PESSOAL");
		lblAgendaPessoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgendaPessoal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAgendaPessoal.setBounds(0, 40, 466, 30);
		contentPane.add(lblAgendaPessoal);

		JLabel lblNewLabel_5 = new JLabel("MENU PRINCIPAL");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 70, 466, 30);
		contentPane.add(lblNewLabel_5);

		btnCadastroContatos = new JButton("CADASTRO DE CONTATOS");
		btnCadastroContatos.setBounds(110, 130, 250, 30);
		contentPane.add(btnCadastroContatos);

		btnCadastroCompromissos = new JButton("CADASTRO DE COMPROMISSOS");
		btnCadastroCompromissos.setBounds(110, 170, 250, 30);
		contentPane.add(btnCadastroCompromissos);

		btnCompromissosDoDia = new JButton("COMPROMISSOS DO DIA");
		btnCompromissosDoDia.setBounds(110, 210, 250, 30);
		contentPane.add(btnCompromissosDoDia);

		btnListaContatos = new JButton("LISTA DE CONTATOS");
		btnListaContatos.setBounds(110, 250, 250, 30);
		contentPane.add(btnListaContatos);

		btnFinalizar = new JButton("FINALIZAR");
		btnFinalizar.setBounds(110, 330, 250, 30);
		contentPane.add(btnFinalizar);

		btnAniversariantesDoMes = new JButton("ANIVERSARIANTES DO M\u00CAS");
		btnAniversariantesDoMes.setBounds(110, 290, 250, 30);
		contentPane.add(btnAniversariantesDoMes);

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnCadastroContatos() {
		return btnCadastroContatos;
	}

	public JButton getBtnCadastroCompromissos() {
		return btnCadastroCompromissos;
	}

	public JButton getBtnCompromissosDoDia() {
		return btnCompromissosDoDia;
	}

	public JButton getBtnListaContatos() {
		return btnListaContatos;
	}

	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}

	public JButton getBtnAniversariantesDoMes() {
		return btnAniversariantesDoMes;
	}

}
