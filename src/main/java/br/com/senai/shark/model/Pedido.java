package br.com.senai.shark.model;

import java.time.LocalDate;

import br.com.senai.shark.dto.PedidoDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double valor;
	private LocalDate dtEmissao;
	private Integer qtItens;
	@JoinColumn(name = "vendedor_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Vendedor vendedor;

	public Pedido() {
	}
	
	public Pedido(PedidoDto pedido) {
		this.id = pedido.getId();
		this.valor = pedido.getValor();
		this.dtEmissao = pedido.getDtEmissao();
		this.qtItens = pedido.getQtItens();
	}

	public Pedido(Integer id, Double valor, LocalDate dtEmissao, Integer qtItens, Vendedor vendedor) {
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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
