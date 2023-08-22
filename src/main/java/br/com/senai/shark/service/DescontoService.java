package br.com.senai.shark.service;

import org.springframework.stereotype.Service;

@Service
public class DescontoService {
	
	public Double getPercentual(Double valor) {
		if (valor <= 1500) {
			return 5d;
		} else if (valor <= 10000) {
			return 10d;
		}
		return 12d;
	}
	
	public Double calculaValorDesconto(Double valor) {
		return valor * getPercentual(valor) / 100;
	}
	
	public Double calculaValorDescontado(Double valor) {
		return valor - calculaValorDesconto(valor);
	}

}
