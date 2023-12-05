package br.com.giannatech.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.giannatech.entities.Worker;
import br.com.giannatech.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	public List<Worker> list(){
		return repository.findAll();
	}
	
	public Worker findById(Long id) {
		return repository.findById(id)
				.orElseThrow(
					() -> new EntityNotFoundException("Resource not found")
				);
	}
}
