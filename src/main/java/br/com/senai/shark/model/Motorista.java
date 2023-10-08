package br.com.senai.shark.model;

import java.time.LocalDate;
import java.util.List;

import br.com.senai.shark.dto.MotoristaDto;
import br.com.senai.shark.dto.VeiculoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Motorista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnh;
	private LocalDate dtNascimento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "motorista")
	private List<Veiculo> veiculos;

	public Motorista() {
	}
	
	public Motorista(MotoristaDto motorista) {
		this.id = motorista.getId();
		this.nome = motorista.getNome();
		this.cnh = motorista.getCnh();
		this.dtNascimento = motorista.getDtNascimento();
		if (motorista.getVeiculos() != null) {
			this.veiculos = motorista.getVeiculos().stream().map(Veiculo::new).toList();
			veiculos.forEach(v -> v.setMotorista(this));
		}
	}

	public Motorista(Integer id, String nome, String cnh, LocalDate dtNascimento, List<Veiculo> veiculos) {
		this.id = id;
		this.nome = nome;
		this.cnh = cnh;
		this.dtNascimento = dtNascimento;
		this.veiculos = veiculos;
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

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
