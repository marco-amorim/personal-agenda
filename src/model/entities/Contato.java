package model.entities;

import java.sql.Date;

public class Contato {

	private String nome, localTrabalho, endereco, observacao, telefone;
	private Date dataNasc;

	public Contato() {

	}

	public Contato(String nome, String localTrabalho, String endereco, String observacao, String telefone,
			Date dataNasc) {

		this.nome = nome;
		this.localTrabalho = localTrabalho;
		this.endereco = endereco;
		this.observacao = observacao;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

}
