package br.com.senai.shark.model;

import java.util.List;

import br.com.senai.shark.dto.DepartamentoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
	private List<Medico> medicos;

	public Departamento() {
		super();
	}
	
	public Departamento(DepartamentoDto departamento) {
		this.id = departamento.getId();
		this.nome = departamento.getNome();
		if (departamento.getMedicos() != null) {
			this.medicos = departamento.getMedicos().stream().map(Medico::new).toList();
			medicos.forEach(m -> m.setDepartamento(this));
		}
	}

	public Departamento(Integer id, String nome, List<Medico> medicos) {
		super();
		this.id = id;
		this.nome = nome;
		this.medicos = medicos;
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

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

}
