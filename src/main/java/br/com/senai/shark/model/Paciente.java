package br.com.senai.shark.model;

import br.com.senai.shark.dto.PacienteDto;
import br.com.senai.shark.dto.QuartoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	@JoinColumn(name = "quarto_id")
	@OneToOne(cascade = CascadeType.ALL)
	private Quarto quarto;

	public Paciente() {
		super();
	}
	
	public Paciente(PacienteDto paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.cpf = paciente.getCpf();
		this.quarto = new Quarto(paciente.getQuarto());
	}

	public Paciente(Integer id, String nome, String cpf, Quarto quarto) {
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

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	

}
