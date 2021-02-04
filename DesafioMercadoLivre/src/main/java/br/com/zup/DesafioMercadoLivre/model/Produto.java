package br.com.zup.DesafioMercadoLivre.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToMany
	private List<Caracteristicas> caracteristicas;
	private long quantidade;
	private String descricao;
	private String categoria;
	private LocalDateTime instanteCadastro;

	public long getId() {
		return id;
	}

	public List<Caracteristicas> getCaracteristicas() {
		return caracteristicas;
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

	@Deprecated
	public Produto() {
	}

	public Produto(List<Caracteristicas> caracteristicas, long quantidade, String descricao, String categoria) {
		super();
		this.caracteristicas = caracteristicas;
		this.quantidade = quantidade;
		this.descricao = descricao;
		this.categoria = categoria;
		this.instanteCadastro = LocalDateTime.now();
	}
}
