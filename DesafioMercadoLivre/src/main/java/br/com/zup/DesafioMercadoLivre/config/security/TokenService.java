package br.com.zup.DesafioMercadoLivre.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.zup.DesafioMercadoLivre.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${DesafioMercadoLivre.jwt.expiration}")
	private String expiration;

	@Value("${DesafioMercadoLivre.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication aut) {
		Usuario estaLogado = (Usuario) aut.getPrincipal();
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		return Jwts.builder()
				.setIssuer("Api do mercado Livre")
				.setSubject(estaLogado.getId().toString())
				.setIssuedAt(dataExpiracao)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean tokenIsValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getIdByUser(String token) {
		Claims body = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}
}
