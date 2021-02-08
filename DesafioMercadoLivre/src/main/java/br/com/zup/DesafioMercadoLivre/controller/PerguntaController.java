package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.controller.request.PerguntaRequest;
import br.com.zup.DesafioMercadoLivre.model.Pergunta;
import br.com.zup.DesafioMercadoLivre.repository.PerguntaRepository;

@RestController
@RequestMapping("/Perguntas")
public class PerguntaController {

	PerguntaRepository perguntaRepository;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody @Valid PerguntaRequest perguntaRequest){
		Pergunta pergunta = Converte.ConverteRequestParaPerguntas(perguntaRequest);
		perguntaRepository.save(pergunta);
		return ResponseEntity.ok().build();
	}
	
}
