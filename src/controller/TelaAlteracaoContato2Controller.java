package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.ContatoDAO;
import model.entities.Contato;
import view.TelaAlteracaoContato2;

public class TelaAlteracaoContato2Controller {

	TelaAlteracaoContato2 tac2;

	public TelaAlteracaoContato2Controller(Contato contConsulta) {
		tac2 = new TelaAlteracaoContato2();
		tac2.setVisible(true);
		tac2.setLocationRelativeTo(null);
		botaoOk(contConsulta);
		botaoVoltar();
	}

	public void botaoOk(Contato contConsulta) {
		tac2.getBtnOk().addActionListener(e -> {

			Contato cont = new Contato();
			ContatoDAO dao = new ContatoDAO();

			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date dataNasc;
			java.sql.Date sqlDataNasc = null;

			try {
				dataNasc = sdfData.parse(tac2.getTextDataNasc());
				sqlDataNasc = new java.sql.Date(dataNasc.getTime());
			} catch (ParseException dateException) {

			}

			cont.setNome(tac2.getTextNome());
			cont.setLocalTrabalho(tac2.getTextLocalTrab());
			cont.setTelefone(tac2.getTextTelefone());
			cont.setEndereco(tac2.getTextEndereco());
			cont.setObservacao(tac2.getTextObservacao());
			cont.setDataNasc(sqlDataNasc);

			dao.alteracaoContato(cont, contConsulta);

			if (dao.isAlteracaoFeita() == true) {
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);

				tac2.dispose();
				new TelaAlteracaoContato1Controller();

			} else {
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);
			}

		});
	}

	public void botaoVoltar() {
		tac2.getBtnVoltar().addActionListener(e -> {
			tac2.dispose();
			new TelaAlteracaoContato1Controller();
		});
	}

}
