package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.model.Pessoa;
import br.com.senai.shark.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	// INSERT OU UPDATE
	public Pessoa inserePessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	// Mesma coisa que:
	// SELECT * FROM Pessoa
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}
	
	// Mesma coisa que:
	// DELETE FROM Pessoa WHERE id = ?
	public void removerPessoa(Pessoa pessoa) {
		pessoaRepository.deleteById(pessoa.getId());
	}

}
