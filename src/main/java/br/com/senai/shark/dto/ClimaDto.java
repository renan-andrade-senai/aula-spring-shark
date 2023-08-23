package br.com.senai.shark.dto;

import java.time.LocalDate;

public class ClimaDto {
	
	private String cidade;
	private LocalDate data;
	private Double temperatura;
	
	public ClimaDto() {
		super();
	}
	public ClimaDto(String cidade, LocalDate data, Double temperatura) {
		super();
		this.cidade = cidade;
		this.data = data;
		this.temperatura = temperatura;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	

}
