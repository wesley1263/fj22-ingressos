package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {
	
	private Integer id;
	private Filme filme;
	private Sala sala;
	private LocalTime Horario;
	
	
	
	public Sessao(Integer id, Filme filme, Sala sala, LocalTime horario) {
		super();
		this.id = id;
		this.filme = filme;
		this.sala = sala;
		Horario = horario;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public LocalTime getHorario() {
		return Horario;
	}
	public void setHorario(LocalTime horario) {
		Horario = horario;
	}
	
	
	
	

}
