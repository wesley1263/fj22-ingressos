package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;
import br.com.caelum.ingresso.model.desconto.DescontoEstudante;
import br.com.caelum.ingresso.model.desconto.DescontoIdoso;
import br.com.caelum.ingresso.model.desconto.DescontoMeia;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public enum TipoDeIngresso {
	
	INTEIRA(new SemDesconto()),
	IDOSO(new DescontoIdoso()),
	ESTUDANTE(new DescontoEstudante());
	
	
	private final Desconto desconto;
	
	private TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}
	
	public String getDescricao(){
		return desconto.getDescricao();
	}
	
	public BigDecimal aplicarDesconto(BigDecimal valor){
		return desconto.aplicarDesconto(valor);
	}

}
