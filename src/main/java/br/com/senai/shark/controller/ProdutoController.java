package br.com.senai.shark.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.ProdutoDto;
import br.com.senai.shark.model.Produto;
import br.com.senai.shark.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrarProduto(@RequestBody ProdutoDto produtoDto) {
		Produto produto = produtoService.salvarProduto(produtoDto);
		return ResponseEntity.ok(new ProdutoDto(produto));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDto>> listarProduto() {
		List<Produto> produtos = produtoService.listarProduto();
		List<ProdutoDto> produtosDto = produtos.stream().map(ProdutoDto::new).toList();
		return ResponseEntity.ok(produtosDto);
	}
	
	@GetMapping("/portituloprazo")
	public ResponseEntity<List<ProdutoDto>> listarProdutoPorTituloPrazo(@RequestParam String titulo, 
			@RequestParam LocalDate prazo, @PageableDefault Pageable pageable) {
		List<Produto> produtos = produtoService.listarProdutoPorTituloPrazo(titulo, prazo, pageable);
		List<ProdutoDto> produtosDto = produtos.stream().map(ProdutoDto::new).toList();
		return ResponseEntity.ok(produtosDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirProduto(@PathVariable Integer id) {
		produtoService.excluirProduto(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@PutMapping
	public ResponseEntity<ProdutoDto> atualizarProduto(@RequestBody ProdutoDto produtoDto) {
		Produto produto = produtoService.salvarProduto(produtoDto);
		return ResponseEntity.ok(new ProdutoDto(produto));
	}

}
