package br.com.uauBrinquedos.model.entity;

import org.springframework.data.annotation.Id;

public class Produto {
	@Id
	private long codProd;
	private String nomeProd;
	private double preco;
	private String categoria;// confirmar com o professor se está correto a forma de puxar a categoria da classe categoria
	private String nomeImagem;
	private String descricao;

	public Produto() {
	}

	public Produto(long codProd, String nomeProd, double preco, String categoria, String nomeImagem, String descricao) {
		this.codProd = codProd;
		this.nomeProd = nomeProd;
		this.preco = preco;
		this.categoria = categoria;
		this.nomeImagem = nomeImagem;
		this.descricao = descricao;
	}

	public long getCodProd() {
		return codProd;
	}

	public void setCodProd(long codProd) {
		this.codProd = codProd;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
	