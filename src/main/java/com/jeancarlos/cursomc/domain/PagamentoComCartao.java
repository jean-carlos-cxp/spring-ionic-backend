package com.jeancarlos.cursomc.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.jeancarlos.cursomc.domain.enums.EstadoPagamento;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer qtdParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer qtdParcelas) {
		super(id, estado, pedido);
		this.qtdParcelas = qtdParcelas;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	
}
