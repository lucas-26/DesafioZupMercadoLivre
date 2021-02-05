package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.controller.request.RequestImagem;
import br.com.zup.DesafioMercadoLivre.model.Imagem;
import br.com.zup.DesafioMercadoLivre.repository.ArquivosRepository;
import br.com.zup.DesafioMercadoLivre.repository.ImagemRepository;

@RestController
@RequestMapping("/Imagem")
public class ImagemController {

	@Autowired
	ImagemRepository imagemRepository;

	@Autowired
	ArquivosRepository arquivoRepository;

	@PostMapping
	public ResponseEntity<?> SalvaImagens(@RequestBody @Valid RequestImagem requestImagem) {
		Imagem imagem = Converte.ConverteRequestParaImagems(requestImagem, arquivoRepository);
		imagemRepository.save(imagem);
		return ResponseEntity.ok().build();
	}
}
