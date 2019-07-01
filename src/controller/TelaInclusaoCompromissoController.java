package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.CompromissoDAO;
import model.entities.Compromisso;
import view.TelaInclusaoCompromisso;

public class TelaInclusaoCompromissoController {

	TelaInclusaoCompromisso tic;

	public TelaInclusaoCompromissoController() {
		tic = new TelaInclusaoCompromisso();
		tic.setVisible(true);
		tic.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();

	}

	public void botaoOk() {
		tic.getBtnOk().addActionListener(e -> {
			Compromisso comp = new Compromisso();
			CompromissoDAO dao = new CompromissoDAO();

			SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

			java.util.Date dataInicio;
			java.util.Date horaInicio;
			java.util.Date horaTermino;
			java.sql.Date sqlDataInicio = null;
			java.sql.Time sqlHoraInicio = null;
			java.sql.Time sqlHoraTermino = null;

			try {
				dataInicio = sdfData.parse(tic.getTextDataInicio());
				horaInicio = sdfHora.parse(tic.getTextHoraInicio());
				horaTermino = sdfHora.parse(tic.getTextHoraTermino());
				sqlDataInicio = new java.sql.Date(dataInicio.getTime());
				sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
				sqlHoraTermino = new java.sql.Time(horaTermino.getTime());
			} catch (ParseException dateException) {

			}

			comp.setDataInicio(sqlDataInicio);
			comp.setHoraInicio(sqlHoraInicio);
			comp.setHoraTermino(sqlHoraTermino);
			comp.setLocal(tic.getTextLocal());
			comp.setDescricao(tic.getTextDescricao());
			comp.setObservacao(tic.getTextObservacao());

			dao.incluiCompromisso(comp);

			tic.dispose();
			new TelaInclusaoCompromissoController();

		});
	}

	public void botaoVoltar() {
		tic.getBtnVoltar().addActionListener(e -> {
			tic.dispose();
			new TelaCadastroCompromissosController();
		});
	}

}
