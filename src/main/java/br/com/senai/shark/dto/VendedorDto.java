package br.com.senai.shark.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.senai.shark.model.Vendedor;

public class VendedorDto {

	private Integer id;
	private String nome;
	private String cpf;
	private String nomeLoja;
	@JsonManagedReference
	private List<PedidoDto> pedidos;

	public VendedorDto() {
	}
	
	public VendedorDto(Vendedor vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
		this.cpf = vendedor.getCpf();
		this.nomeLoja = vendedor.getNomeLoja();
		if (vendedor.getPedidos() != null) {
			this.pedidos = vendedor.getPedidos().stream().map(PedidoDto::new).toList();
			pedidos.forEach(p -> p.setVendedor(this));
		}
	}

	public VendedorDto(Integer id, String nome, String cpf, String nomeLoja, List<PedidoDto> pedidos) {
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

	public List<PedidoDto> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoDto> pedidos) {
		this.pedidos = pedidos;
	}

}
