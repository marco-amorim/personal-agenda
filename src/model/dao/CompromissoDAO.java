package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import db.DB;
import model.entities.Compromisso;

public class CompromissoDAO {

	Connection conn = null;
	PreparedStatement st = null;

	public void incluiCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			st = conn.prepareStatement(
					"INSERT INTO compromisso (dataInicio, horaInicio, horaTermino, local, descricao, observacao)"
							+ "VALUES(?, ?, ?, ?, ?, ?)");
			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());
			st.setString(4, comp.getLocal());
			st.setString(5, comp.getDescricao());
			st.setString(6, comp.getObservacao());

			st.executeUpdate();

			JOptionPane.showMessageDialog(null, "Inclusão realizada com sucesso!", "Cadastro no Banco de Dados",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
		}

	}

}
