package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.JogoDto;
import br.com.senai.shark.model.Jogo;
import br.com.senai.shark.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepository;
	
	public Jogo salvarJogo(JogoDto jogoDto) {
		Jogo jogo = new Jogo(jogoDto);
		return jogoRepository.save(jogo);
	}
	
	public List<Jogo> listarJogos() {
		return jogoRepository.findAll();
	}
	
	public void excluirJogo(Integer id) {
		jogoRepository.deleteById(id);
	}
	

}
