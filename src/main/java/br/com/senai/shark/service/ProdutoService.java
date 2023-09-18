package br.com.senai.shark.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.shark.dto.ProdutoDto;
import br.com.senai.shark.model.Produto;
import br.com.senai.shark.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(ProdutoDto produtoDto) {
		Produto produto = new Produto(produtoDto);
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarProduto() {
		return produtoRepository.findAll();
	}
	
	public void excluirProduto(Integer id) {
		produtoRepository.deleteById(id);
	}

}
