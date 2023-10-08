package br.com.senai.shark.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.senai.shark.model.Pedido;

public class PedidoDto {

	private Integer id;
	private Double valor;
	private LocalDate dtEmissao;
	private Integer qtItens;
	@JsonBackReference
	private VendedorDto vendedor;

	public PedidoDto() {
	}
	
	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.valor = pedido.getValor();
		this.dtEmissao = pedido.getDtEmissao();
		this.qtItens = pedido.getQtItens();
	}

	public PedidoDto(Integer id, Double valor, LocalDate dtEmissao, Integer qtItens, VendedorDto vendedor) {
		this.id = id;
		this.valor = valor;
		this.dtEmissao = dtEmissao;
		this.qtItens = qtItens;
		this.vendedor = vendedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(LocalDate dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public Integer getQtItens() {
		return qtItens;
	}

	public void setQtItens(Integer qtItens) {
		this.qtItens = qtItens;
	}

	public VendedorDto getVendedor() {
		return vendedor;
	}

	public void setVendedor(VendedorDto vendedor) {
		this.vendedor = vendedor;
	}

}
