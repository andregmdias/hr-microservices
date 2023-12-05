package br.com.giannatech.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.giannatech.entities.Worker;
import br.com.giannatech.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> index() {
		return ResponseEntity.ok(workerService.list());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> show(@PathVariable Long id) {
		try {
			var worker = workerService.findById(id);
			return ResponseEntity.ok(worker);
		}catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

}
