package br.com.senai.shark.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.ClienteDto;
import br.com.senai.shark.model.Cliente;
import br.com.senai.shark.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvarCliente(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto);
		return clienteRepository.save(cliente);
	}
	
	public void excluirCliente(Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}
	
	public List<Cliente> listarClientePorEndereco(String endereco, Pageable pageable) {
		endereco = "%" + endereco + "%";
		return clienteRepository.findByEnderecoLike(endereco, pageable);
	}
	
	public List<Cliente> listarClientePorDtNascimento(LocalDate dtNascimento, Pageable pageable) {
		return clienteRepository.findByDtNascimento(dtNascimento, pageable);
	}

}
