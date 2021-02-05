package br.com.zup.DesafioMercadoLivre.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Imagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany
	private List<Arquivos> imagens;
	@JoinColumn(name = "fk_idProduto")
	private Long idProduto;
	private Long idUsuario;
	
	public Long getId() {
		return id;
	}
	public List<Arquivos> getImagens() {
		return imagens;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public Imagem(List<Arquivos> imagens, Long idProduto, Long idUsuario) {
		super();
		this.imagens = imagens;
		this.idProduto = idProduto;
		this.idUsuario = idUsuario;
	}
}
