package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.db.DB;
import model.entities.Compromisso;

public class CompromissoDAO {

	Connection conn = null;
	boolean existeNoBanco = false;
	boolean alteracaoFeita = false;

	public void incluiCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement st = null;
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

			DB.closeStatement(st);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
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
			PreparedStatement st = null;
			ResultSet rs = null;

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

			DB.closeStatement(st);
			DB.closeResultSet(rs);
		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void consultaCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement st = null;
			ResultSet rs = null;

			st = conn.prepareStatement(
					"SELECT * FROM compromisso WHERE dataInicio = ? AND horaInicio = ? AND horaTermino = ?");
			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());
			rs = st.executeQuery();

			if (rs.next()) {
				JOptionPane.showMessageDialog(null,
						"Data inicio: " + rs.getDate("dataInicio") + "\n" + "Hora Inicio: " + rs.getTime("horaInicio")
								+ "\n" + "Hora Término: " + rs.getTime("horaTermino") + "\n" + "Local: "
								+ rs.getString("local") + "\n" + "Descrição: " + rs.getString("descricao") + "\n"
								+ "Observação: " + rs.getString("observacao"));
			} else {

				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			}

			DB.closeStatement(st);
			DB.closeResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Compromisso consultaAlteracaoCompromisso(Compromisso comp) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement st = null;
			ResultSet rs = null;

			st = conn.prepareStatement(
					"SELECT * FROM compromisso WHERE dataInicio = ? AND horaInicio = ? AND horaTermino = ?");

			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());

			rs = st.executeQuery();

			if (rs.next()) {

				existeNoBanco = true;
				JOptionPane.showMessageDialog(null,
						"Data inicio: " + rs.getDate("dataInicio") + "\n" + "Hora Inicio: " + rs.getTime("horaInicio")
								+ "\n" + "Hora Término: " + rs.getTime("horaTermino") + "\n" + "Local: "
								+ rs.getString("local") + "\n" + "Descrição: " + rs.getString("descricao") + "\n"
								+ "Observação: " + rs.getString("observacao"));

			} else {

				existeNoBanco = false;

			}

			DB.closeStatement(st);
			DB.closeResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comp;

	}

	public void alteracaoCompromisso(Compromisso comp, Compromisso compConsulta) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			PreparedStatement st = null;

			st = conn.prepareStatement(
					"UPDATE compromisso SET dataInicio = ?, horaInicio = ?, horaTermino = ?, local = ?, descricao = ?, observacao = ? WHERE dataInicio = ? AND horaInicio = ? AND horaTermino = ? ");
			st.setDate(1, comp.getDataInicio());
			st.setTime(2, comp.getHoraInicio());
			st.setTime(3, comp.getHoraTermino());
			st.setString(4, comp.getLocal());
			st.setString(5, comp.getDescricao());
			st.setString(6, comp.getObservacao());
			st.setDate(7, compConsulta.getDataInicio());
			st.setTime(8, compConsulta.getHoraInicio());
			st.setTime(9, compConsulta.getHoraTermino());
			st.execute();

			alteracaoFeita = true;

			DB.closeStatement(st);
		} catch (SQLException e) {

			alteracaoFeita = false;
		}

	}

	public boolean isExisteNoBanco() {
		return existeNoBanco;
	}

	public boolean isAlteracaoFeita() {
		return alteracaoFeita;
	}

}
