package controller;

import view.TelaCadastroCompromissos;

public class TelaCadastroCompromissosController {
	TelaCadastroCompromissos tcc;

	public TelaCadastroCompromissosController() {

		tcc = new TelaCadastroCompromissos();
		tcc.setVisible(true);
		tcc.setLocationRelativeTo(null);
		botaoInclusao();
		botaoAlteracao();
		botaoConsulta();
		botaoExclusao();
		botaoRetornar();

	}

	public void botaoInclusao() {
		tcc.getBtnInclusao().addActionListener(e -> {
			tcc.dispose();
			new TelaInclusaoCompromissoController();

		});
	}

	public void botaoAlteracao() {
		tcc.getBtnAlteracao().addActionListener(e -> {
			tcc.dispose();
			new TelaAlteracaoCompromisso1Controller();

		});
	}

	public void botaoConsulta() {
		tcc.getBtnConsulta().addActionListener(e -> {
			tcc.dispose();
			new TelaConsultaCompromissoController();

		});
	}

	public void botaoExclusao() {
		tcc.getBtnExclusao().addActionListener(e -> {
			tcc.dispose();
			new TelaExclusaoCompromissoController();

		});
	}

	public void botaoRetornar() {
		tcc.getBtnRetornar().addActionListener(e -> {
			tcc.dispose();
			new TelaMenuPrincipalController();

		});
	}

}
