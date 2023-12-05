package br.com.giannatech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.giannatech.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
