package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaCadastroContatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		JButton btnNewButton_1 = new JButton("INCLUS\u00C3O");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaInclusaoContato telaInclusaoContato = new TelaInclusaoContato();
				telaInclusaoContato.setVisible(true);
				telaInclusaoContato.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(110, 130, 250, 30);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("ALTERA\u00C7\u00C3O");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAlteracaoContato1 tAC1 = new TelaAlteracaoContato1();
				tAC1.setVisible(true);
				tAC1.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setBounds(110, 170, 250, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("CONSULTA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaConsultaContato telaConsultaContato = new TelaConsultaContato();
				telaConsultaContato.setVisible(true);
				telaConsultaContato.setLocationRelativeTo(null);
			}
		});
		btnNewButton_3.setBounds(110, 210, 250, 30);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("EXCLUS\u00C3O");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaExclusaoContato telaExclusaoContato = new TelaExclusaoContato();
				telaExclusaoContato.setVisible(true);
				telaExclusaoContato.setLocationRelativeTo(null);
			}
		});
		btnNewButton_4.setBounds(110, 250, 250, 30);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("RETORNAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaMenuPrincipal telaMenuPrincipal = new TelaMenuPrincipal();
				telaMenuPrincipal.setVisible(true);
				telaMenuPrincipal.setLocationRelativeTo(null);
			}
		});
		btnNewButton_5.setBounds(110, 290, 250, 30);
		contentPane.add(btnNewButton_5);
	}

}
