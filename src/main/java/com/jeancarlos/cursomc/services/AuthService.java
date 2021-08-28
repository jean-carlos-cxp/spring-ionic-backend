package com.jeancarlos.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jeancarlos.cursomc.domain.Cliente;
import com.jeancarlos.cursomc.repositories.ClienteRepository;
import com.jeancarlos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(cliente, newPass);
	}
	
	private String newPassword() {
		char[] vect = new char[10];
		for (int i=0; i<10; i++) {
			vect[i] = randomChar();
		}
		return new String(vect);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		
		switch (opt) {
		case 0: // Gera um digito
			return (char) (rand.nextInt(10) + 48);
			
		case 1: // Gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);

		default: // Gera letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
