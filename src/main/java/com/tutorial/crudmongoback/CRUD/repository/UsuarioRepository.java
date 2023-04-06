package com.tutorial.crudmongoback.CRUD.repository;

import com.tutorial.crudmongoback.CRUD.entity.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, Integer> {
    boolean existsByNombre(String nombre);
    Optional<Usuario> findByNombre(String nombre);
}
