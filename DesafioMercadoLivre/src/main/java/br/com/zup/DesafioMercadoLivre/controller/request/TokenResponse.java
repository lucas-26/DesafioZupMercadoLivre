package br.com.zup.DesafioMercadoLivre.controller.request;

public class TokenResponse {
	
	private String token;
	private String tipo;
	
	public String getToken() {
		return token;
	}
	public String getTipo() {
		return tipo;
	}
	
	public TokenResponse(String token, String tipo) {
		super();
		this.token = token;
		this.tipo = tipo;
	}
}
