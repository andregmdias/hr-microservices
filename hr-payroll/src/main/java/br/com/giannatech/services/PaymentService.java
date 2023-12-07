package br.com.giannatech.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.giannatech.entities.Payment;
import br.com.giannatech.entities.Worker;
import br.com.giannatech.feignclients.WorkerFeignClient;

@Service
public class PaymentService {


	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workerId, Integer days) {
		
		Worker worker = workerFeignClient.show(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
