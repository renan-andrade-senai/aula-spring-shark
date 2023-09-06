package br.com.senai.shark.model;

import br.com.senai.shark.dto.CarroDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	private Integer ano;

	public Carro() {
	}
	
	public Carro(CarroDto carroDto) {
		this.id = carroDto.getId();
		this.marca = carroDto.getMarca();
		this.modelo = carroDto.getModelo();
		this.ano = carroDto.getAno();
	}

	public Carro(Integer id, String marca, String modelo, Integer ano) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
