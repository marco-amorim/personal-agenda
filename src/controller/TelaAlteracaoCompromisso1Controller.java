package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.CompromissoDAO;
import model.entities.Compromisso;
import view.TelaAlteracaoCompromisso1;

public class TelaAlteracaoCompromisso1Controller {

	TelaAlteracaoCompromisso1 tac1;

	public TelaAlteracaoCompromisso1Controller() {
		tac1 = new TelaAlteracaoCompromisso1();
		tac1.setVisible(true);
		tac1.setLocationRelativeTo(null);
		botaoOk();
		botaoVoltar();
	}

	public void botaoOk() {
		tac1.getBtnOk().addActionListener(e -> {

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
				dataInicio = sdfData.parse(tac1.getTextDataInicio());
				horaInicio = sdfHora.parse(tac1.getTextHoraInicio());
				horaTermino = sdfHora.parse(tac1.getTextHoraTermino());
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

			Compromisso compConsulta = new Compromisso();
			compConsulta = dao.consultaAlteracaoCompromisso(comp);

			if (dao.isExisteNoBanco() == true) {
				tac1.dispose();
				new TelaAlteracaoCompromisso2Controller(compConsulta);

			} else {
				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);

				tac1.dispose();
				new TelaAlteracaoCompromisso1Controller();
			}

		});
	}

	public void botaoVoltar() {
		tac1.getBtnVoltar().addActionListener(e -> {
			tac1.dispose();
			new TelaCadastroCompromissosController();
		});
	}

}
