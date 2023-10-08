package br.com.senai.shark.model;

import java.util.List;

import br.com.senai.shark.dto.VendedorDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Vendedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private String nomeLoja;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor")
	private List<Pedido> pedidos;

	public Vendedor() {
	}
	
	public Vendedor(VendedorDto vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
		this.cpf = vendedor.getCpf();
		this.nomeLoja = vendedor.getNomeLoja();
		if (vendedor.getPedidos() != null) {
			this.pedidos = vendedor.getPedidos().stream().map(Pedido::new).toList();
			pedidos.forEach(p -> p.setVendedor(this));
		}
	}

	public Vendedor(Integer id, String nome, String cpf, String nomeLoja, List<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeLoja = nomeLoja;
		this.pedidos = pedidos;
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

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}
