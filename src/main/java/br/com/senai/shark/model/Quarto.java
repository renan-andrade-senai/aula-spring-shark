package br.com.senai.shark.model;

import br.com.senai.shark.dto.QuartoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private Integer andar;

	public Quarto() {
		super();
	}
	
	public Quarto(QuartoDto quarto) {
		this.id = quarto.getId();
		this.numero = quarto.getNumero();
		this.andar = quarto.getAndar();
	}

	public Quarto(Integer id, Integer numero, Integer andar) {
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
