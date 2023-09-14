package br.com.senai.shark.dto;

import java.time.LocalDate;

import br.com.senai.shark.model.Produto;

public class ProdutoDto {

	private Integer id;
	private String titulo;
	private String descricao;
	private Double preco;
	private LocalDate prazoEntrega;

	public ProdutoDto() {
	}

	public ProdutoDto(Integer id, String titulo, String descricao, Double preco, LocalDate prazoEntrega) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.preco = preco;
		this.prazoEntrega = prazoEntrega;
	}

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.titulo = produto.getTitulo();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.prazoEntrega = produto.getPrazoEntrega();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(LocalDate prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

}
