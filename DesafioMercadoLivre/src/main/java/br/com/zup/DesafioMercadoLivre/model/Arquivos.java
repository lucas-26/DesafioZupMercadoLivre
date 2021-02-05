package br.com.zup.DesafioMercadoLivre.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Arquivos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String arquivo;
	private Long fk_idProduto;
	
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public Long getFk_idProduto() {
		return fk_idProduto;
	}
	public void setFk_idProduto(Long fk_idProduto) {
		this.fk_idProduto = fk_idProduto;
	}
	public Arquivos(String arquivo, Long fk_idProduto) {
		super();
		this.arquivo = arquivo;
		this.fk_idProduto = fk_idProduto;
	}
}
