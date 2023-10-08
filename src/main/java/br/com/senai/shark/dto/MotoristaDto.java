package br.com.senai.shark.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.shark.model.Motorista;

public class MotoristaDto {

	private Integer id;
	private String nome;
	private String cnh;
	private LocalDate dtNascimento;
	@JsonManagedReference
	private List<VeiculoDto> veiculos;

	public MotoristaDto() {
	}
	
	public MotoristaDto(Motorista motorista) {
		this.id = motorista.getId();
		this.nome = motorista.getNome();
		this.cnh = motorista.getCnh();
		this.dtNascimento = motorista.getDtNascimento();
		if (motorista.getVeiculos() != null) {
			this.veiculos = motorista.getVeiculos().stream().map(VeiculoDto::new).toList();
			veiculos.forEach(v -> v.setMotorista(this));
		}
	}

	public MotoristaDto(Integer id, String nome, String cnh, LocalDate dtNascimento, List<VeiculoDto> veiculos) {
		this.id = id;
		this.nome = nome;
		this.cnh = cnh;
		this.dtNascimento = dtNascimento;
		this.veiculos = veiculos;
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

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<VeiculoDto> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<VeiculoDto> veiculos) {
		this.veiculos = veiculos;
	}

}
