package br.com.zup.DesafioMercadoLivre.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.myAnotations.ExistsId;
import br.com.zup.DesafioMercadoLivre.myAnotations.UniqueValue;

public class CategoriaRequest {

	@NotNull
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "esse nome já existe")
	private String nome;
	private Long id;

	public String getNome() {
		return nome;
	}

	public Long getIdCategoriaMae() {
		return id;
	}

	@Deprecated
	public CategoriaRequest() {
	}

	public CategoriaRequest(@NotNull @NotBlank String nome) {
		super();
		this.nome = nome;
	}

	public CategoriaRequest(@NotNull @NotBlank String nome, Long id) {
		super();
		this.nome = nome;
		this.id = id;
	}
}
