package br.com.zup.DesafioMercadoLivre.controller.request;

import java.util.List;

import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.myAnotations.ExistsId;

public class RequestImagem {

	private List<String> images;
	@ExistsId(domainClass = Produto.class, fieldName = "id", message = "o id do produto precisa existir no sistema")
	private Long idProduto;
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "o id do usuario precisa exixstir no sistema e prcisa ser o mesmo usuario que cadastrou o produto no sistema")
	private Long idUsuario;

	public List<String> getImages() {
		return images;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public RequestImagem(List<String> images, Long idProduto, Long idUsuario) {
		super();
		this.images = images;
		this.idProduto = idProduto;
		this.idUsuario = idUsuario;
	}
}
