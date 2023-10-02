package br.com.senai.shark.dto;

import br.com.senai.shark.model.Quarto;

public class QuartoDto {

	private Integer id;
	private Integer numero;
	private Integer andar;

	public QuartoDto() {
		super();
	}
	
	public QuartoDto(Quarto quarto) {
		this.id = quarto.getId();
		this.numero = quarto.getNumero();
		this.andar = quarto.getAndar();
	}

	public QuartoDto(Integer id, Integer numero, Integer andar) {
		super();
		this.id = id;
		this.numero = numero;
		this.andar = andar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

}
