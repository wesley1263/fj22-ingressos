package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;

public class SemDesconto implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal preco) {
		return preco;
	}

}
