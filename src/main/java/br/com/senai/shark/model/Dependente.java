package br.com.senai.shark.model;

import br.com.senai.shark.dto.DependenteDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	@JoinColumn(name = "empregado_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Empregado empregado;

	public Dependente() {
		super();
	}
	
	public Dependente(DependenteDto dependente) {
		this.id = dependente.getId();
		this.nome = dependente.getNome();
		this.cpf = dependente.getCpf();
	}

	public Dependente(Integer id, String nome, String cpf, Empregado empregado) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.empregado = empregado;
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

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

}
