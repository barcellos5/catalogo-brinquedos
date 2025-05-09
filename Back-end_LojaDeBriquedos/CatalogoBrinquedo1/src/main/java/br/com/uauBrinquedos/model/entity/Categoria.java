package br.com.uauBrinquedos.model.entity;

import org.springframework.data.annotation.Id;

public class Categoria {
	@Id
	private int codCat;
	private String nome;
	private String linha;
	private int idade; // lembrar de alterar no banco de dados o nome faixa etaria para idade
	private String nomeImagem;// tirar dúvida com o professor se vale a pena manter nome imagem
	
	public Categoria() {
		
	}

	public Categoria(int codCat, String nome, String linha, int idade, String nomeImagem) {
		this.codCat = codCat;
		this.nome = nome;
		this.linha = linha;
		this.idade = idade;
		this.nomeImagem = nomeImagem;
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
