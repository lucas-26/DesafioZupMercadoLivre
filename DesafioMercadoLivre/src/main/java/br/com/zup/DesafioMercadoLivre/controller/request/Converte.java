package br.com.zup.DesafioMercadoLivre.controller.request;

import javax.validation.Valid;

import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.model.Usuario;

public class Converte {

	public static Usuario ConverteRequestParaUsuario(@Valid RequestUsuario requestUsuario) {
		return new Usuario(requestUsuario.getInstanteCadastro() ,requestUsuario.getLogin(), requestUsuario.getSenha());
	}

	public static Categoria ConverteRequestParaCategoria(@Valid CategoriaRequest categoriaRequest) {
		return new Categoria(categoriaRequest.getNome(), categoriaRequest.getCategoriaMae());
	}

}
