package br.com.senai.shark.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.shark.model.Motorista;
import br.com.senai.shark.model.Veiculo;

public class VeiculoDto {

	private Integer id;
	private String marca;
	private String modelo;
	private Integer ano;
	private String cor;
	@JsonBackReference
	private MotoristaDto motorista;

	public VeiculoDto() {
	}
	
	public VeiculoDto(Veiculo veiculo) {
		this.id = veiculo.getId();
		this.marca = veiculo.getMarca();
		this.modelo = veiculo.getModelo();
		this.ano = veiculo.getAno();
		this.cor = veiculo.getCor();
	}

	public VeiculoDto(Integer id, String marca, String modelo, Integer ano, String cor, MotoristaDto motorista) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.motorista = motorista;
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public MotoristaDto getMotorista() {
		return motorista;
	}

	public void setMotorista(MotoristaDto motorista) {
		this.motorista = motorista;
	}

}
