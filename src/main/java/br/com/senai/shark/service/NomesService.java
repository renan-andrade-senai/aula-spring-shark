package br.com.senai.shark.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NomesService {
	
	public void ordenaNomes(List<String> nomes) {
		Collections.sort(nomes);
	}

}
