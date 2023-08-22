package br.com.senai.shark.service;

import org.springframework.stereotype.Service;

@Service
public class GeometriaService {
	
	public Double calculaArea(String tipo, Double l1, Double l2, Double altura, Double raio) {
		switch (tipo) {
			case "circulo": {
				return Math.PI * Math.pow(raio, 2);
			}
			case "quadrado": {
				return l1 * l1;
			}
			case "retangulo": {
				return l1 * l2;
			}
			case "triangulo": {
				return l1 * altura / 2;
			}
			case "trapezio": {
				return (l1 + l2) * altura / 2;
			}
		}
		return 0d;
	}

}
