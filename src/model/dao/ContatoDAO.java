package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import db.DB;
import model.entities.Contato;

public class ContatoDAO {

	Connection conn = null;
	PreparedStatement st = null;
	Statement stmt = null;
	ResultSet rs = null;

	public void incluiContato(Contato cont) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			st = conn.prepareStatement("INSERT INTO contato (nome, localtrab, telefone, endereco, observacao, datanasc)"
					+ "VALUES(?, ?, ?, ?, ?, ?)");

			st.setString(1, cont.getNome());
			st.setString(2, cont.getLocalTrabalho());
			st.setString(3, cont.getTelefone());
			st.setString(4, cont.getEndereco());
			st.setString(5, cont.getObservacao());
			st.setDate(6, cont.getDataNasc());

			st.executeUpdate();

			JOptionPane.showMessageDialog(null, "Inclusão realizada com sucesso!", "Cadastro no Banco de Dados",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Por favor, preencha todos os campos corretamente!" + "\n \n"
							+ "Inclusão no banco de dados rejeitada!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void excluiContato(Contato cont) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DB.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {

			st = conn.prepareStatement("SELECT * FROM contato WHERE nome = ? AND dataNasc = ?");
			st.setString(1, cont.getNome());
			st.setDate(2, cont.getDataNasc());

			rs = st.executeQuery();

			if (rs.next() == false) {

				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			}

			st = conn.prepareStatement("DELETE FROM contato WHERE nome = ? AND dataNasc = ?");
			st.setString(1, cont.getNome());
			st.setDate(2, cont.getDataNasc());
			st.executeUpdate();

		} catch (SQLException e1) {

			JOptionPane.showMessageDialog(null,
					"Por favor, preencha todos os campos corretamente!" + "\n \n"
							+ "Exclusão no banco de dados rejeitada!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}

	}

}
