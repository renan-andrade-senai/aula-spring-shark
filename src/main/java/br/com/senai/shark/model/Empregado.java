package br.com.senai.shark.model;

import java.util.List;

import br.com.senai.shark.dto.DependenteDto;
import br.com.senai.shark.dto.EmpregadoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String cargo;
	private Double salario;
	@OneToMany(mappedBy = "empregado", cascade = CascadeType.ALL)
	private List<Dependente> dependentes;

	public Empregado() {
		super();
	}
	
	public Empregado(EmpregadoDto empregado) {
		this.id = empregado.getId();
		this.nome = empregado.getNome();
		this.cpf = empregado.getCpf();
		this.cargo = empregado.getCargo();
		this.salario = empregado.getSalario();
		this.dependentes = empregado.getDependentes().stream().map(Dependente::new).toList();
		this.dependentes.forEach(d -> d.setEmpregado(this));
	}

	public Empregado(Integer id, String nome, String cpf, String cargo, Double salario, List<Dependente> dependentes) {
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

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
}
