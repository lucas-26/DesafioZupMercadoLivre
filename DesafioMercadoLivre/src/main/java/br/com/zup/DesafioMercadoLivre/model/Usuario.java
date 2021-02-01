package br.com.zup.DesafioMercadoLivre.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.zup.DesafioMercadoLivre.config.security.GerarHash;
import br.com.zup.DesafioMercadoLivre.myAnotations.UniqueValue;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime instanteCadastro;
	@Column(unique = true)
	@UniqueValue
	private String login;
	private String senha;
	
	public LocalDateTime getInstanteCadastro() {
		return instanteCadastro;
	}
	public void setInstanteCadastro(LocalDateTime instanteCadastro) {
		this.instanteCadastro = instanteCadastro;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public static String encriptySenha(String senha) {
		GerarHash encriptaSenha = new GerarHash();
		return encriptaSenha.gerarEncripty(senha);
	}
	
	@Deprecated
	public Usuario() { }
	
	public Usuario(LocalDateTime instanteCadastro, String login, String senha) {
		super();
		this.instanteCadastro = instanteCadastro;
		this.login = login;
		this.senha = encriptySenha(senha);
	}
}
