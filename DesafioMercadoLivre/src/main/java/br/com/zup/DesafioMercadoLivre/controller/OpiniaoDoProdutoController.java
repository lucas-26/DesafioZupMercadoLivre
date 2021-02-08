package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.controller.request.RequestOpiniao;
import br.com.zup.DesafioMercadoLivre.model.OpiniaoSobreProduto;
import br.com.zup.DesafioMercadoLivre.repository.OpiniaoRepository;

@RestController
@RequestMapping("/opiniao")
public class OpiniaoDoProdutoController {
	
	@Autowired
	 OpiniaoRepository opiniaoRepository;

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid RequestOpiniao requestOpiniao){
		OpiniaoSobreProduto opiniao = Converte.ConverteRequestParaOpiniao(requestOpiniao);
		opiniaoRepository.save(opiniao);
		return ResponseEntity.ok().build();
	}
}
