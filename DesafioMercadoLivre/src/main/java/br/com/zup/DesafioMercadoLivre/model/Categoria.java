package br.com.zup.DesafioMercadoLivre.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
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
	private Long IdCategoriaPai;
	
	public Categoria() { }

	public Categoria(String nome, Long idCategoriaPai) {
		this.nome = nome;
		this.IdCategoriaPai = idCategoriaPai;
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public Long getIdCategoriaPai() {
		return IdCategoriaPai;
	}

	public static void persiste(EntityManager entity, List<Caracteristicas> caracteristicas) {
		caracteristicas.forEach(Caracteristica -> {
			entity.persist(Caracteristica);
		});
		
	}
}
