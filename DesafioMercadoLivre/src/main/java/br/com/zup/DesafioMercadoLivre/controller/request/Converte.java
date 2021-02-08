package br.com.zup.DesafioMercadoLivre.controller.request;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import br.com.zup.DesafioMercadoLivre.model.Arquivos;
import br.com.zup.DesafioMercadoLivre.model.Caracteristicas;
import br.com.zup.DesafioMercadoLivre.model.Categoria;
import br.com.zup.DesafioMercadoLivre.model.Imagem;
import br.com.zup.DesafioMercadoLivre.model.OpiniaoSobreProduto;
import br.com.zup.DesafioMercadoLivre.model.Pergunta;
import br.com.zup.DesafioMercadoLivre.model.Produto;
import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.repository.ArquivosRepository;

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
		return new Produto(caracteristica, produtoRequest.getQuantidade(), produtoRequest.getDescricao(), produtoRequest.getCategoria(), LocalDateTime.now(), produtoRequest.getIdUsuario());
	}
	@Transactional
	public static Imagem ConverteRequestParaImagems(@Valid RequestImagem requestImagem, ArquivosRepository arquivoRepository) {
		List<String> arquivos = requestImagem.getImages(); 
		List<Arquivos> arquivosImagen = new ArrayList<Arquivos>();
		arquivos.forEach(a -> {
			Arquivos arc = new Arquivos(a, requestImagem.getIdProduto());
			arquivoRepository.save(arc);
			arquivosImagen.add(arc);
		});
		return new Imagem(arquivosImagen, requestImagem.getIdProduto(), requestImagem.getIdUsuario());
	}

	public static OpiniaoSobreProduto ConverteRequestParaOpiniao(RequestOpiniao requestOpiniao) {
		return new OpiniaoSobreProduto(requestOpiniao.getNota(), requestOpiniao.getTitulo(), requestOpiniao.getDescricao(), requestOpiniao.getIdUsuario(), requestOpiniao.getIdProduto());
	}

	public static Pergunta ConverteRequestParaPerguntas(@Valid PerguntaRequest perguntaRequest) {
		return new Pergunta(perguntaRequest.getTitulo(), perguntaRequest.getIdUsuario(), perguntaRequest.getIdProduto());
	}
}
