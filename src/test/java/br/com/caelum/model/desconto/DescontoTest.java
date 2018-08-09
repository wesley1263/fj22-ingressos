package br.com.caelum.model.desconto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;
import br.com.caelum.ingresso.model.desconto.DescontoEstudante;
import br.com.caelum.ingresso.model.desconto.DescontoIdoso;
import br.com.caelum.ingresso.model.desconto.SemDesconto;

public class DescontoTest {
	
	
	
	private Sala sala;
	private Filme filme;
	private Sessao sessao;
	private Lugar lugar;


	@Before
	public void loadSessao(){
		sala = new Sala("Cinemax Interlagos",new BigDecimal("20.0"));
		filme = new Filme("Vingadores guerra infinita", Duration.ofMinutes(180), "Ficção", new BigDecimal("25.0"));
		sessao = new Sessao(filme, sala, LocalTime.parse("17:00:00"));
		lugar = new Lugar("A",1);
	}
	
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal(){
		
		Ingresso ingresso = new Ingresso(this.sessao,TipoDeIngresso.INTEIRA,this.lugar);
		
		BigDecimal descontoEsperado = new BigDecimal("45.0");
		
		Assert.assertEquals(descontoEsperado, ingresso.getPreco());
	}
	
	
	@Test
	public void deveConcederDescontoDe50PorcentoParaEstudante(){
		Ingresso ingresso = new Ingresso(this.sessao,TipoDeIngresso.ESTUDANTE,this.lugar);
		
		BigDecimal descontoEsperado = new BigDecimal("22.5");
		
		Assert.assertEquals(descontoEsperado, ingresso.getPreco());
	}
	
	
	@Test
	public void deveConcederDescontoParaIdosoDe10Reais(){
		Ingresso ingresso = new Ingresso(this.sessao,TipoDeIngresso.IDOSO,this.lugar);
		
		BigDecimal descontoEsperado = new BigDecimal("35.0");
		
		Assert.assertEquals(descontoEsperado, ingresso.getPreco());
	}

}
