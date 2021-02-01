package br.com.zup.DesafioMercadoLivre.config.security;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class GerarHash {
	
	public String gerarEncripty(String senha) {
		String gerar = BCrypt.gensalt();
		String senhaEncriptada = BCrypt.hashpw(senha, gerar);
		return senhaEncriptada;
	}

}
