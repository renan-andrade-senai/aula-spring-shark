package br.com.senai.shark.model;

import br.com.senai.shark.dto.MedicoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String crm;
	private String cpf;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Medico() {
		super();
	}
	
	public Medico(MedicoDto medico) {
		this.id = medico.getId();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.cpf = medico.getCpf();
		if (medico.getDepartamento() != null) {
			this.departamento = new Departamento(medico.getDepartamento());
		}
	}

	public Medico(Integer id, String nome, String crm, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.cpf = cpf;
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

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
