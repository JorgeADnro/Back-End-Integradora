package com.tutorial.crudmongoback.security.repository;

import com.tutorial.crudmongoback.security.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserEntityRepository extends MongoRepository<UserEntity, Integer>{
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);
	
	Optional<UserEntity> findByUsernameOrEmail(String username, String email);
}
