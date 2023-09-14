package br.com.senai.shark.dto;

import br.com.senai.shark.model.Contato;

public class ContatoDto {

	private Integer id;
	private String nome;
	private String numero;
	private String tipo;

	public ContatoDto() {
	}
	
	public ContatoDto(Contato contato) {
		this.id = contato.getId();
		this.nome = contato.getNome();
		this.numero = contato.getNumero();
		this.tipo = contato.getTipo();
	}

	public ContatoDto(Integer id, String nome, String numero, String tipo) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
