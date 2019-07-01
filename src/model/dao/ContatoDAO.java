package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.db.DB;
import model.entities.Contato;

public class ContatoDAO {

	Connection conn = null;
	PreparedStatement st = null;
	Statement stmt = null;
	ResultSet rs = null;
	boolean existeNoBanco = false;
	boolean alteracaoFeita = false;
	Contato cont;
	ArrayList<Contato> listaContatos = new ArrayList<>();

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
			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
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

			JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos corretamente!",
					"Campos incorretos", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void consultaContato(Contato cont) {

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

			if (rs.next()) {

				JOptionPane.showMessageDialog(null,
						"Nome: " + rs.getString("nome") + "\n" + "Data de Nascimento: " + rs.getDate("dataNasc") + "\n"
								+ "Local de Trabalho: " + rs.getString("localTrab") + "\n" + "Telefone: "
								+ rs.getString("telefone") + "\n" + "Endereço: " + rs.getString("endereco") + "\n"
								+ "Observação: " + rs.getString("observacao"));
			} else {

				JOptionPane.showMessageDialog(null, "Dados inexistentes!", "Cadastro no Banco de Dados",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Contato consultaAlteracaoContato(Contato cont) {

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

			st = conn.prepareStatement("SELECT * FROM contato WHERE nome = ? AND dataNasc = ?");

			st.setString(1, cont.getNome());
			st.setDate(2, cont.getDataNasc());

			rs = st.executeQuery();

			if (rs.next()) {

				existeNoBanco = true;
				JOptionPane.showMessageDialog(null,
						"Nome: " + rs.getString("nome") + "\n" + "Local de Trabalho: " + rs.getString("localTrab")
								+ "\n" + "Telefone: " + rs.getString("telefone") + "\n" + "Endereço: "
								+ rs.getString("endereco") + "\n" + "Observação: " + rs.getString("observacao") + "\n"
								+ "Data de Nascimento: " + rs.getDate("dataNasc"));

			} else {

				existeNoBanco = false;

			}

			DB.closeStatement(st);
			DB.closeResultSet(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cont;

	}

	public void alteracaoContato(Contato cont, Contato contConsulta) {

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
					"UPDATE contato SET nome = ?, localTrab = ?, telefone = ?, endereco = ?, observacao = ?, dataNasc = ? WHERE nome = ? AND dataNasc = ?");
			st.setString(1, cont.getNome());
			st.setString(2, cont.getLocalTrabalho());
			st.setString(3, cont.getTelefone());
			st.setString(4, cont.getEndereco());
			st.setString(5, cont.getObservacao());
			st.setDate(6, cont.getDataNasc());
			st.setString(7, contConsulta.getNome());
			st.setDate(8, contConsulta.getDataNasc());
			st.execute();

			alteracaoFeita = true;

			DB.closeStatement(st);
		} catch (SQLException e) {

			alteracaoFeita = false;
		}

	}

	public void preencherListaContatos() {

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
			st = conn.prepareStatement("SELECT * FROM contato");
			rs = st.executeQuery();

			while (rs.next()) {
				cont = new Contato(rs.getString("nome"), rs.getString("localTrab"), rs.getString("endereco"),
						rs.getString("observacao"), rs.getString("telefone"), rs.getDate("dataNasc"));
				listaContatos.add(cont);
			}

		} catch (SQLException e) {

		}
	}

	public void preencherTabelaListaContatos(DefaultTableModel model) {

		Object[] row = new Object[6];
		for (int i = 0; i < listaContatos.size(); i++) {
			row[0] = listaContatos.get(i).getNome();
			row[1] = listaContatos.get(i).getLocalTrabalho();
			row[2] = listaContatos.get(i).getTelefone();
			row[3] = listaContatos.get(i).getEndereco();
			row[4] = listaContatos.get(i).getObservacao();
			row[5] = listaContatos.get(i).getDataNasc();
			model.addRow(row);
		}
	}

	public void preencherListaAniversariantes() {

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
			st = conn.prepareStatement("SELECT * FROM contato WHERE MONTH(dataNasc) = MONTH(CURRENT_DATE());");
			rs = st.executeQuery();

			while (rs.next()) {
				cont = new Contato(rs.getString("nome"), rs.getString("localTrab"), rs.getString("endereco"),
						rs.getString("observacao"), rs.getString("telefone"), rs.getDate("dataNasc"));
				listaContatos.add(cont);
			}

		} catch (SQLException e) {

		}
	}

	public boolean isExisteNoBanco() {
		return existeNoBanco;
	}

	public boolean isAlteracaoFeita() {
		return alteracaoFeita;
	}

}
