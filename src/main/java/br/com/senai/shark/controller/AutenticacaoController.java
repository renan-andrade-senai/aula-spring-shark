package br.com.senai.shark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.shark.dto.UsuarioDto;
import br.com.senai.shark.model.Usuario;
import br.com.senai.shark.service.JwtService;
import br.com.senai.shark.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/registrar")
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario usuario = usuarioService.salvarUsuario(usuarioDto);
		usuario.setSenha(null);
		return ResponseEntity.ok(new UsuarioDto(usuario));
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> fazerLogin(@RequestBody UsuarioDto usuarioDto) {
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuarioDto.getEmail(), usuarioDto.getSenha());
		Authentication authentication = authenticationManager.authenticate(user);
		if (authentication.isAuthenticated()) {
			String token = jwtService.createToken(usuarioDto.getEmail());
			return ResponseEntity.ok(token);
		}
		throw new RuntimeException("Usuário ou senha inválidos");
	}
	
	@GetMapping("/validate/{token}")
	public ResponseEntity<Void> validarToken(@PathVariable String token) {
		try {
			jwtService.validateToken(token);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
	}

}
