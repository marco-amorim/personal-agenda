package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.CompromissoDAO;
import model.entities.Compromisso;
import view.TelaConsultaCompromisso;

public class TelaConsultaCompromissoController {

	TelaConsultaCompromisso tcc;

	public TelaConsultaCompromissoController() {

		tcc = new TelaConsultaCompromisso();
		tcc.setVisible(true);
		tcc.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tcc.getBtnOk().addActionListener(e -> {

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
				dataInicio = sdfData.parse(tcc.getTextDataInicio());
				horaInicio = sdfHora.parse(tcc.getTextHoraInicio());
				horaTermino = sdfHora.parse(tcc.getTextHoraTermino());
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

			dao.consultaCompromisso(comp);

			tcc.dispose();
			new TelaConsultaCompromissoController();
		});
	}

	public void botaoVoltar() {
		tcc.getBtnVoltar().addActionListener(e -> {

			tcc.dispose();
			new TelaCadastroCompromissosController();
		});
	}
}
