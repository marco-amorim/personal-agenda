package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.ContatoDAO;
import model.entities.Contato;
import view.TelaAlteracaoContato1;

public class TelaAlteracaoContato1Controller {

	TelaAlteracaoContato1 tac1;

	public TelaAlteracaoContato1Controller() {
		tac1 = new TelaAlteracaoContato1();
		tac1.setVisible(true);
		tac1.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tac1.getBtnOk().addActionListener(e -> {

			Contato cont = new Contato();
			ContatoDAO dao = new ContatoDAO();

			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date dataNasc;
			java.sql.Date sqlDataNasc = null;

			try {
				dataNasc = sdfData.parse(tac1.getTextDataNasc());
				sqlDataNasc = new java.sql.Date(dataNasc.getTime());
			} catch (ParseException dateException) {

				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);

			}

			cont.setNome(tac1.getTextNome());
			cont.setDataNasc(sqlDataNasc);

			Contato contConsulta = new Contato();
			contConsulta = dao.consultaAlteracaoContato(cont);

			if (dao.isExisteNoBanco() == true) {
				tac1.dispose();
				new TelaAlteracaoContato2Controller(contConsulta);

			} else {
				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);

				tac1.dispose();
				new TelaAlteracaoContato1Controller();
			}

		});
	}

	public void botaoVoltar() {
		tac1.getBtnVoltar().addActionListener(e -> {
			tac1.dispose();
			new TelaCadastroContatosController();
		});
	}

}
