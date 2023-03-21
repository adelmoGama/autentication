package com.gama.autentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.gama.autentication.entities.User;
import com.gama.autentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private final PasswordEncoder encoder = null;
	
	public User insert(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public List<User> findAll() {
		List<User> list = userRepository.findAll();
		return list;
	}
	
	public Optional<User> findByEmail(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user;
	}
	
	public ResponseEntity<Boolean> autentication (@RequestParam String email, @RequestParam String tryPassword) {
		// CONSULTANDO O USUÁRIO E VERIFICANDO SE O MESMO FOI ENCONTRADO PELO EMAIL. CASO NÃO TENHA SIDO JÁ RETORNO O NÃO AUTORIZADO COM O VALOR FALSO.
		Optional<User> user = findByEmail(email);
		if(user.isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
		}
		/*
		 * SE O USUÁRIO FOR ENCONTRADO ELE VAI SER BUSCADO PARA A VERIFICAÇÃO DA SENHA CRIPTOGRAFADA. PARA ISSO A SENHA PASSADA SERÁ COMPARADA 
		 * COM A DO USUÁRIO ENCONTRADO PELO MÉTODO 'matches' do encoder.
		 * CASO AS SENHAS SEJAM IGUAIS O STATUS RETORNADO SERÁ O 'OK' E CASO NÃO SERÁ RETORNADO O 'UNAUTHORIZES'.
		 */
		User userAutorized = user.get();
		boolean validation = encoder.matches(tryPassword, userAutorized.getPassword());
		HttpStatus status = (validation) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		
		return ResponseEntity.status(status).body(validation);
	}
}
