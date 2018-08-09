package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoMeia implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal preco) {
		return preco.divide(new BigDecimal("2.0"));
	}

	@Override
	public String getDescricao() {
		
		return "Meia Infantil";
	}

}
