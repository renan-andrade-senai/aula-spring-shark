package br.com.senai.shark.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JwtService {
	
	@Value("${secure.key}")
	private String key;
	
	public String createToken(String username) {
		Algorithm algorithm = Algorithm.HMAC256(key);
		return JWT.create()
				.withSubject(username)
				.withIssuedAt(Instant.now())
				.withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
				.sign(algorithm);
	}
	
	public String validateToken(String token) {
		DecodedJWT jwt = JWT.decode(token);
		if (jwt.getExpiresAtAsInstant().isBefore(Instant.now())) {
			throw new RuntimeException("Sessão expirada");
		}
		return jwt.getSubject();
	}

}
