package br.com.senai.shark.dto;

public class HabitanteDto {
	
	private String nome;
	private String cidade;
	private Double salario;
	private Integer nFilhos;
	
	public HabitanteDto() {
		super();
	}
	public HabitanteDto(String nome, String cidade, Double salario, Integer nFilhos) {
		super();
		this.nome = nome;
		this.cidade = cidade;
		this.salario = salario;
		this.nFilhos = nFilhos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getnFilhos() {
		return nFilhos;
	}
	public void setnFilhos(Integer nFilhos) {
		this.nFilhos = nFilhos;
	}
	
	

	
	
}
