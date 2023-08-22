package br.com.senai.shark.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public void validaIdade(Integer idade) {
		if (idade == null || idade < 10) {
			throw new RuntimeException("Idade deve ser maior ou igual a 10");
		}
	}

}
