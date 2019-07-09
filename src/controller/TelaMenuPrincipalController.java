package controller;

import model.db.DB;
import view.TelaMenuPrincipal;

public class TelaMenuPrincipalController {

	TelaMenuPrincipal tmp;

	public TelaMenuPrincipalController() {

		tmp = new TelaMenuPrincipal();
		tmp.setVisible(true);
		tmp.setLocationRelativeTo(null);
		botaoCadastroContatos();
		botaoCadastroCompromissos();
		botaoCompromissosDoDia();
		botaoListaContatos();
		botaoAniversariantesDoMes();
		botaoFinalizar();

	}

	public void botaoCadastroContatos() {
		tmp.getBtnCadastroContatos().addActionListener(e -> {
			tmp.dispose();
			new TelaCadastroContatosController();
		});
	}

	public void botaoCadastroCompromissos() {
		tmp.getBtnCadastroCompromissos().addActionListener(e -> {
			tmp.dispose();
			new TelaCadastroCompromissosController();
		});
	}

	public void botaoCompromissosDoDia() {
		tmp.getBtnCompromissosDoDia().addActionListener(e -> {
			tmp.dispose();
			new TelaCompromissosDoDiaController();
		});
	}

	public void botaoListaContatos() {
		tmp.getBtnListaContatos().addActionListener(e -> {
			tmp.dispose();
			new TelaListaContatosController();
		});
	}

	public void botaoAniversariantesDoMes() {
		tmp.getBtnAniversariantesDoMes().addActionListener(e -> {
			tmp.dispose();
			new TelaAniversariantesDoMesController();
		});
	}

	public void botaoFinalizar() {
		tmp.getBtnFinalizar().addActionListener(e -> {
			tmp.dispose();
			DB.closeConnection();
			System.out.println("Conexão com o banco fechada!");
		});
	}

}
