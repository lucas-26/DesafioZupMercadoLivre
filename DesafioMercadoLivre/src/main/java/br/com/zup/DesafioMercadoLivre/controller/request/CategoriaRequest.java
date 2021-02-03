package br.com.zup.DesafioMercadoLivre.controller.request;

import javax.validation.constraints.NotNull;

import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.myAnotations.UniqueValue;

public class CategoriaRequest {

	@NotNull
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "o nome é unico e obrigatorio")
	private String nome;

	private String categoriaMae;

	public String getNome() {
		return nome;
	}

	public String getCategoriaMae() {
		return categoriaMae;
	}

	public CategoriaRequest() {
	}

	public CategoriaRequest(String nome, String categoriaMae) {
		super();
		this.nome = nome;
		this.categoriaMae = categoriaMae;
	}
}
