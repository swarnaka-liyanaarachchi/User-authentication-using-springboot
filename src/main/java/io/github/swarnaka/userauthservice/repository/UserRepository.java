package io.github.swarnaka.userauthservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.swarnaka.userauthservice.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	 Optional<User> findByUsername(String username);

}
