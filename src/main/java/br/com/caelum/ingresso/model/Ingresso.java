package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;

public class Ingresso {

	private Sessao sesao;
	private BigDecimal preco;
	
	/*
	 * @deprecated hibernate only
	 */
	public Ingresso(){
	}
	
	
	public Ingresso(Sessao sesao, Desconto desconto) {
		this.sesao = sesao;
		this.preco = desconto.aplicarDesconto(this.sesao.getPreco());
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	
	
	
}
