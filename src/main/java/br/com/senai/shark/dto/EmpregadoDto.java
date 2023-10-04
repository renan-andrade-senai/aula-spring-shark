package br.com.senai.shark.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.shark.model.Empregado;

public class EmpregadoDto {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String cargo;
	private Double salario;
	@JsonManagedReference
	private List<DependenteDto> dependentes;
	
	public EmpregadoDto() {
		super();
	}
	
	public EmpregadoDto(Empregado empregado) {
		this.id = empregado.getId();
		this.nome = empregado.getNome();
		this.cpf = empregado.getCpf();
		this.cargo = empregado.getCargo();
		this.salario = empregado.getSalario();
		this.dependentes = empregado.getDependentes().stream().map(DependenteDto::new).toList();
		this.dependentes.forEach(d -> d.setEmpregado(this));
	}

	public EmpregadoDto(Integer id, String nome, String cpf, String cargo, Double salario,
			List<DependenteDto> dependentes) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
		this.salario = salario;
		this.dependentes = dependentes;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<DependenteDto> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<DependenteDto> dependentes) {
		this.dependentes = dependentes;
	}
	
}
