package br.com.caelum.ingresso.model;

import java.time.YearMonth;

public class Cartao {

	private Integer numero;
	private String cvv;
	private String nome;
	private YearMonth validade;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public YearMonth getValidade() {
		return validade;
	}
	public void setValidade(YearMonth validade) {
		this.validade = validade;
	}
	
	public boolean isValido(){
		return validade.isAfter(YearMonth.now());
	}
	
}
