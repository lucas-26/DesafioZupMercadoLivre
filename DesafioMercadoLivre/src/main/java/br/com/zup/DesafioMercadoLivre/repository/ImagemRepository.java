package br.com.zup.DesafioMercadoLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.DesafioMercadoLivre.model.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long>{

}
