package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import db.DB;
import model.entities.Compromisso;

public class CompromissoDAO {

	Connection conn = null;
	PreparedStatement st = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void incluiCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
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

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,
					"Por favor, preencha todos os campos corretamente!" + "\n \n"
							+ "Inclusão no banco de dados rejeitada!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void excluiCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			st = conn.prepareStatement(
					"SELECT * FROM compromisso WHERE dataInicio = ? AND horaInicio = ? AND horaTermino = ?");
			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());
			rs = st.executeQuery();

			if (rs.next() == false) {

				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			}

			st = conn.prepareStatement(
					"DELETE FROM compromisso WHERE dataInicio = ? AND horaInicio = ? AND horaTermino = ?");
			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());
			st.executeUpdate();

		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null,
					"Por favor, preencha todos os campos corretamente!" + "\n \n"
							+ "Exclusão no banco de dados rejeitada!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}

	}

}
