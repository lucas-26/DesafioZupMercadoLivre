package br.com.zup.DesafioMercadoLivre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(unique = true)
	private String nome;
	private String Subcategoria;
	
	public long getId() {
		return Id;
	}
	public String getNome() {
		return nome;
	}
	public String getSubcategoria() {
		return Subcategoria;
	}

	public Categoria() { }
	
	public Categoria( String nome, String subcategoria) {
		super();
		this.nome = nome;
		Subcategoria = subcategoria;
	}	
}
