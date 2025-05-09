package br.com.uaubrinquedos.model.entity;

import org.springframework.data.annotation.Id;

public class Categoria {
	@Id
	private String id;
	private int codCat;
	private String nome;
	private String linha;
	private int idade; // lembrar de alterar no banco de dados o nome faixa etaria para idade
	private String nomeImagem;
	
	public Categoria() {
		
	}
	
	public Categoria(String id, int codCat, String nome, String linha, int idade, String nomeImagem) {
		this.id = id;
		this.codCat = codCat;
		this.nome = nome;
		this.linha = linha;
		this.idade = idade;
		this.nomeImagem = nomeImagem;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public int getCodCat() {
		return codCat;
	}

	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinha() {
		return linha;
	}

	public void setLinha(String linha) {
		this.linha = linha;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
