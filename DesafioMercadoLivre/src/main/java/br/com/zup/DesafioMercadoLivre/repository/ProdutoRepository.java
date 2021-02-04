package br.com.zup.DesafioMercadoLivre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.DesafioMercadoLivre.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
