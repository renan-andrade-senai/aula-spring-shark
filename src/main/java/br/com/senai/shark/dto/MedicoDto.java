package br.com.senai.shark.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.shark.model.Medico;

public class MedicoDto {

	private Integer id;
	private String nome;
	private String crm;
	private String cpf;
	@JsonBackReference
	private DepartamentoDto departamento;

	public MedicoDto() {
		super();
	}
	
	public MedicoDto(Medico medico) {
		this.id = medico.getId();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.cpf = medico.getCpf();
	}

	public MedicoDto(Integer id, String nome, String crm, String cpf, DepartamentoDto departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.crm = crm;
		this.cpf = cpf;
		this.departamento = departamento;
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

	public DepartamentoDto getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDto departamento) {
		this.departamento = departamento;
	}

}
