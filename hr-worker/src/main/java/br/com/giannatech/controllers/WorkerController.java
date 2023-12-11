package br.com.giannatech.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService workerService;

	@GetMapping
	public ResponseEntity<List<Worker>> index() {
		return ResponseEntity.ok(workerService.list());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> show(@PathVariable Long id) {
		logger.info("PORT = " + env.getProperty("local.server.port"));

		return ResponseEntity.ok(workerService.findById(id));

	}

}
