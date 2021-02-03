package br.com.zup.DesafioMercadoLivre.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class GerarHash {
	
	public String gerarEncripty(String senha) {
		//String gerar = BCrypt.gensalt();
		//String senhaEncriptada = BCrypt.hashpw(senha, gerar);
		return new BCryptPasswordEncoder().encode(senha);
	}

}
