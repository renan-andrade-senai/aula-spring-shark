package br.com.senai.shark.filter;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.senai.shark.model.Usuario;
import br.com.senai.shark.repository.UsuarioRepository;
import br.com.senai.shark.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutenticacaoJwtFilter extends OncePerRequestFilter {
	
	private JwtService jwtService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoJwtFilter(JwtService jwtService, UsuarioRepository usuarioRepository) {
		this.jwtService = jwtService;
		this.usuarioRepository = usuarioRepository;
	}
	
	private String recuperarToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!request.getRequestURI().contains("/auth")) {
			String token = recuperarToken(request);
			String email = jwtService.validateToken(token);
			autenticarUsuario(email);
		}
		filterChain.doFilter(request, response);
	}
	
	private void autenticarUsuario(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		UsernamePasswordAuthenticationToken authentication = 
				new UsernamePasswordAuthenticationToken(usuario.orElseThrow(() -> new RuntimeException("Usuário ou senha inválidos")), 
				null, null);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
