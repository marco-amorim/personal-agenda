package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.ContatoDAO;
import model.entities.Contato;
import view.TelaConsultaContato;

public class TelaConsultaContatoController {

	TelaConsultaContato tcc;

	public TelaConsultaContatoController() {

		tcc = new TelaConsultaContato();
		tcc.setVisible(true);
		tcc.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tcc.getBtnOk().addActionListener(e -> {

			Contato cont = new Contato();
			ContatoDAO dao = new ContatoDAO();

			SimpleDateFormat sdfDataNasc = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date dataNasc;
			java.sql.Date sqlDataNasc = null;

			try {
				dataNasc = sdfDataNasc.parse(tcc.getTextDataNasc());
				sqlDataNasc = new java.sql.Date(dataNasc.getTime());
			} catch (ParseException e1) {

				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);
			}

			cont.setNome(tcc.getTextNome());
			cont.setDataNasc(sqlDataNasc);

			dao.consultaContato(cont);

			tcc.dispose();
			new TelaConsultaContatoController();
		});
	}

	public void botaoVoltar() {
		tcc.getBtnVoltar().addActionListener(e -> {
			tcc.dispose();
			new TelaCadastroContatosController();

		});
	}

}
