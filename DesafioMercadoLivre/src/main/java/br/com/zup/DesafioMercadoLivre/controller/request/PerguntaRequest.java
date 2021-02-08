package br.com.zup.DesafioMercadoLivre.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.myAnotations.ExistsId;

public class PerguntaRequest {

	@NotBlank
	private String titulo;
	private LocalDateTime instanteCriacao;
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "esse id de usuário precisa existir no banco")
	private Long idUsuario;
	@ExistsId(domainClass = Produto.class, fieldName = "id", message = "esse id de produto precisa existir no banco")
	private Long idProduto;
	
	public String getTitulo() {
		return titulo;
	}
	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public PerguntaRequest(@NotBlank String titulo, LocalDateTime instanteCriacao, Long idUsuario, Long idProduto) {
		super();
		this.titulo = titulo;
		this.instanteCriacao = instanteCriacao;
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
	}
}
