package br.com.senai.shark.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.shark.model.Paciente;

public class PacienteDto {

	private Integer id;
	private String nome;
	private String cpf;
	@JsonManagedReference
	private QuartoDto quarto;

	public PacienteDto() {
		super();
	}
	
	public PacienteDto(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.quarto = new QuartoDto(paciente.getQuarto());
	}

	public PacienteDto(Integer id, String nome, String cpf, QuartoDto quarto) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.quarto = quarto;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public QuartoDto getQuarto() {
		return quarto;
	}

	public void setQuarto(QuartoDto quarto) {
		this.quarto = quarto;
	}

}
