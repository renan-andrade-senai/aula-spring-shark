package br.com.senai.shark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.senai.shark.filter.AutenticacaoJwtFilter;
import br.com.senai.shark.repository.UsuarioRepository;
import br.com.senai.shark.service.JwtService;
import br.com.senai.shark.service.UsuarioService;

@Configuration
@EnableWebSecurity
public class AuthConfig {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UsuarioService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService());
		return provider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		AutenticacaoJwtFilter filter = new AutenticacaoJwtFilter(jwtService, usuarioRepository);
		 return http.csrf(csrf -> csrf.disable())
				 .cors(cors -> Customizer.withDefaults())
				 .authorizeHttpRequests(req -> req.requestMatchers(AntPathRequestMatcher.antMatcher("/auth/**")).permitAll())
				 .authorizeHttpRequests(req -> req.anyRequest().authenticated())
				 .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
				 .build();
	}

}
