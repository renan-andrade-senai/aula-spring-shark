package br.com.senai.shark.dto;

import java.time.LocalDate;

public class PessoaDto {
	
	private String nome;
	private String cpf;
	private String profissao;
	private LocalDate dtNascimento;
	private String genero;
	
	public PessoaDto() {
		super();
	}

	public PessoaDto(String nome, String cpf, String profissao, LocalDate dtNascimento, String genero) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
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
	
	

}
