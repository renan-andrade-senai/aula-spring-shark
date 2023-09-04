package br.com.senai.shark.dto;

import java.time.LocalDate;

import br.com.senai.shark.model.Pessoa;

public class PessoaDto {
	
	private Integer id;
	private String nome;
	private String cpf;
	private String profissao;
	private LocalDate dtNascimento;
	private String genero;
	
	public PessoaDto() {
		super();
	}
	
	public PessoaDto(Pessoa pessoa) {
		this.nome = pessoa.getNome();
		this.cpf = pessoa.getCpf();
		this.id = pessoa.getId();
	}

	public PessoaDto(String nome, String cpf, String profissao, LocalDate dtNascimento, String genero, Integer id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
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
	
	public String getProfissao() {
		return profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
