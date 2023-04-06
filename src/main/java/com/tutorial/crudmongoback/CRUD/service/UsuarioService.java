package com.tutorial.crudmongoback.CRUD.service;

import com.tutorial.crudmongoback.CRUD.dto.UsuarioDto;
import com.tutorial.crudmongoback.CRUD.entity.Usuario;
import com.tutorial.crudmongoback.CRUD.repository.UsuarioRepository;
import com.tutorial.crudmongoback.global.exceptions.AttributeException;
import com.tutorial.crudmongoback.global.exceptions.ResourceNotFoundException;
import com.tutorial.crudmongoback.global.utils.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getOne(int id) throws ResourceNotFoundException {
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
    }

    public Usuario save(UsuarioDto dto) throws AttributeException {
        if(usuarioRepository.existsByNombre(dto.getNombre()))
            throw new AttributeException("name already in use");
        int id = Operations.autoIncrement(usuarioRepository.findAll());
        Usuario product = new Usuario(id, dto.getNombre(), dto.getEdad(), dto.getTelefono(),dto.getCorreo());
        return usuarioRepository.save(product);
    }

    public Usuario update(int id, UsuarioDto dto) throws ResourceNotFoundException, AttributeException {
    	Usuario product = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));
        if(usuarioRepository.existsByNombre(dto.getNombre()) && usuarioRepository.findByNombre(dto.getNombre()).get().getId() != id)
            throw new AttributeException("name already in use");
        product.setNombre(dto.getNombre());
        product.setEdad(dto.getEdad());
        product.setTelefono(dto.getTelefono());
        product.setCorreo(dto.getCorreo());
        return usuarioRepository.save(product);
    }

    public Usuario delete(int id) throws ResourceNotFoundException {
    	Usuario product = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("not found"));;
                usuarioRepository.delete(product);
        return product;
    }


}
