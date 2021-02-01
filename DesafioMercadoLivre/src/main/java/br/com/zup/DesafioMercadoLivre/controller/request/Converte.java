package br.com.zup.DesafioMercadoLivre.controller.request;

import javax.validation.Valid;

import br.com.zup.DesafioMercadoLivre.model.Usuario;

public class Converte {

	public static Usuario ConverteRequestParaUsuario(@Valid RequestUsuario requestUsuario) {
		return new Usuario(requestUsuario.getInstanteCadastro() ,requestUsuario.getLogin(), requestUsuario.getSenha());
	}

}
