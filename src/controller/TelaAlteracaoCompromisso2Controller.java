package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.dao.CompromissoDAO;
import model.entities.Compromisso;
import view.TelaAlteracaoCompromisso2;

public class TelaAlteracaoCompromisso2Controller {

	TelaAlteracaoCompromisso2 tac2;

	public TelaAlteracaoCompromisso2Controller(Compromisso compConsulta) {
		tac2 = new TelaAlteracaoCompromisso2();
		tac2.setVisible(true);
		tac2.setLocationRelativeTo(null);
		botaoOk(compConsulta);
		botaoVoltar();
	}

	public void botaoOk(Compromisso compConsulta) {
		tac2.getBtnOk().addActionListener(e -> {

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
				dataInicio = sdfData.parse(tac2.getTextDataInicio());
				horaInicio = sdfHora.parse(tac2.getTextHoraInicio());
				horaTermino = sdfHora.parse(tac2.getTextHoraTermino());
				sqlDataInicio = new java.sql.Date(dataInicio.getTime());
				sqlHoraInicio = new java.sql.Time(horaInicio.getTime());
				sqlHoraTermino = new java.sql.Time(horaTermino.getTime());
			} catch (ParseException dateException) {

			}

			comp.setDataInicio(sqlDataInicio);
			comp.setHoraInicio(sqlHoraInicio);
			comp.setHoraTermino(sqlHoraTermino);
			comp.setLocal(tac2.getTextLocal());
			comp.setDescricao(tac2.getTextDescricao());
			comp.setObservacao(tac2.getTextObservacao());

			dao.alteracaoCompromisso(comp, compConsulta);

			if (dao.isAlteracaoFeita() == true) {
				JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);

				tac2.dispose();
				new TelaAlteracaoCompromisso1Controller();

			} else {
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
						"Campos incorretos", JOptionPane.WARNING_MESSAGE);
			}

		});

	}

	public void botaoVoltar() {
		tac2.getBtnVoltar().addActionListener(e -> {

			tac2.dispose();
			new TelaAlteracaoCompromisso1Controller();

		});
	}

}
