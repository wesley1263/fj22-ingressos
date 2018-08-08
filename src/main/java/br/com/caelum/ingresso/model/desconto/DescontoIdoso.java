package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class DescontoIdoso implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal preco) {
		return preco.subtract(new BigDecimal("10.0"));
	}

}
