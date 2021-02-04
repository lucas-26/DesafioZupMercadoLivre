package br.com.zup.DesafioMercadoLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.DesafioMercadoLivre.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
