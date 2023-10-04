package br.com.senai.shark.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.shark.model.Dependente;

public class DependenteDto {
	
	private Integer id;
	private String nome;
	private String cpf;
	@JsonBackReference
	private EmpregadoDto empregado;
	
	public DependenteDto() {
		super();
	}
	
	public DependenteDto(Dependente dependente) {
		this.id = dependente.getId();
		this.nome = dependente.getNome();
		this.cpf = dependente.getCpf();
		
	}

	public DependenteDto(Integer id, String nome, String cpf, EmpregadoDto empregado) {
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

	public EmpregadoDto getEmpregado() {
		return empregado;
	}

	public void setEmpregado(EmpregadoDto empregado) {
		this.empregado = empregado;
	}
	
	

}
