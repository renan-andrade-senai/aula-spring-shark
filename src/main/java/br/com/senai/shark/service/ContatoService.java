package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.ContatoDto;
import br.com.senai.shark.model.Contato;
import br.com.senai.shark.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	public Contato salvarContato(ContatoDto contatoDto) {
		Contato contato = new Contato(contatoDto);
		return contatoRepository.save(contato);
	}
	
	public List<Contato> listarContatos() {
		return contatoRepository.findAll();
	}
	
	public void excluirContato(Integer id) {
		contatoRepository.deleteById(id);
	}
	
	public List<Contato> listarPorNomeTipo(String nome, String tipo, Pageable pageable) {
		return contatoRepository.findByNomeAndTipo(nome, tipo, pageable);
	}

}
