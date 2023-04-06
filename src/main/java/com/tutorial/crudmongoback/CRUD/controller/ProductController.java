package com.tutorial.crudmongoback.CRUD.controller;

import com.tutorial.crudmongoback.CRUD.dto.UsuarioDto;
import com.tutorial.crudmongoback.CRUD.entity.Usuario;
import com.tutorial.crudmongoback.CRUD.service.UsuarioService;
import com.tutorial.crudmongoback.global.dto.MessageDto;
import com.tutorial.crudmongoback.global.exceptions.AttributeException;
import com.tutorial.crudmongoback.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    UsuarioService usuarioService;
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'RECEPCIONISTA')")
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.getAll());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER', 'ROLE_RECEPCIONISTA')")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getOne(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(usuarioService.getOne(id));
    }

    @PreAuthorize("hasRole('ADMIN','RECEPCIONISTA')")
    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody UsuarioDto dto) throws AttributeException {
    	Usuario product = usuarioService.save(dto);
        String message = "product " + product.getNombre() + " have been saved";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_RECEPCIONISTA')")
    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") int id, @Valid @RequestBody UsuarioDto dto) throws ResourceNotFoundException, AttributeException {
    	Usuario product = usuarioService.update(id, dto);
        String message = "product " + product.getNombre() + " have been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_RECEPCIONISTA')")
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
    	Usuario product = usuarioService.delete(id);
        String message = "product " + product.getNombre() + " have been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
