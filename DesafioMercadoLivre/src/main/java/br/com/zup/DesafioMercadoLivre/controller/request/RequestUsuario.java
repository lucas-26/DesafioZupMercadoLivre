package br.com.zup.DesafioMercadoLivre.controller.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.DesafioMercadoLivre.model.Usuario;
import br.com.zup.DesafioMercadoLivre.myAnotations.UniqueValue;

public class RequestUsuario {

	@NotBlank
	@Email
	@UniqueValue(domainClass = Usuario.class, fieldName = "email", message = "não foi possivel cadastrar esse email.")
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;
	private LocalDateTime instanteCadastro = LocalDateTime.now();

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}

	@Deprecated
	public RequestUsuario() {
	}

	public RequestUsuario(@NotBlank @Email String login, @NotBlank @Min(6) String senha,
			LocalDateTime instanteCadastro) {
		super();
		this.login = login;
		this.senha = senha;
		this.instanteCadastro = instanteCadastro;
	}
}
