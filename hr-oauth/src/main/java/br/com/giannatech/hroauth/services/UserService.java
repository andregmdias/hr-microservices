package br.com.giannatech.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.giannatech.hroauth.entities.User;
import br.com.giannatech.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient client;
	
	public User findByEmail(String email) {
		User user = client.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Email not found " + email);
			throw new IllegalArgumentException("User not found");
		}
		
		logger.info("Fetched email " + email );
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = client.findByEmail(username).getBody();

		if(user == null) {
			logger.error("Email not found " + username);
			throw new UsernameNotFoundException("User not found");
		}
		
		logger.info("Fetched email " + username );
		return user;
	}
	
	
}
