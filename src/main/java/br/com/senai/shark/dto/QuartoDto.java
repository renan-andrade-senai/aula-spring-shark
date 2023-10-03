package br.com.senai.shark.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.shark.model.Quarto;

public class QuartoDto {

	private Integer id;
	private Integer numero;
	private Integer andar;
	@JsonBackReference
	private PacienteDto paciente;

	public QuartoDto() {
		super();
	}
	
	public QuartoDto(Quarto quarto) {
		this.id = quarto.getId();
		this.numero = quarto.getNumero();
		this.andar = quarto.getAndar();
		this.paciente = new PacienteDto(quarto.getPaciente().getId(), 
				quarto.getPaciente().getNome(),
				quarto.getPaciente().getCpf(),
				this);
	}

	public QuartoDto(Integer id, Integer numero, Integer andar, PacienteDto paciente) {
		super();
		this.id = id;
		this.numero = numero;
		this.andar = andar;
		this.paciente = paciente;
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

	public PacienteDto getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDto paciente) {
		this.paciente = paciente;
	}

}
