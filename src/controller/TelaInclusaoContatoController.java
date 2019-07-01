package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.ContatoDAO;
import model.entities.Contato;
import view.TelaInclusaoContato;

public class TelaInclusaoContatoController {

	TelaInclusaoContato tic;
	ContatoDAO dao;
	Contato cont;

	public TelaInclusaoContatoController() {
		tic = new TelaInclusaoContato();
		tic.setVisible(true);
		tic.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tic.getBtnOk().addActionListener(e -> {
			cont = new Contato();
			dao = new ContatoDAO();

			SimpleDateFormat sdfDataNasc = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date dataNasc;
			java.sql.Date sqlDataNasc = null;

			try {
				dataNasc = sdfDataNasc.parse(tic.getTextDataNasc());
				sqlDataNasc = new java.sql.Date(dataNasc.getTime());
			} catch (ParseException e1) {

			}

			cont.setNome(tic.getTextNome());
			cont.setLocalTrabalho(tic.getTextLocalTrab());
			cont.setTelefone(tic.getTextTelefone());
			cont.setEndereco(tic.getTextEndereco());
			cont.setObservacao(tic.getTextObservacao());
			cont.setDataNasc(sqlDataNasc);

			dao.incluiContato(cont);

			tic.dispose();
			new TelaInclusaoContatoController();
		});
	}

	public void botaoVoltar() {
		tic.getBtnVoltar().addActionListener(e -> {
			tic.dispose();
			new TelaCadastroContatosController();
		});
	}

}
