package br.com.senai.shark.service;

import org.springframework.stereotype.Service;

@Service
public class IMCService {
	
	public Double calculaIMC(Double peso, Double altura) {
		return peso / (altura * altura);
	}
	
	public String getCategoriaIMC(Double imc) {
		if (imc < 18.5) {
			return "baixo peso";
		} else if (imc < 24.9) {
			return "eutrofia (peso adequado)";
		} else if (imc < 29.9) {
			return "sobrepeso";
		} else if (imc < 34.9) {
			return "obesidade grau 1";
		} else if (imc < 39.9) {
			return "obesidade grau 2";
		}
		return "obesidade extrema";
	}

}
