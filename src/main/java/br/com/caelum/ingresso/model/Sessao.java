package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Sessao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Filme filme;
	@ManyToOne
	private Sala sala;
	
	private LocalTime Horario;
	
	private BigDecimal preco;
	
	@OneToMany(mappedBy= "sessao" ,fetch=FetchType.EAGER)
	private Set<Ingresso> ingressos =  new HashSet<>();
	
	/*
	 * @deprecated
	 * Hibernate Only
	 * 
	 */
	public Sessao(){
		
	}
	
	public Sessao(Filme filme, Sala sala, LocalTime horario) {
		this.filme = filme;
		this.sala = sala;
		Horario = horario;
		this.preco = sala.getPreco().add(filme.getPreco());
	}
	
	public boolean isDisponivel(Lugar lugarSelecionado){
		
		return ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar->lugar.equals(lugarSelecionado));
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
	
	public LocalTime getHorarioTermino(){
		
		return this.Horario.plusMinutes(filme.getDuracao().toMinutes());
	}
	
	public BigDecimal getPreco(){
		return this.preco;
	}
	
	public Map<String,List<Lugar>> getMapaDeLugares(){
		
		return sala.getMapaDeLugares();
	}
	
}
