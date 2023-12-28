package br.com.giannatech.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

import br.com.giannatech.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
