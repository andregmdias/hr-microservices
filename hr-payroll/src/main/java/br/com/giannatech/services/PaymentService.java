package br.com.giannatech.services;

import org.springframework.stereotype.Service;

import br.com.giannatech.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Bob", 200.0, days);
	}
}
