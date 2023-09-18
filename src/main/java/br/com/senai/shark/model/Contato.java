package br.com.senai.shark.model;

import br.com.senai.shark.dto.ContatoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String numero;
	private String tipo;

	public Contato() {
	}
	
	public Contato(ContatoDto contatoDto) {
		this.id = contatoDto.getId();
		this.nome = contatoDto.getNome();
		this.numero = contatoDto.getNumero();
		this.tipo = contatoDto.getTipo();
	}

	public Contato(Integer id, String nome, String numero, String tipo) {
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
