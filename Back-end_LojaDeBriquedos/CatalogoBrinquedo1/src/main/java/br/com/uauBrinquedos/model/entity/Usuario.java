package br.com.uauBrinquedos.model.entity;

import org.springframework.data.annotation.Id;

public class Usuario {
	@Id
	private int cod;
	private String nomeUsuario;
	private String sexo;
	private String login;
	private String senha;
	
	public Usuario() {
	}

	public Usuario(int cod, String nomeUsuario, String sexo, String login, String senha) {
		this.cod = cod;
		this.nomeUsuario = nomeUsuario;
		this.sexo = sexo;
		this.login = login;
		this.senha = senha;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getnomeUsuario() {
		return nomeUsuario;
	}

	public void setnomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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
}
