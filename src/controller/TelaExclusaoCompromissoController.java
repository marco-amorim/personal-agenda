package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.CompromissoDAO;
import model.entities.Compromisso;
import view.TelaExclusaoCompromisso;

public class TelaExclusaoCompromissoController {

	TelaExclusaoCompromisso tec;

	public TelaExclusaoCompromissoController() {
		tec = new TelaExclusaoCompromisso();
		tec.setVisible(true);
		tec.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tec.getBtnOk().addActionListener(e -> {

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
				dataInicio = sdfData.parse(tec.getTextDataInicio());
				horaInicio = sdfHora.parse(tec.getTextHoraInicio());
				horaTermino = sdfHora.parse(tec.getTextHoraTermino());
				sqlDataInicio = new java.sql.Date(dataInicio.getTime());
				sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
				sqlHoraTermino = new java.sql.Time(horaTermino.getTime());

			} catch (ParseException dateException) {

				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);

			}

			comp.setDataInicio(sqlDataInicio);
			comp.setHoraInicio(sqlHoraInicio);
			comp.setHoraTermino(sqlHoraTermino);

			dao.excluiCompromisso(comp);

			tec.dispose();
			new TelaExclusaoCompromissoController();

		});
	}

	public void botaoVoltar() {
		tec.getBtnVoltar().addActionListener(e -> {
			tec.dispose();
			new TelaCadastroCompromissosController();

		});
	}

}
