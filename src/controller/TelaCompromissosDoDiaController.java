package controller;

import model.dao.CompromissoDAO;
import view.TelaCompromissosDoDia;

public class TelaCompromissosDoDiaController {

	TelaCompromissosDoDia tcd;
	CompromissoDAO dao;

	public TelaCompromissosDoDiaController() {

		tcd = new TelaCompromissosDoDia();
		tcd.setVisible(true);
		tcd.setLocationRelativeTo(null);
		dao = new CompromissoDAO();
		dao.preencherListaCompromissos();
		dao.preencherTabelaListaCompromissos(tcd.getModel());
		botaoVoltar();

	}

	public void botaoVoltar() {
		tcd.getBtnVoltar().addActionListener(e -> {
			tcd.dispose();
			new TelaMenuPrincipalController();
		});
	}

}
