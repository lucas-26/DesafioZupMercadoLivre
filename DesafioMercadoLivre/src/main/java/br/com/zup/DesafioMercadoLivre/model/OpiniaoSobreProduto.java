package br.com.zup.DesafioMercadoLivre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OpiniaoSobreProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long nota;
	private String titulo;
	private String descricao;
	private Long idUsuario;
	private Long idProduto;
	
	public Long getId() {
		return id;
	}
	public Long getNota() {
		return nota;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	
	@Deprecated
	public OpiniaoSobreProduto() {}
	
	public OpiniaoSobreProduto(Long nota, String titulo, String descricao, Long idUsuario, Long idProduto) {
		super();
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
	}
}
