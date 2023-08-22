package br.com.senai.shark.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NotaService {
	
	public double calculaMedia(String notas) {
//		String[] notasVetor = notas.split(",");
		List<String> notasList = Arrays.asList(notas.split(","));
		double soma = 0.0;
		for (String nota : notasList) {
			soma += Double.parseDouble(nota);
		}
		double media = soma/notasList.size();
		return media;
	}

}
