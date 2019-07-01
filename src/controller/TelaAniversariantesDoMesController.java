package controller;

import model.dao.ContatoDAO;
import view.TelaAniversariantesDoMes;

public class TelaAniversariantesDoMesController {

	TelaAniversariantesDoMes tam;
	ContatoDAO dao;

	public TelaAniversariantesDoMesController() {

		tam = new TelaAniversariantesDoMes();
		dao = new ContatoDAO();
		tam.setVisible(true);
		tam.setLocationRelativeTo(null);
		dao.preencherListaAniversariantes();
		dao.preencherTabelaListaContatos(tam.getModel());
		botaoVoltar();
	}

	public void botaoVoltar() {
		tam.getBtnVoltar().addActionListener(e -> {
			tam.dispose();
			new TelaMenuPrincipalController();
		});
	}
}
