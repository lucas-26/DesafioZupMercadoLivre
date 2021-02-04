package br.com.zup.DesafioMercadoLivre.controller;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.controller.request.ProdutoRequest;
import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.repository.ProdutoRepository;

@RestController
@RequestMapping("/Produtos")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EntityManager entity;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrarProduto(@RequestBody @Valid ProdutoRequest produtoRequest) {
		try {
			Produto produto = Converte.ConverteRequestParaProduto(produtoRequest);
			Categoria.persiste(entity, produto.getCaracteristicas());
			produtoRepository.save(produto);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw e;
		}
		
	}
}
