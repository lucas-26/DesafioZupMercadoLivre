package br.com.zup.DesafioMercadoLivre.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.DesafioMercadoLivre.config.security.TokenService;
import br.com.zup.DesafioMercadoLivre.controller.request.LoginRequest;
import br.com.zup.DesafioMercadoLivre.controller.request.TokenResponse;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private AuthenticationManager autManager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenResponse> autenticacao(@RequestBody @Valid LoginRequest loginRequest) {
		UsernamePasswordAuthenticationToken dadosLoginConvertido = loginRequest.converter();
		try {
			Authentication aut = autManager.authenticate(dadosLoginConvertido);
			String token = tokenService.gerarToken(aut);
			return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
		} catch (AuthenticationException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new TokenResponse(e.getMessage(), "erro ao gerar o token"));
		}
	}

}
