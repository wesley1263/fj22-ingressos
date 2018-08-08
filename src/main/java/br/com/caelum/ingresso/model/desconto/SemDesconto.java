package br.com.caelum.ingresso.model.desconto;

import java.math.BigDecimal;

public class SemDesconto implements Desconto {

	@Override
	public BigDecimal aplicarDesconto(BigDecimal preco) {
		return preco;
	}

	@Override
	public String getDescricao() {
		return "Inteira";
	}

}
