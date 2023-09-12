package br.com.senai.shark.model;

import java.time.LocalDate;

import br.com.senai.shark.dto.ClienteDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String endereco;
	private String email;
	private LocalDate dtNascimento;
	private String cpf;

	public Cliente() {
		super();
	}
	
	public Cliente(ClienteDto clienteDto) {
		this.id = clienteDto.getId();
		this.nome = clienteDto.getNome();
		this.endereco = clienteDto.getEndereco();
		this.email = clienteDto.getEmail();
		this.dtNascimento = clienteDto.getDtNascimento();
		this.cpf = clienteDto.getCpf();
	}

	public Cliente(Integer id, String nome, String endereco, String email, LocalDate dtNascimento, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.dtNascimento = dtNascimento;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
