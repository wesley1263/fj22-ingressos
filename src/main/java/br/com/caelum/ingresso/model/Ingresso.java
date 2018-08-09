package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	/*
	 * @deprecated hibernate only
	 */
	public Ingresso(){
	}
	
	
	public Ingresso(Sessao sesao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
		this.sessao = sesao;
		this.setTipoDeIngresso(tipoDeIngresso);
		this.lugar = lugar;
		this.preco = tipoDeIngresso.aplicarDesconto(this.sessao.getPreco());
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public Sessao getSessao() {
		return sessao;
	}


	public void setSessao(Sessao sesao) {
		this.sessao = sesao;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}


	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}
	
	
	
	
}
