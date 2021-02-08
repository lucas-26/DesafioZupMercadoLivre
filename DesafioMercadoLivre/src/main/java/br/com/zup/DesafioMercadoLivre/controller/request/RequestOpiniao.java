package br.com.zup.DesafioMercadoLivre.controller.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.myAnotations.ExistsId;

public class RequestOpiniao {
	@Min(value = 1)
	@Max(value = 5)
	private Long nota;
	@NotBlank
	private String titulo;
	@NotNull
	@NotEmpty
	@Length(max = 500)
	private String descricao;
	@ExistsId(domainClass = Usuario.class, fieldName = "id", message = "esse id de usuário precisa existir no banco")
	private Long idUsuario;
	@ExistsId(domainClass = Produto.class, fieldName = "id", message = "esse id de produto precisa existir no banco")
	private Long idProduto;
	public Long getNota() {
		return nota;
	}
	public void setNota(Long nota) {
		this.nota = nota;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public RequestOpiniao(@Size(min = 1, max = 5) Long nota, @NotBlank String titulo, @Max(500) String descricao,
			@NotBlank Long idUsuario, @NotBlank Long idProduto) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
	}
	
}
