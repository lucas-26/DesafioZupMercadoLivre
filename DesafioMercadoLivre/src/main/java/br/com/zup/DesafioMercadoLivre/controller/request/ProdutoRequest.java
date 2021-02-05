package br.com.zup.DesafioMercadoLivre.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;

import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.myAnotations.ExistsId;

public class ProdutoRequest {

	private CaracteristicasRequest caracteristicasRequest;
	@Min(1)
	private long quantidade;
	private String descricao;
	@ExistsId(domainClass = Categoria.class, fieldName = "nome", message = "o id precisa estar cadastrado no sistema")
	private String categoria;
	private LocalDateTime instanteCadastro;
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "O id do usuário precisa estar cadastrado no banco")
	private Long idUsuario;

	public CaracteristicasRequest getCaracteristicasRequest() {
		return caracteristicasRequest;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	@Deprecated
	public ProdutoRequest() { }

	public ProdutoRequest(CaracteristicasRequest caracteristicasRequest, @Min(1) long quantidade, String descricao,
			String categoria, LocalDateTime instanteCadastro, Long idUsuario) {
		super();
		this.caracteristicasRequest = caracteristicasRequest;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
		this.instanteCadastro = instanteCadastro;
		this.idUsuario = idUsuario;
	}
}
