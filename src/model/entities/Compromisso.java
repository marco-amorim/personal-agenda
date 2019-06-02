package model.entities;

import java.sql.Date;
import java.sql.Time;

public class Compromisso {

	private Date dataInicio;
	private Time horaInicio, HoraTermino;
	private String descricao, local, observacao;

	public Compromisso() {

	}

	public Compromisso(Date dataInicio, Time horaInicio, Time horaTermino, String descricao, String local,
			String observacao) {
		super();
		this.dataInicio = dataInicio;
		this.horaInicio = horaInicio;
		HoraTermino = horaTermino;
		this.descricao = descricao;
		this.local = local;
		this.observacao = observacao;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Time getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Time getHoraTermino() {
		return HoraTermino;
	}

	public void setHoraTermino(Time horaTermino) {
		HoraTermino = horaTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
