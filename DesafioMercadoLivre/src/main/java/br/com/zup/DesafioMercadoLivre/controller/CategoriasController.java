package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.CategoriaRequest;
import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.repository.CategoriaRepository;

@RestController
@RequestMapping("MercadoLivre/Categorias")
public class CategoriasController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping(value =  "/CadastrarCategoria")
	public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {

		Categoria categoria = Converte.ConverteRequestParaCategoria(categoriaRequest);
		categoriaRepository.save(categoria);

		return ResponseEntity.ok().build();
	}
}
