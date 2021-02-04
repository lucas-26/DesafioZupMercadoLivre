package br.com.zup.DesafioMercadoLivre.controller.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.com.zup.DesafioMercadoLivre.model.Caracteristicas;
import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.model.Usuario;

public class Converte {

	public static Usuario ConverteRequestParaUsuario(@Valid RequestUsuario requestUsuario) {
		return new Usuario(requestUsuario.getInstanteCadastro() ,requestUsuario.getLogin(), requestUsuario.getSenha());
	}

	public static Categoria ConverteRequestParaCategoria(@Valid CategoriaRequest categoriaRequest) {
		return new Categoria(categoriaRequest.getNome(), categoriaRequest.getIdCategoriaMae());
	}
	
	public static Caracteristicas ConverteRequestParaCaracteristicas(@Valid CaracteristicasRequest caracteristicasRequest) {
		return new Caracteristicas(caracteristicasRequest.getNome(), caracteristicasRequest.getValor(), caracteristicasRequest.getDescricao());
	}

	public static Produto ConverteRequestParaProduto(@Valid ProdutoRequest produtoRequest) {
		List<Caracteristicas> caracteristica = new ArrayList<Caracteristicas>();
		caracteristica.add(ConverteRequestParaCaracteristicas(produtoRequest.getCaracteristicasRequest()));	
		return new Produto(caracteristica, produtoRequest.getQuantidade(), produtoRequest.getDescricao(), produtoRequest.getCategoria());
	}
}
