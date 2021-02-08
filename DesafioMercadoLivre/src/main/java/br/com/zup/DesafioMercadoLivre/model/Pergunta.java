package br.com.zup.DesafioMercadoLivre.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pergunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private LocalDateTime instanteCriacao;
	private Long idUsuario;
	private Long idProduto;
	
	public Long getId() {
		return id;
	}
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
	
	@Deprecated
	public Pergunta() {	}
	
	public Pergunta(String titulo,Long idUsuario, Long idProduto) {
		super();
		this.titulo = titulo;
		this.instanteCriacao = LocalDateTime.now();
		this.idUsuario = idUsuario;
		this.idProduto = idProduto;
	}
}
