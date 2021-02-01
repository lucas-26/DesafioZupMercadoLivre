package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.controller.request.Converte;
import br.com.zup.DesafioMercadoLivre.controller.request.RequestUsuario;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "MercadoLivre/Usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping(value = "/CadastrarUsuario")
	public ResponseEntity<?> cadastro(@RequestBody @Valid RequestUsuario requestUsuario){
		try {
			Usuario usuario = Converte.ConverteRequestParaUsuario(requestUsuario);
			usuarioRepository.save(usuario);
			
			return ResponseEntity.ok().build();

		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
