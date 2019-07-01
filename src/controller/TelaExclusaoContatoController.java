package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.ContatoDAO;
import model.entities.Contato;
import view.TelaExclusaoContato;

public class TelaExclusaoContatoController {

	TelaExclusaoContato tec;

	public TelaExclusaoContatoController() {
		tec = new TelaExclusaoContato();
		tec.setVisible(true);
		tec.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tec.getBtnOk().addActionListener(e -> {

			Contato cont = new Contato();
			ContatoDAO dao = new ContatoDAO();

			SimpleDateFormat sdfDataNasc = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date dataNasc;
			java.sql.Date sqlDataNasc = null;

			try {
				dataNasc = sdfDataNasc.parse(tec.getTextDataNasc());
				sqlDataNasc = new java.sql.Date(dataNasc.getTime());
			} catch (ParseException e1) {

				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);
			}

			cont.setNome(tec.getTextNome());
			cont.setDataNasc(sqlDataNasc);

			dao.excluiContato(cont);

			tec.dispose();
			new TelaExclusaoContatoController();
		});
	}

	public void botaoVoltar() {
		tec.getBtnVoltar().addActionListener(e -> {

			tec.dispose();
			new TelaCadastroContatosController();
		});
	}
}
