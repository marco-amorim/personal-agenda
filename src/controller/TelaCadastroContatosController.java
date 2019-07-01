package controller;

import view.TelaCadastroContatos;

public class TelaCadastroContatosController {

	TelaCadastroContatos tcc;

	public TelaCadastroContatosController() {

		tcc = new TelaCadastroContatos();
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
			new TelaInclusaoContatoController();
		});
	}

	public void botaoAlteracao() {
		tcc.getBtnAlteracao().addActionListener(e -> {
			tcc.dispose();
			new TelaAlteracaoContato1Controller();
		});
	}

	public void botaoConsulta() {
		tcc.getBtnConsulta().addActionListener(e -> {
			tcc.dispose();
			new TelaConsultaContatoController();
		});
	}

	public void botaoExclusao() {
		tcc.getBtnExclusao().addActionListener(e -> {
			tcc.dispose();
			new TelaExclusaoContatoController();
		});
	}

	public void botaoRetornar() {
		tcc.getBtnRetornar().addActionListener(e -> {
			tcc.dispose();
			new TelaMenuPrincipalController();
		});
	}

}
