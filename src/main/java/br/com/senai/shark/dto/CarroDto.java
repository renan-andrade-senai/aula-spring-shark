package br.com.senai.shark.dto;

import br.com.senai.shark.model.Carro;

public class CarroDto {

	private Integer id;
	private String marca;
	private String modelo;
	private Integer ano;

	public CarroDto() {
	}
	
	public CarroDto(Carro carro) {
		this.marca = carro.getMarca();
		this.modelo = carro.getModelo();
		this.ano = carro.getAno();
		this.id = carro.getId();
	}

	public CarroDto(String marca, String modelo, Integer ano, Integer id) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
