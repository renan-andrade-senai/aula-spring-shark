package br.com.senai.shark.model;

import br.com.senai.shark.dto.QuartoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numero;
	private Integer andar;
	@OneToOne(mappedBy = "quarto", cascade = CascadeType.ALL)
	private Paciente paciente;

	public Quarto() {
		super();
	}
	
	public Quarto(QuartoDto quarto) {
		this.id = quarto.getId();
		this.numero = quarto.getNumero();
		this.andar = quarto.getAndar();
		this.paciente = new Paciente(quarto.getPaciente().getId(), 
				quarto.getPaciente().getNome(),
				quarto.getPaciente().getCpf(),
				this);
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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
