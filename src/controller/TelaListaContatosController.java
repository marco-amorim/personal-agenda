package controller;

import model.dao.ContatoDAO;
import view.TelaListaContatos;

public class TelaListaContatosController {

	TelaListaContatos tlc;
	ContatoDAO dao;

	public TelaListaContatosController() {

		tlc = new TelaListaContatos();
		tlc.setVisible(true);
		tlc.setLocationRelativeTo(null);
		dao = new ContatoDAO();
		dao.preencherListaContatos();
		dao.preencherTabelaListaContatos(tlc.getModel());
		botaoVoltar();
	}

	public void botaoVoltar() {
		tlc.getBtnVoltar().addActionListener(e -> {
			tlc.dispose();
			new TelaMenuPrincipalController();
		});
	}

}
