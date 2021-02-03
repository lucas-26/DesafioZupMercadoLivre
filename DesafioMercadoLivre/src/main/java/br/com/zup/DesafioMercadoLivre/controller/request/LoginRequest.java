package br.com.zup.DesafioMercadoLivre.controller.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginRequest {

	private String email;
	private String senha;

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
}
