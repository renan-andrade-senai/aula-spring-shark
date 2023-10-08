package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.VendedorDto;
import br.com.senai.shark.model.Vendedor;
import br.com.senai.shark.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	public Vendedor salvarVendedor(VendedorDto vendedorDto) {
		Vendedor vendedor = new Vendedor(vendedorDto);
		return vendedorRepository.save(vendedor);
	}
	
	public List<Vendedor> listarVendedores() {
		return vendedorRepository.findAll();
	}
	
	public void excluirVendedor(Integer id) {
		vendedorRepository.deleteById(id);
	}

}
