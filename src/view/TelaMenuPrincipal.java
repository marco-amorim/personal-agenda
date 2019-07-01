package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.dao.CompromissoDAO;
import model.dao.ContatoDAO;

public class TelaMenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		JButton btnNewButton_1 = new JButton("CADASTRO DE CONTATOS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();
				telaCadastroContatos.setVisible(true);
				telaCadastroContatos.setLocationRelativeTo(null);

			}
		});
		btnNewButton_1.setBounds(110, 130, 250, 30);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("CADASTRO DE COMPROMISSOS");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroCompromissos telaCadastroCompromissos = new TelaCadastroCompromissos();
				telaCadastroCompromissos.setVisible(true);
				telaCadastroCompromissos.setLocationRelativeTo(null);

			}
		});
		btnNewButton_2.setBounds(110, 170, 250, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("COMPROMISSOS DO DIA");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCompromissosDoDia tcd = new TelaCompromissosDoDia();
				CompromissoDAO dao = new CompromissoDAO();
				tcd.setVisible(true);
				tcd.setLocationRelativeTo(null);
				dao.preencherListaCompromissos();
				dao.preencherTabelaListaCompromissos(tcd.getModel());

			}
		});
		btnNewButton_3.setBounds(110, 210, 250, 30);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("LISTA DE CONTATOS");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaListaContatos tlc = new TelaListaContatos();
				ContatoDAO dao = new ContatoDAO();
				tlc.setVisible(true);
				tlc.setLocationRelativeTo(null);
				dao.preencherListaContatos();
				dao.preencherTabelaListaContatos(tlc.getModel());

			}
		});
		btnNewButton_4.setBounds(110, 250, 250, 30);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("FINALIZAR");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_5.setBounds(110, 330, 250, 30);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("ANIVERSARIANTES DO M\u00CAS");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAniversariantesDoMes tam = new TelaAniversariantesDoMes();
				ContatoDAO dao = new ContatoDAO();
				tam.setVisible(true);
				tam.setLocationRelativeTo(null);
				dao.preencherListaAniversariantes();
				dao.preencherTabelaListaContatos(tam.getModel());
			}
		});
		btnNewButton_6.setBounds(110, 290, 250, 30);
		contentPane.add(btnNewButton_6);

	}

}
