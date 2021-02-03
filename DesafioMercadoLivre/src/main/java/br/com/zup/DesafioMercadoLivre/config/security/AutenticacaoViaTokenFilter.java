package br.com.zup.DesafioMercadoLivre.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	
	private TokenService tokenService;
	private UsuarioRepository usuarioRep;
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRep) {
		this.tokenService = tokenService;
		this.usuarioRep = usuarioRep;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		boolean valido = tokenService.tokenIsValid(token);
		if(valido) {
			autenticarCliente(token);
		}
		filterChain.doFilter(request, response);		
	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdByUser(token);
		Usuario usuario = usuarioRep.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || token.startsWith("Bearer ")) {
			return null;
		}else {
			return token.substring(7, token.length());
		}
	}


}
