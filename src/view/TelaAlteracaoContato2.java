package view;

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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.dao.ContatoDAO;
import model.entities.Contato;

public class TelaAlteracaoContato2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textLocalTrab;
	private JTextField textTelefone;
	private JTextField textEndereco;
	private JTextField textDataNasc;
	private JTextField textObservacao;

	public TelaAlteracaoContato2(Contato contConsulta) {
		setResizable(false);
		setTitle("Altera\u00E7\u00E3o de Contato");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastro = new JLabel("NOME :");
		lblCadastro.setBounds(60, 120, 200, 20);
		contentPane.add(lblCadastro);

		JLabel lblNewLabel = new JLabel("LOCAL DE TRABALHO :");
		lblNewLabel.setBounds(60, 150, 200, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TELEFONE :");
		lblNewLabel_1.setBounds(60, 180, 200, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ENDERE\u00C7O :");
		lblNewLabel_2.setBounds(60, 210, 200, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DATA DE NASCIMENTO :");
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

		JLabel lblCadastroDeContatos = new JLabel("INSIRA OS NOVOS DADOS PARA O CONTATO");
		lblCadastroDeContatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeContatos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCadastroDeContatos.setBounds(0, 70, 479, 30);
		contentPane.add(lblCadastroDeContatos);

		JLabel lblDataInicio = new JLabel("OBSERVA\u00C7\u00C3O :");
		lblDataInicio.setBounds(60, 270, 200, 20);
		contentPane.add(lblDataInicio);

		textNome = new JTextField();
		textNome.setBounds(210, 120, 200, 25);
		contentPane.add(textNome);
		textNome.setColumns(10);

		textLocalTrab = new JTextField();
		textLocalTrab.setBounds(210, 150, 200, 25);
		contentPane.add(textLocalTrab);
		textLocalTrab.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setBounds(210, 180, 200, 25);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setBounds(210, 210, 200, 25);
		contentPane.add(textEndereco);
		textEndereco.setColumns(10);

		textDataNasc = new JTextField();
		textDataNasc.setBounds(210, 240, 200, 25);
		contentPane.add(textDataNasc);
		textDataNasc.setColumns(10);

		textObservacao = new JTextField();
		textObservacao.setBounds(210, 270, 200, 25);
		contentPane.add(textObservacao);
		textObservacao.setColumns(10);

		JButton btnIn = new JButton("OK");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Contato cont = new Contato();
				ContatoDAO dao = new ContatoDAO();

				SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");

				java.util.Date dataNasc;
				java.sql.Date sqlDataNasc = null;

				try {
					dataNasc = sdfData.parse(textDataNasc.getText());
					sqlDataNasc = new java.sql.Date(dataNasc.getTime());
				} catch (ParseException dateException) {

				}

				cont.setNome(textNome.getText());
				cont.setLocalTrabalho(textLocalTrab.getText());
				cont.setTelefone(textTelefone.getText());
				cont.setEndereco(textEndereco.getText());
				cont.setObservacao(textObservacao.getText());
				cont.setDataNasc(sqlDataNasc);

				dao.alteracaoContato(cont, contConsulta);

				if (dao.isAlteracaoFeita() == true) {
					JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!",
							"Cadastro no Banco de Dados", JOptionPane.INFORMATION_MESSAGE);

					dispose();
					TelaAlteracaoContato1 tAC1 = new TelaAlteracaoContato1();
					tAC1.setVisible(true);
					tAC1.setLocationRelativeTo(null);

				} else {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
							"Campos incorretos", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnIn.setBounds(380, 320, 87, 28);
		contentPane.add(btnIn);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				TelaAlteracaoContato1 tAC1 = new TelaAlteracaoContato1();
				tAC1.setVisible(true);
				tAC1.setLocationRelativeTo(null);
			}
		});
		btnVoltar.setBounds(380, 355, 87, 28);
		contentPane.add(btnVoltar);
	}
}
