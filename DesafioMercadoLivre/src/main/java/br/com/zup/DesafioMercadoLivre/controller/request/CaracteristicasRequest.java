package br.com.zup.DesafioMercadoLivre.controller.request;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CaracteristicasRequest {
	
	@NotBlank
	@NotNull
	private String nome;
	@NotNull
	@Min(1)
	private BigDecimal valor;
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public String getDescricao() {
		return descricao;
	}

	@Deprecated
	public CaracteristicasRequest() {	}
	
	public CaracteristicasRequest(@NotBlank String nome, @NotNull BigDecimal valor, String descricao) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
	}
	public CaracteristicasRequest(@NotBlank String nome, @NotNull BigDecimal valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
}
