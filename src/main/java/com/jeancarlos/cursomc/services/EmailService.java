package com.jeancarlos.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.jeancarlos.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
}
