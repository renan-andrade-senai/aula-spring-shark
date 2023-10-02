package br.com.senai.shark.dto;

import java.util.List;

import br.com.senai.shark.model.Departamento;

public class DepartamentoDto {

	private Integer id;
	private String nome;
	private List<MedicoDto> medicos;

	public DepartamentoDto() {
		super();
	}
	
	public DepartamentoDto(Departamento departamento) {
		this.id = departamento.getId();
		this.nome = departamento.getNome();
		this.medicos = departamento.getMedicos().stream().map(MedicoDto::new).toList();
	}

	public DepartamentoDto(Integer id, String nome, List<MedicoDto> medicos) {
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

	public List<MedicoDto> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<MedicoDto> medicos) {
		this.medicos = medicos;
	}

}
